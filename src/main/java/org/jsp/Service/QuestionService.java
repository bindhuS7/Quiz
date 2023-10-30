package org.jsp.Service;


import org.jsp.Dao.QuestionDao;
import org.jsp.Dto.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService {

	@Autowired
	QuestionDao dao;
	
	
	public Question SaveQuestion(Question question) {
		
		return dao.SaveQuestion(question);
	}


	public List<Question> getAllQuestion() {
		
		return dao.getAllQuestions();
	}


	


	public List<Question> getAllQuestionCategory(String category) {
		
		List<Question> categoryQuestion=dao.getAllQuestionByCategory(category);
//		System.out.println("hi");
//		System.out.println(categoryQuestion);
		return categoryQuestion;
	}


	public List<Question> getAllQuestionByDifficultyLevel(String difficultylevel) {
		
		List<Question> list=dao.getAllQuestionByDifficultyLevel(difficultylevel);
		
		
		return list;
	}

	public Question getQuestionById(int id) {
		
		
		return dao.getQuestionById(id);
	}

public Question updateById(int id, Question question2) {
		
	        Question question= dao.getQuestionById(id);
	        if(question==null) {
	        	return null;
	        	
	        }else {
	        	question.setQuestion(question2.getQuestion());
	        	question.setOption1(question2.getOption1());
	        	question.setOption2(question2.getOption2());
	        	question.setOption3(question2.getOption3());
	        	question.setOption4(question2.getOption4());
	        	question.setRigthAnswer(question2.getRigthAnswer());
	        	question.setCategory(question2.getCategory());
	        	question.setDifficcultylevel(question2.getDifficcultylevel());
	        	
	        	return dao.SaveQuestion(question);
	        	
	        	
	        }
		
		
	}


public String deleteQuestion(int id) {
	
	Question ques=dao.getQuestionById(id);
	if(ques !=null) {
		dao.deteleById(id);
		return "deleted successfully";
		}
	else {
		return "invalid id";
	}

	 
}

//working correctly for non existing records also it showing deleted
public String deleteQuestionByCategory(String category) {
	List<Question> categoryQuestion=dao.getAllQuestionByCategory(category);
	System.out.println(categoryQuestion);
	if(categoryQuestion.isEmpty()){
		return "invalid category";
		}
	else {
		dao.deteleByCategory(categoryQuestion );
		return "deleted successfully based on category";
		
		
	}

}


public String deleteQuestionsByDifficultyLevel(String diffiLevel) {
	List<Question> categoryQuestion=dao.getAllQuestionByDifficultyLevel(diffiLevel);
	System.out.println(categoryQuestion);
	if(categoryQuestion.isEmpty()){
		return "invalid difficultyLevel";
		}
	else {
		dao.deteleByDifficultylevel(categoryQuestion );
		return "deleted successfully based on difficultyLevel";
		
		
	}
}


}
