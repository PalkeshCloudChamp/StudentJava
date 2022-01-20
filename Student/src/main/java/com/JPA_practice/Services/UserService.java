package com.JPA_practice.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.JPA_practice.JPA_User;
import com.JPA_practice.repository.UserRepo;

@Service
public class UserService {
	private UserRepo user_repo_obj;
	
	public List<JPA_User> getAllUsers(){
		List<JPA_User> res = new ArrayList<>();
		System.out.println(user_repo_obj.findAll());
		return res;
	}
}
