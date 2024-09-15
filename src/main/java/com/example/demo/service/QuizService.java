package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.dao.QuizDao;
import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionWrapper;
import com.example.demo.entity.Quiz;
import com.example.demo.entity.Response;
@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;
	
	

	public ResponseEntity<String> createquiz(String category, int numQ, String title) {
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz= new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}



	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		Optional<Quiz> quiz= quizDao.findById(id);
		List<Question> questionFromDB = quiz.get().getQuestion();
		List<QuestionWrapper> questionForUser =new ArrayList<>();
		for (Question q: questionFromDB)
		{
			QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
					
		}
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}


//number of right response
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz =quizDao.findById(id).get();
		System.out.println(quiz);
		List<Question> questions =quiz.getQuestion();
		int right=0;
		int i=0;
		for(Response response: responses)
		{
			if(response.getResponse().equals(questions.get(i).getRightanswer()))
					right++;
			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}



	
	
	

}
