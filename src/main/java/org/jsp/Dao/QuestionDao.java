package org.jsp.Dao;

import org.jsp.Dto.Question;
import org.jsp.Dto.Quiz;
import org.jsp.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class QuestionDao {

	@Autowired
	QuestionRepository repository;
	
	
	public Question SaveQuestion(Question question) {
		
		return repository.save(question);
	}


	public List<Question> getAllQuestions() {
		
		return repository.findAll();
	}


	public List<Question> getAllQuestionByCategory(String category) {
		
		return repository.findByCategory(category);
	}


	public List<Question> getAllQuestionByDifficultyLevel(String difficultylevel) {
		
		return repository.findByDifficcultylevel(difficultylevel);
	}

	public Question getQuestionById(int id) {
		
		return repository.findById(id);
	}

	public void deteleById(int id) {
		
		repository.deleteById(id);
		
	}


	public void deteleByCategory(List<Question> categoryQuestion) {
		
		repository.deleteAll(categoryQuestion);
		
	}


	public List<Question> findRandomQuestionByCategory(String category, int numQ) {


		return repository.findRandomQuestionByCategory(category,numQ);
	}


	public void deteleByDifficultylevel(List<Question> categoryQuestion) {
	
		repository.deleteAll(categoryQuestion);
	}


	

	

	
}
