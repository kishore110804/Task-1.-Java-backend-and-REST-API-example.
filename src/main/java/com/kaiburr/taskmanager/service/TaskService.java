package com.kaiburr.taskmanager.service;

import com.kaiburr.taskmanager.exception.InvalidCommandException;
import com.kaiburr.taskmanager.exception.ResourceNotFoundException;
import com.kaiburr.taskmanager.model.Task;
import com.kaiburr.taskmanager.model.TaskExecution;
import com.kaiburr.taskmanager.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Service layer for Task management
 * Contains business logic, validation, and command execution
 */
@Service
@Slf4j
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    // List of dangerous commands/patterns that should be blocked
    private static final List<String> DANGEROUS_COMMANDS = Arrays.asList(
        "rm", "delete", "del", "format", "mkfs",           // File deletion/formatting
        "sudo", "su", "chmod", "chown",                    // Privilege escalation
        "curl", "wget", "nc", "netcat",                    // Network tools (can download malicious files)
        "dd", "fdisk", "parted",                           // Disk operations
        "killall", "pkill",                                // Process killing
        "iptables", "ufw", "firewall",                     // Firewall manipulation
        "reboot", "shutdown", "halt", "poweroff",          // System control
        "useradd", "userdel", "passwd",                    // User management
        "crontab",                                         // Task scheduling
        ">", ">>",                                         // File redirection (can overwrite system files)
        "&&", "||"                                         // Command chaining
    );
    
    private static final Pattern PIPE_PATTERN = Pattern.compile("\\|");
    private static final Pattern REDIRECT_PATTERN = Pattern.compile("[>&<]");
    
    /**
     * Get all tasks from the database
     */
    public List<Task> getAllTasks() {
        log.info("Fetching all tasks");
        return taskRepository.findAll();
    }
    
    /**
     * Get a task by ID
     * @throws ResourceNotFoundException if task not found
     */
    public Task getTaskById(String id) {
        log.info("Fetching task with id: {}", id);
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
    }
    
    /**
     * Create or update a task
     * Validates the command before saving
     */
    public Task createOrUpdateTask(Task task) {
        log.info("Creating/updating task: {}", task.getName());
        
        // Validate command for security
        validateCommand(task.getCommand());
        
        // If taskExecutions is null, initialize it
        if (task.getTaskExecutions() == null) {
            task.setTaskExecutions(List.of());
        }
        
        return taskRepository.save(task);
    }
    
    /**
     * Delete a task by ID
     * @throws ResourceNotFoundException if task not found
     */
    public void deleteTask(String id) {
        log.info("Deleting task with id: {}", id);
        Task task = getTaskById(id); // This will throw exception if not found
        taskRepository.delete(task);
        log.info("Task deleted successfully: {}", id);
    }
    
    /**
     * Search tasks by name
     * @return list of tasks with names containing the search string (case-insensitive)
     */
    public List<Task> searchTasksByName(String name) {
        log.info("Searching tasks by name: {}", name);
        List<Task> tasks = taskRepository.findByNameContainingIgnoreCase(name);
        
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found with name containing: " + name);
        }
        
        return tasks;
    }
    
    /**
     * Execute a task's command and store the execution result
     * @throws ResourceNotFoundException if task not found
     */
    public TaskExecution executeTask(String taskId) {
        log.info("Executing task with id: {}", taskId);
        
        Task task = getTaskById(taskId);
        
        TaskExecution execution = new TaskExecution();
        execution.setStartTime(new Date());
        
        try {
            // Execute the command
            String output = executeShellCommand(task.getCommand());
            execution.setOutput(output);
            execution.setStatus("success");
            log.info("Task executed successfully: {}", taskId);
            
        } catch (Exception e) {
            log.error("Error executing task: {}", taskId, e);
            execution.setOutput("Error: " + e.getMessage());
            execution.setStatus("failed");
            execution.setErrorMessage(e.getMessage());
        }
        
        execution.setEndTime(new Date());
        
        // Add execution to task history
        task.getTaskExecutions().add(execution);
        taskRepository.save(task);
        
        return execution;
    }
    
    /**
     * Validate command for security
     * Blocks dangerous commands and patterns
     * @throws InvalidCommandException if command contains unsafe code
     */
    private void validateCommand(String command) {
        if (command == null || command.trim().isEmpty()) {
            throw new InvalidCommandException("Command cannot be empty");
        }
        
        String lowerCommand = command.toLowerCase().trim();
        
        // Check for dangerous commands
        for (String dangerous : DANGEROUS_COMMANDS) {
            if (lowerCommand.contains(dangerous)) {
                throw new InvalidCommandException(command, 
                    "Command contains potentially dangerous operation: " + dangerous);
            }
        }
        
        // Check for pipe operations (can chain dangerous commands)
        if (PIPE_PATTERN.matcher(command).find()) {
            throw new InvalidCommandException(command, 
                "Pipe operations (|) are not allowed for security reasons");
        }
        
        // Check for file redirection (can overwrite system files)
        if (REDIRECT_PATTERN.matcher(command).find()) {
            throw new InvalidCommandException(command, 
                "File redirection (>, >>, <) is not allowed for security reasons");
        }
        
        // Check command length
        if (command.length() > 1000) {
            throw new InvalidCommandException(command, 
                "Command is too long (max 1000 characters)");
        }
        
        log.info("Command validation passed: {}", command);
    }
    
    /**
     * Execute a shell command and return the output
     * Supports both Windows and Unix-like systems
     */
    private String executeShellCommand(String command) throws Exception {
        StringBuilder output = new StringBuilder();
        
        try {
            // Determine OS and set appropriate shell
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;
            
            if (os.contains("win")) {
                // Windows
                processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            } else {
                // Unix/Linux/Mac
                processBuilder = new ProcessBuilder("sh", "-c", command);
            }
            
            processBuilder.redirectErrorStream(true); // Combine stdout and stderr
            Process process = processBuilder.start();
            
            // Read output
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );
            
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            // Wait for process to complete (with timeout)
            boolean finished = process.waitFor(30, java.util.concurrent.TimeUnit.SECONDS);
            
            if (!finished) {
                process.destroyForcibly();
                throw new Exception("Command execution timeout (30 seconds)");
            }
            
            int exitCode = process.exitValue();
            if (exitCode != 0) {
                output.append("\n[Exit Code: ").append(exitCode).append("]");
            }
            
        } catch (Exception e) {
            log.error("Error executing command: {}", command, e);
            throw new Exception("Failed to execute command: " + e.getMessage());
        }
        
        return output.toString().trim();
    }
}
