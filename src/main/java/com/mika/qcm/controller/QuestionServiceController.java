package main.java.com.mika.qcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.mika.qcm.model.Question;
import main.java.com.mika.qcm.service.QuestionService;


@Controller
@RestController 
public class QuestionServiceController {
	
	@Autowired 
	private QuestionService questionService; 
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET) 
	public @ResponseBody  ResponseEntity<Object> getQuestions() {		
		
			List<Question> q=questionService.getQuestions();	
			return new ResponseEntity<Object>(q, HttpStatus.OK);
		
		} 

}
