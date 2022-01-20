package com.JWT_practice.API_package;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TestController {
	@GetMapping("/hello")
	public String Hello() {
		return "Hello";
	}
}
