package com.tasks.service;

import com.tasks.model.Task;
import com.tasks.model.Task.PriorityLevel;
import com.tasks.repo.ITaskRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {
	
	private final ITaskRepo taskRepo;
	
	
	public TaskService(ITaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}
    

    @Override
    public Optional <Task> getTask(Integer taskId) {
        return taskRepo.findById(taskId);
    }

    @Override
    public List<Task> getTasks(Integer userId) {
        return taskRepo.findByUserId(userId);
    }

    @Override
    public Task addTask(Task task) {
        return taskRepo.save(task);
    }


    @Override
    public void changePriority(Integer taskId, PriorityLevel priority) {
        getTask(taskId).ifPresent(task -> {
            task.setPriority(priority);
            taskRepo.save(task);
        });
		
    }

    @Override
    public void editTask(Task task) {
        // Assuming task contains the updated fields and a valid ID.
        taskRepo.save(task);
    }
}
