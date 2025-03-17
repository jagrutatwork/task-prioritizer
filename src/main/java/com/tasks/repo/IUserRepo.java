package com.tasks.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasks.model.Task;
import com.tasks.model.User;

@Repository
public interface IUserRepo extends JpaRepository<Task, Integer>{

	Optional<User> findByUsername(String username);
	 

}
