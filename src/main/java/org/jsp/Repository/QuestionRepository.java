package org.jsp.Repository;

import java.util.List;

import org.jsp.Dto.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	List<Question> findByDifficcultylevel(String difficultylevel);

	Question findById(int id);

	@Query(value="select * from Question q where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery=true)
	List<Question> findRandomQuestionByCategory(String category, int numQ);

//	void deleteByCategory(String category);

	
}
