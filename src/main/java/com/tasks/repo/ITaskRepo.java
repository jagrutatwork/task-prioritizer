package com.tasks.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasks.model.Task;

@Repository
public interface ITaskRepo extends JpaRepository<Task, Integer>{

	 List<Task> findByUserId(Integer userId);
	 
	/*
     * The following methods are inherited from JpaRepository:
     *
     * List<Task> findAll();
     *     - Retrieves all Task entities from the database.
     *
     * Optional<Task> findById(Integer id);
     *     - Retrieves a Task by its ID, if it exists.
     *
     * Task save(Task task);
     *     - Saves a Task entity (inserts if new, updates if existing).
     *
     * void delete(Task task);
     *     - Deletes the given Task entity.
     *
     * void deleteById(Integer id);
     *     - Deletes a Task by its ID.
     *
     * long count();
     *     - Returns the total number of Task entities.
     *
     * boolean existsById(Integer id);
     *     - Checks if a Task exists for the given ID.
     */
	

}
