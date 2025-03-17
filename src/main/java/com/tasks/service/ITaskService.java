package com.tasks.service;

import com.tasks.model.Task;
import com.tasks.model.Task.PriorityLevel;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing tasks.
 */
public interface ITaskService {
    
    /**
     * Retrieves a task by its ID.
     * 
     * @param taskId the ID of the task to retrieve
     * @return the Task with the given ID, or null if not found
     */
    Optional<Task> getTask(Integer taskId);
    
    /**
     * Retrieves all tasks.
     * 
     * @return a list of all Tasks
     */
    List<Task> getTasks(Integer userId);
    
    /**
     * Adds a new task.
     * 
     * @param task the Task to add
     * @return the added Task
     */
    Task addTask(Task task);
    
    /**
     * Changes the priority of a task.
     * 
     * @param taskId the ID of the task
     * @param priority the new priority level
     * @return 
     */
    void changePriority(Integer taskId, PriorityLevel priority);
    
    /**
     * Edits an existing task.
     * 
     * @param task the Task with updated details
     */
    void editTask(Task task);
}
