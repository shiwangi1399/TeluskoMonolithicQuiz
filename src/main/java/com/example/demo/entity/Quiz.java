package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class Quiz {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	private String title;
	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(
		    name = "quiz_question", joinColumns = @JoinColumn(name = "quiz_id"), 
		    inverseJoinColumns = @JoinColumn(name = "question_id") 
		)
  private List<Question> question;
		

}
