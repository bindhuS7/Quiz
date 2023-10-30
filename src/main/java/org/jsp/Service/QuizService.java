package org.jsp.Service;

import org.jsp.Dao.QuestionDao;
import org.jsp.Dao.QuizDao;
import org.jsp.Dto.Question;
import org.jsp.Dto.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuizService {
	
	@Autowired
	QuizDao dao;
	
	
	@Autowired
	QuestionDao quesDao;

	public ResponseEntity<Quiz> PostQuiz(String category, String title, int numQ) {
		
		
	List<Question> questions=quesDao.findRandomQuestionByCategory(category,numQ);
    
	
	Quiz quiz=new Quiz();
	quiz.setTitle(title);
	quiz.setQuestion(questions);
	
	 Quiz quiz1= dao.PostQuize(quiz);
		
		
		return new ResponseEntity<>(quiz1,HttpStatus.CREATED);
	}

	public ResponseEntity<List<Quiz>> GetAllQuiz() {

         List<Quiz> list =   dao.GetAllQuiz();
         
		return new ResponseEntity<List<Quiz>>(list,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<Quiz>> GetAllQuizByTitle(String title) {
		
		 List<Quiz> list =   dao.GetAllQuizBYTitle(title);
         System.out.println(list);
			return new ResponseEntity<List<Quiz>>(list,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<Quiz>> GetAllQuizById(int id) {

		 List<Quiz> list =   dao.GetAllQuizById(id);
         
			return new ResponseEntity<List<Quiz>>(list,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> deleteQuizById(int id) {
		 List<Quiz> list =   dao.GetAllQuizById(id);
		 if(list.isEmpty()) {
			 return new ResponseEntity<String>("invalid Id",HttpStatus.ACCEPTED);	
		 }else {
		
		   dao.deleteQuizById(id);
		   return new ResponseEntity<String>("deleted Successfully",HttpStatus.ACCEPTED);
			
		}
	}

	public ResponseEntity<String> deleteQuizByTitle(String title) {
		 List<Quiz> list =   dao.GetAllQuizBYTitle(title);
		 System.out.println(list);
		 if(list.isEmpty()) {
			 return new ResponseEntity<String>("invalid title",HttpStatus.CREATED);	
		 }else {
		   dao.deleteQuizByTitle(title);
		   return new ResponseEntity<String>("deleted Successfully based on title",HttpStatus.ACCEPTED);
		 
		}
	}

//	public ResponseEntity<Quiz> updateQuizById(int id, String category, String title, int numQ) {
//		
//		
//		 List<Quiz> list =   dao.GetAllQuizById(id);
//		 if(list.isEmpty()) {
//			 return new ResponseEntity<>(null,HttpStatus.ACCEPTED);	
//			 
//		 }else {
//		
//			 List<Question> questions=quesDao.findRandomQuestionByCategory(category,numQ);
//			    
//				
//				Quiz quiz=new Quiz();
//			
//				quiz.setTitle(title);
//				quiz.setQuestion(questions);
//				
//				 Quiz quiz1= dao.PostQuize(quiz);
//					
//					
//					return new ResponseEntity<>(quiz1,HttpStatus.CREATED);
//		}	
//	}
	
	
}
