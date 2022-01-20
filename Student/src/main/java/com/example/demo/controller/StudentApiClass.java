package com.example.demo.controller;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DBConnection.MyConnection;

@RestController
@RequestMapping(path="/student")
public class StudentApiClass {
	private MyConnection con;
	public StudentApiClass() {
		super();
		// TODO Auto-generated constructor stub
		con = new MyConnection();
	}
	@GetMapping(path="")
	public Dictionary AllProduct() {
	return con.AllStudents();	
	}
	
	@GetMapping(path="/{productId}")
	public Object Product(@PathVariable int productId) {
		System.out.println("Product Id:- " + productId);
		System.out.println("The size of the dictionary:- "+con.AllStudents().size());
		Dictionary dict = new Hashtable();
		Dictionary temp = con.AllStudents();
		System.out.println("Types of temp:- " + temp);
		for(int i = 0 ; i < con.AllStudents().size() ; i++) {
			System.out.println("Item at:- "+ i + " " +temp.get(i));
		}
		return temp.get(0);
	}
	
	
	@PostMapping(path="")
	public String RegisterProduct(@RequestBody Object test) {
		System.out.println(test);
		System.out.println(test.getClass().getSimpleName());
		if(con.RegisterStudent(test)) {
			return "Registered Successfull";
		}
		else {
			return "Error Occured";
		}
	}
}
