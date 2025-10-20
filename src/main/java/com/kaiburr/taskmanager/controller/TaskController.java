package com.kaiburr.taskmanager.controller;

import com.kaiburr.taskmanager.model.Task;
import com.kaiburr.taskmanager.model.TaskExecution;
import com.kaiburr.taskmanager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Task Management
 * Provides endpoints for CRUD operations and task execution
 * 
 * Base URL: /api/tasks
 */
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // Allow CORS for React frontend
@Tag(name = "Task Management", description = "APIs for managing and executing tasks")
@Slf4j
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    /**
     * GET /api/tasks
     * Get all tasks OR get a single task by ID
     * 
     * Query parameter: id (optional)
     * - If id is provided: return single task
     * - If id is not provided: return all tasks
     */
    @GetMapping
    @Operation(summary = "Get all tasks or a specific task by ID", 
               description = "Returns all tasks if no ID provided, otherwise returns a specific task")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved tasks"),
        @ApiResponse(responseCode = "404", description = "Task not found")
    })
    public ResponseEntity<?> getTasks(
            @Parameter(description = "Task ID (optional)")
            @RequestParam(required = false) String id) {
        
        log.info("GET /api/tasks - id: {}", id);
        
        if (id != null && !id.isEmpty()) {
            // Get single task by ID
            Task task = taskService.getTaskById(id);
            return ResponseEntity.ok(task);
        } else {
            // Get all tasks
            List<Task> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks);
        }
    }
    
    /**
     * PUT /api/tasks
     * Create or update a task
     * 
     * Request body: Task object (JSON)
     * - If id is provided and exists: update task
     * - If id is null or doesn't exist: create new task
     */
    @PutMapping
    @Operation(summary = "Create or update a task", 
               description = "Creates a new task or updates existing one. Command is validated for security.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Task updated successfully"),
        @ApiResponse(responseCode = "201", description = "Task created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid command or validation error")
    })
    public ResponseEntity<Task> createOrUpdateTask(
            @Parameter(description = "Task object to create or update")
            @Valid @RequestBody Task task) {
        
        log.info("PUT /api/tasks - Creating/updating task: {}", task.getName());
        
        boolean isUpdate = (task.getId() != null && !task.getId().isEmpty());
        Task savedTask = taskService.createOrUpdateTask(task);
        
        if (isUpdate) {
            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
        }
    }
    
    /**
     * DELETE /api/tasks/{id}
     * Delete a task by ID
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task", 
               description = "Deletes a task and all its execution history")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Task deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Task not found")
    })
    public ResponseEntity<String> deleteTask(
            @Parameter(description = "ID of the task to delete", required = true)
            @PathVariable String id) {
        
        log.info("DELETE /api/tasks/{}", id);
        
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully: " + id);
    }
    
    /**
     * GET /api/tasks/search?name=xyz
     * Find tasks by name (case-insensitive partial match)
     */
    @GetMapping("/search")
    @Operation(summary = "Search tasks by name", 
               description = "Returns all tasks with names containing the search string (case-insensitive)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tasks found"),
        @ApiResponse(responseCode = "404", description = "No tasks found")
    })
    public ResponseEntity<List<Task>> searchTasks(
            @Parameter(description = "Search string for task name", required = true)
            @RequestParam String name) {
        
        log.info("GET /api/tasks/search?name={}", name);
        
        List<Task> tasks = taskService.searchTasksByName(name);
        return ResponseEntity.ok(tasks);
    }
    
    /**
     * PUT /api/tasks/{id}/execute
     * Execute a task's command and store the result
     * 
     * Creates a new TaskExecution object with:
     * - startTime: execution start timestamp
     * - endTime: execution end timestamp
     * - output: command output (stdout + stderr)
     * - status: success/failed
     */
    @PutMapping("/{id}/execute")
    @Operation(summary = "Execute a task command", 
               description = "Executes the task's shell command and stores the execution result in task history")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Task executed successfully"),
        @ApiResponse(responseCode = "404", description = "Task not found"),
        @ApiResponse(responseCode = "500", description = "Execution failed")
    })
    public ResponseEntity<TaskExecution> executeTask(
            @Parameter(description = "ID of the task to execute", required = true)
            @PathVariable String id) {
        
        log.info("PUT /api/tasks/{}/execute", id);
        
        TaskExecution execution = taskService.executeTask(id);
        return ResponseEntity.ok(execution);
    }
    
    /**
     * GET /api/tasks/{id}/executions
     * Get execution history for a task
     */
    @GetMapping("/{id}/executions")
    @Operation(summary = "Get task execution history", 
               description = "Returns all execution records for a specific task")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Execution history retrieved"),
        @ApiResponse(responseCode = "404", description = "Task not found")
    })
    public ResponseEntity<List<TaskExecution>> getTaskExecutions(
            @Parameter(description = "ID of the task", required = true)
            @PathVariable String id) {
        
        log.info("GET /api/tasks/{}/executions", id);
        
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task.getTaskExecutions());
    }
    
    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    @Operation(summary = "Health check", description = "Check if the API is running")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Task Manager API is running! ✅");
    }
}
