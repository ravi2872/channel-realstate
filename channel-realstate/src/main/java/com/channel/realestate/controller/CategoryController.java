package com.channel.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.channel.realestate.dto.Category;
import com.channel.realestate.repository.CategoryRepository;

@RestController
@RequestMapping("/")
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;
	
	@GetMapping("hello/{name}")
	public String sayHello(@PathVariable("name") String myName) {
		return "Hi "+myName+" Welcome...";
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		Category category2 = repository.save(category);
		return category2;
	}
	
	@GetMapping
	public List<Category> getAllCategories(){
		return repository.findAll();
	}
}
