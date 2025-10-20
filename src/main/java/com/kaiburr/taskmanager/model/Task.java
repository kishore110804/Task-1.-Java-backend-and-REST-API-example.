package com.kaiburr.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Task entity represents a shell command that can be executed.
 * Each task has an execution history stored in taskExecutions list.
 * 
 * Example:
 * {
 *   "id": "123",
 *   "name": "Print Hello",
 *   "owner": "John Smith",
 *   "command": "echo Hello World!",
 *   "taskExecutions": [...]
 * }
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {
    
    /**
     * Unique identifier for the task
     */
    @Id
    private String id;
    
    /**
     * Human-readable name for the task
     */
    @NotBlank(message = "Task name is required")
    @Size(min = 3, max = 100, message = "Task name must be between 3 and 100 characters")
    private String name;
    
    /**
     * Owner/creator of the task
     */
    @NotBlank(message = "Owner is required")
    @Size(min = 2, max = 100, message = "Owner name must be between 2 and 100 characters")
    private String owner;
    
    /**
     * Shell command to be executed
     * Will be validated for security before execution
     */
    @NotBlank(message = "Command is required")
    @Size(min = 1, max = 1000, message = "Command must be between 1 and 1000 characters")
    private String command;
    
    /**
     * List of all executions for this task
     * Each time the task is executed, a new TaskExecution is added
     */
    private List<TaskExecution> taskExecutions;
    
    /**
     * Initialize taskExecutions list to avoid null pointer exceptions
     */
    public Task(String id, String name, String owner, String command) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.command = command;
        this.taskExecutions = new ArrayList<>();
    }
    
    /**
     * Ensure taskExecutions is never null
     */
    public List<TaskExecution> getTaskExecutions() {
        if (taskExecutions == null) {
            taskExecutions = new ArrayList<>();
        }
        return taskExecutions;
    }
}
