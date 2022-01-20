package com.example.demo;

import java.util.Dictionary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DBConfig.MakeConnection;

@RestController
@RequestMapping(path = "/student")
public class test {
	@GetMapping
	public void ShowStudents() {
		MakeConnection obj = new MakeConnection();
//		return obj.UsersList();
	}
	@PostMapping
	public String RegisterStudent() {
		if(true)
		return "Registered";
		else
			return "Not Registered";
	}
}
