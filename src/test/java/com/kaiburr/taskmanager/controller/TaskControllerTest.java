package com.kaiburr.taskmanager.controller;

import com.kaiburr.taskmanager.model.Task;
import com.kaiburr.taskmanager.model.TaskExecution;
import com.kaiburr.taskmanager.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for TaskController
 */
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TaskService taskService;

    private Task sampleTask;

    @BeforeEach
    void setUp() {
        sampleTask = new Task();
        sampleTask.setId("123");
        sampleTask.setName("Test Task");
        sampleTask.setOwner("John Doe");
        sampleTask.setCommand("echo Hello");
    }

    @Test
    void testGetAllTasks() throws Exception {
        List<Task> tasks = Arrays.asList(sampleTask);
        when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("123"))
                .andExpect(jsonPath("$[0].name").value("Test Task"));
    }

    @Test
    void testGetTaskById() throws Exception {
        when(taskService.getTaskById("123")).thenReturn(sampleTask);

        mockMvc.perform(get("/api/tasks").param("id", "123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.name").value("Test Task"));
    }

    @Test
    void testCreateTask() throws Exception {
        when(taskService.createOrUpdateTask(any(Task.class))).thenReturn(sampleTask);

        mockMvc.perform(put("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sampleTask)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("123"));
    }

    @Test
    void testDeleteTask() throws Exception {
        mockMvc.perform(delete("/api/tasks/123"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("deleted successfully")));
    }

    @Test
    void testSearchTasks() throws Exception {
        List<Task> tasks = Arrays.asList(sampleTask);
        when(taskService.searchTasksByName(anyString())).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks/search").param("name", "Test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Task"));
    }

    @Test
    void testExecuteTask() throws Exception {
        TaskExecution execution = new TaskExecution(new Date(), new Date(), "Hello", "success", null);
        when(taskService.executeTask("123")).thenReturn(execution);

        mockMvc.perform(put("/api/tasks/123/execute"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.output").value("Hello"))
                .andExpect(jsonPath("$.status").value("success"));
    }
}
