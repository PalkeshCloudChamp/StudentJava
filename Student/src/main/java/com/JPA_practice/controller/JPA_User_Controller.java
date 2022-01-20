package com.JPA_practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JPA_practice.JPA_User;
import com.JPA_practice.Services.UserService;

@RestController
@RequestMapping("/")
public class JPA_User_Controller {
	
	private UserService US_obj;
//	@GetMapping("/")
//	public List<JPA_User> getAllUser(){
//		return US_obj.getAllUsers();
//	}
	@GetMapping("/")
	public String getAllUser(){
		return "Hello";
	}
	
}
