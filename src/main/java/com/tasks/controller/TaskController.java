package com.tasks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.model.Task;
import com.tasks.model.Task.PriorityLevel;
import com.tasks.service.TaskService;


@RestController
@RequestMapping("/tasks")
public class TaskController implements ITaskController{
	
	@Autowired
	TaskService taskService;
	
	@Override
	@GetMapping("/{taskId}")
	public Optional<Task> getTask(@PathVariable("taskId") Integer taskId) {
		return taskService.getTask(taskId);
	}

	@Override
	@GetMapping
	public List<Task> getTasks(@RequestParam("userId") Integer userId) {
		return taskService.getTasks(userId);
	}

	@Override
	@PostMapping
	public Task addTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}

	@Override
	@PostMapping("/{taskId}/priority")
	public void changePriority(@PathVariable("taskId") Integer taskId, @RequestParam("priority") PriorityLevel priority) {
	      taskService.changePriority(taskId, priority);
	}

	@Override
	@PostMapping
	public void editTask(@RequestBody Task task) {
		  taskService.editTask(task);
	}

}
