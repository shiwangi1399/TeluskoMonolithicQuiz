package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
