package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.QuestionDao;
import com.example.demo.entity.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public List<Question> getallquestions() {
	return 	questionDao.findAll();
	}

	public List<Question> getquestionByCategory(String category) {
		return questionDao.findByCategory(category);
	}

	
	public String addquestion(@RequestBody Question question) {
		questionDao.save(question);
		return "Succses";
		
	}

	public void deletequestion(int id) {
		questionDao.deleteById(id);
		
	}

	
}
