package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@GetMapping("/allquestion")
	public ResponseEntity<List<Question>> getallquestions() {
		try {
			
		return new ResponseEntity<>(questionService.getallquestions(),HttpStatus.ACCEPTED);
			
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> questionByCategory(@PathVariable String category)
	{
		try
		{
		return new ResponseEntity<>(questionService.getquestionByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	//@RequestBody->json into java
	@PostMapping("/add/")
	public String addquestion(@RequestBody Question question)
	{
		questionService.addquestion(question);
		return "Question Saved";
		
	}
	@DeleteMapping("/delete/{id}")
	public String deletequestion(@PathVariable int id)
	{
		questionService.deletequestion(id);
		return "Delete question";
		
	}
}

