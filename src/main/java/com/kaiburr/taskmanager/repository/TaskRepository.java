package com.kaiburr.taskmanager.repository;

import com.kaiburr.taskmanager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Task entity
 * Provides CRUD operations and custom query methods
 * 
 * Spring Data MongoDB will automatically implement this interface
 */
@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    
    /**
     * Find tasks by name containing the given string (case-insensitive)
     * 
     * Example: findByNameContainingIgnoreCase("hello") 
     * will find tasks with names like "Print Hello", "hello world", "HELLO", etc.
     * 
     * @param name the string to search for in task names
     * @return list of tasks matching the search criteria
     */
    List<Task> findByNameContainingIgnoreCase(String name);
    
    /**
     * Find tasks by owner (exact match, case-insensitive)
     * 
     * @param owner the owner name to search for
     * @return list of tasks owned by the specified owner
     */
    List<Task> findByOwnerIgnoreCase(String owner);
    
    /**
     * Find tasks by owner containing the given string (case-insensitive)
     * 
     * @param owner the string to search for in owner names
     * @return list of tasks matching the search criteria
     */
    List<Task> findByOwnerContainingIgnoreCase(String owner);
}
