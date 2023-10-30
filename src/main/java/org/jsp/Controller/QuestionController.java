package org.jsp.Controller;


import org.jsp.Dto.Question;
import org.jsp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class QuestionController {
	
@Autowired
QuestionService service;

@PostMapping("/question")
public Question SaveQuestions(@RequestBody Question question) {
	
	return service.SaveQuestion(question);
}

@GetMapping("/question")
public List<Question> getAllQuestion(){
	
	return service.getAllQuestion();
}
@GetMapping("/question/id/{id}")
public Question getQuestionById(@PathVariable int id){
	
	return service.getQuestionById(id);
}

@GetMapping("/question/{category}")
public List<Question> getAllQuestionByCatagory(@PathVariable String category){
	
	return service.getAllQuestionCategory(category);
}
@GetMapping("/question/difficultylevel/{difficultylevel}")
public List<Question> getAllQuestionByDifficutyLevel(@PathVariable String difficultylevel){

	return service.getAllQuestionByDifficultyLevel(difficultylevel);
}
@PutMapping("/question/{id}")
public Question updateById(@PathVariable int id,@RequestBody Question question) {
	return service.updateById(id,question);
}



@DeleteMapping("/delete/{id}")
public String deleteQuestion(@PathVariable int id) {
	
	return service.deleteQuestion(id);
}
@DeleteMapping("/question/delete/category/{category}")
public String deleteQuestionByCategory(@PathVariable String category) {
	
	return service.deleteQuestionByCategory(category);
}
@DeleteMapping("/question/delete/DifficultLevel/{difficultylevel}")
public String deleteQuestionsByDifficultyLevel(@PathVariable String difficultylevel) {
	return service. deleteQuestionsByDifficultyLevel( difficultylevel);
}


}
