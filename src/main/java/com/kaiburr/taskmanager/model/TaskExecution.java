package com.kaiburr.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TaskExecution represents a single execution of a task command.
 * Each time a task is executed, a new TaskExecution object is created
 * and added to the task's execution history.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskExecution {
    
    /**
     * Start time of the command execution
     */
    private Date startTime;
    
    /**
     * End time of the command execution
     */
    private Date endTime;
    
    /**
     * Output/result from the command execution
     * Contains stdout and stderr combined
     */
    private String output;
    
    /**
     * Execution status (success, failed, timeout, etc.)
     */
    private String status;
    
    /**
     * Error message if execution failed
     */
    private String errorMessage;

    /**
     * Constructor without status and error fields (for backward compatibility)
     */
    public TaskExecution(Date startTime, Date endTime, String output) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.output = output;
        this.status = "completed";
    }
}
