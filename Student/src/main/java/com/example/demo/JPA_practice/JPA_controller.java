package com.example.demo.JPA_practice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JPA_controller {

	private JPA_service jpa_service_obj = new JPA_service();
	@GetMapping("/")
	public String Test() {
		return "Test Api";
	}
	@GetMapping("/users")
	public List<users> getAllUsers(){
		return jpa_service_obj.getAllUser(); 
	}
}