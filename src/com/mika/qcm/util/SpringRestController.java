package com.mika.qcm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mika.qcm.model.Questionnaire;
import com.mika.qcm.model.QuestionnaireVO;
import com.mika.qcm.service.QuestionnaireService;

@RestController @RequestMapping("/questionnaire") 
	public class SpringRestController { 
	
	@Autowired 
	private QuestionnaireService questionnaireService; 
	 
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public @ResponseBody  QuestionnaireVO hello(@PathVariable String id) {
		Long ident=Long.parseLong(id);
		System.out.println("id =" + id);
		System.out.println("ident =" + ident);
		QuestionnaireVO vo= new QuestionnaireVO();
		Questionnaire q=questionnaireService.getQuestionnaire(ident);
		System.out.println("libelle =" + q.getLibelle());
		vo.setLibelle(q.getLibelle());
	//	return vo.getLibelle();
		return vo;
		
		} 
	}


