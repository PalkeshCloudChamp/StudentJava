package com.example.demo.JPA_practice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.JPA_practice.users;
public interface JPA_repo  extends CrudRepository<users, Integer>{
	
	users findById(int UserId);
	List<users> findAll();
	void deleteById(int UserId);

}
