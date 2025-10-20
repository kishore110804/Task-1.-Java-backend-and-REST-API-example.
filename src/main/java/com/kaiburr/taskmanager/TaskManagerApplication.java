package com.kaiburr.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application Class for Task Manager API
 * 
 * This application provides REST API endpoints for managing and executing tasks.
 * Tasks represent shell commands that can be run and their execution history is tracked.
 * 
 * @author Kaiburr Assessment - Task 1
 * @version 1.0.0
 */
@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
        System.out.println("\n=================================================");
        System.out.println("✅ Task Manager API Started Successfully!");
        System.out.println("📍 Server: http://localhost:8080");
        System.out.println("📚 API Docs: http://localhost:8080/swagger-ui.html");
        System.out.println("📊 Health Check: http://localhost:8080/actuator/health");
        System.out.println("=================================================\n");
    }
}
