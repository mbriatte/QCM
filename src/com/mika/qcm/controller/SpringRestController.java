package com.mika.qcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mika.qcm.model.Questionnaire;
import com.mika.qcm.model.QuestionnaireVO;
import com.mika.qcm.service.QuestionnaireService;
import org.springframework.http.HttpStatus;

@Controller
@RestController 
	public class SpringRestController { 
	
	@Autowired 
	private QuestionnaireService questionnaireService; 
	 
	@RequestMapping(value = "/questionnaire/{id}", method = RequestMethod.GET) 
	public @ResponseBody  ResponseEntity<Object> getQuestionnaireById(@PathVariable String id) {
		Questionnaire q=null;
		try
		{
		Long ident=Long.parseLong(id);
		 q=questionnaireService.getQuestionnaire(ident);
		}
		catch (Exception e)
		{
			return new ResponseEntity<Object>( "une erreur s'est produite",HttpStatus.FORBIDDEN) ;
		}
		return new ResponseEntity<Object>(q, HttpStatus.OK);
		} 
	
	@RequestMapping(value = "/questionnaires", method = RequestMethod.GET) 
	public @ResponseBody  List<Questionnaire> getQuestionnaires() {		
		List<Questionnaire> q=questionnaireService.getQuestionnaires();	
		return q;
		} 
	
	}


