package com.example.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

	 List<Question> findByCategory(String category);
	 //  to specify value give : , 
	@Query(value="SELECT * FROM Question q Where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery=true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);

}

	