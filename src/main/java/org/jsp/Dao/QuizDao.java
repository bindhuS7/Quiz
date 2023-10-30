package org.jsp.Dao;

import java.util.List;

import org.jsp.Dto.Quiz;
import org.jsp.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public class QuizDao {

	@Autowired
	QuizRepository repository;
	
	public Quiz PostQuize(Quiz quiz) {
		
		return repository.save(quiz);
	}

	public List<Quiz> GetAllQuiz() {
		
		return repository.findAll();
	}

	public List<Quiz> GetAllQuizBYTitle(String title) {
		
		return repository.findAllByTitle(title);
	}

	public List<Quiz> GetAllQuizById(int id) {
		
		return repository.findAllById(id);
	}

	public void deleteQuizById(int id) {
		
		repository.deleteById(id);
		
	}
    @Transactional
	public void deleteQuizByTitle(String title) {
		repository.deleteByTitle(title);
		
	}

}
