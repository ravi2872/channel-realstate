package com.channel.realestate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable("name") String myName) {
		return "Hi "+myName+" Welcome...";
	}
}
