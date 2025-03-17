package com.tasks.controller;

import com.tasks.model.Task;
import com.tasks.model.Task.PriorityLevel;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/tasks")
public interface ITaskController {
    
    /**
     * Retrieves a task by its ID.
     * Example URL: GET /tasks/{taskId}
     */
    @GetMapping("/{taskId}")
    Optional<Task> getTask(@PathVariable("taskId") Integer taskId);
    
    /**
     * Retrieves all tasks for a given user.
     * Example URL: GET /tasks?userId=123
     */
    @GetMapping
    List<Task> getTasks(@RequestParam("userId") Integer userId);
    
    /**
     * Adds a new task.
     * Example URL: POST /tasks
     * Expects a Task object in the request body.
     */
    @PostMapping
    Task addTask(@RequestBody Task task);
    
    /**
     * Changes the priority of a task.
     * Example URL: PUT /tasks/{taskId}/priority?priority=HIGH
     */
    @PutMapping("/{taskId}/priority")
    void changePriority(@PathVariable("taskId") Integer taskId, 
                        @RequestParam("priority") PriorityLevel priority);
    
    /**
     * Edits an existing task.
     * Example URL: PUT /tasks
     * Expects a Task object in the request body.
     */
    @PutMapping
    void editTask(@RequestBody Task task);
}
