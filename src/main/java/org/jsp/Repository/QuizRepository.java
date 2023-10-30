package org.jsp.Repository;

import java.util.List;

import org.jsp.Dto.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface QuizRepository  extends JpaRepository<Quiz, Integer>{

	List<Quiz> findAllByTitle(String title);

	List<Quiz> findAllById(int id);

	void deleteByTitle(String title);

	

}
