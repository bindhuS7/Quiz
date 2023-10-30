package org.jsp.Controller;

import org.jsp.Dto.Quiz;
import org.jsp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService service;
	
	
	@PostMapping("/createQuiz")
	public ResponseEntity<Quiz> PostQuize(@RequestParam String category,@RequestParam String title,@RequestParam int numQ){
		
		return service.PostQuiz(category,title,numQ);
	}
	@GetMapping("/getAllQuiz")
	public ResponseEntity<List<Quiz>> GetAllQuiz(){
		
		return service.GetAllQuiz();
	}
	
	@GetMapping("/getAllQuiz/id")
	public ResponseEntity<List<Quiz>> GetAllQuizBYId(@RequestParam int id){
		
		return service.GetAllQuizById(id);
	}
	
	@GetMapping("/getAllQuiz/{title}")
public ResponseEntity<List<Quiz>> GetAllQuizByTitle(@PathVariable String title){
		
		return service.GetAllQuizByTitle(title);
	}
	@DeleteMapping("/deleteById/{id}")
public ResponseEntity<String> deleteQuizById(@PathVariable int id){
		
		return service.deleteQuizById(id);
	}
	@DeleteMapping("/deleteByTitle/{title}")
	public ResponseEntity<String> deleteQuizByTitle(@PathVariable String title){
			
			return service.deleteQuizByTitle(title);
		}
	
//	@PutMapping("/updateById/{id}")
//	public ResponseEntity<Quiz> updateById(@PathVariable int id,@RequestParam String category,@RequestParam String title,@RequestParam int numQ){
//		
//		return service.updateQuizById(id,category,title,numQ);
//	}
}
