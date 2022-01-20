package com.example.demo.JPA_practice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPA_service {
	@Autowired
	private JPA_repo jpa_repo_obj;
	
	public List<users> getAllUser(){
		users user1 = new users();
		user1.setUserName("Palkesh");
		user1.setPasword("Something");
		user1.setRole("Admin");
		user1.setStatus("Active");
		user1.setUserId(101);
		List<users> res = new ArrayList<>();
		res.add(user1);
		System.out.println("Inside the getAllUsers function call.");
		System.out.println(jpa_repo_obj.findAll());
//		jpa_repo_obj.findAll().forEach(user->{
//			System.out.println(user);
//		});
		return res;
	}
	
}
