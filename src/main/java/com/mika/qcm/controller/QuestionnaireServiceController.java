package com.mika.qcm.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import com.mika.qcm.model.Questionnaire;
import com.mika.qcm.service.QuestionnaireService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Controller
@RestController 
	public class QuestionnaireServiceController { 
	
	@Autowired 
	private QuestionnaireService questionnaireService; 
	
	@RequestMapping(value = "/questionnaires", method = RequestMethod.GET,produces = { "application/json"}) 		
	public @ResponseBody  ResponseEntity<Object> getQuestionnaires(HttpServletRequest request) {
		// recherche par nom
		String name=request.getParameter("name");
		if (name!=null && name.length()>0) 
			{
			HttpStatus httpretour = HttpStatus.NOT_FOUND;
			Questionnaire q=questionnaireService.getQuestionnaireWithAssociationByName(name);
			if (q!=null) httpretour = HttpStatus.OK;
			return new ResponseEntity<Object>(q,httpretour);
			}
		//recherche tout
		else {
			List<Questionnaire> q=questionnaireService.getQuestionnaires();	
			return new ResponseEntity<Object>(q, HttpStatus.OK);
		}
		} 
	 
	@RequestMapping(value = "/questionnaire/{id}", method = RequestMethod.GET,produces = { "application/json","application/xml","text/plain"}) 
	public @ResponseBody  ResponseEntity<Object> getQuestionnaireById(@PathVariable String id,@RequestHeader(value="Accept") String accept) {
		Questionnaire q=null;
		HttpStatus httpretour = HttpStatus.NOT_FOUND;
		try
		{
			 Long ident=Long.parseLong(id);
			 q=questionnaireService.getQuestionnaire(ident);
			 if (q!=null) httpretour = HttpStatus.OK;
		}
		catch (Exception e)
		{
			return new ResponseEntity<Object>( "une erreur s'est produite",HttpStatus.BAD_REQUEST) ;
		}
		
		if( accept.equalsIgnoreCase("text/plain") && q!=null) {
			return new ResponseEntity<Object>(q.toString(), httpretour);
			}
		else return new ResponseEntity<Object>(q, httpretour);
		} 
	
	@RequestMapping(value = "/questionnaire", method = RequestMethod.POST,consumes= { "application/json","application/xml"}) 
	public @ResponseBody  ResponseEntity<Object> addQuestionnaire(@RequestBody Questionnaire q) {
		String id="";
		try
		{
		 questionnaireService.addQuestionnaire(q);
		  id=q.getId().toString();
		}
		catch (Exception e)
		{
			return new ResponseEntity<Object>( "une erreur s'est produite",HttpStatus.FORBIDDEN) ;
		}
		
		// retourne la 'location' de ressource 
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(UriComponentsBuilder.fromPath("/questionnaire/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Object>(responseHeaders, HttpStatus.CREATED);
		} 
	
	
	@RequestMapping(value = "/questionnaire/{id}", method = RequestMethod.DELETE)
	public @ResponseBody  ResponseEntity<Object> delQuestionnaire(@PathVariable String id) {
		HttpStatus httpretour = HttpStatus.NOT_FOUND;
		try
		{
		Long ident=Long.parseLong(id);
		Questionnaire q=questionnaireService.getQuestionnaire(ident);
		 if (q!=null) 
			 {
			 httpretour = HttpStatus.OK;
			 questionnaireService.removeQuestionnaire(ident);
			 }
		}
		catch (Exception e)
		{
			return new ResponseEntity<Object>( "une erreur s'est produite",HttpStatus.BAD_REQUEST) ;
		}
		return new ResponseEntity<Object>(id, httpretour);
		}
	
	@RequestMapping(value = "/questionnaire/{id}", method = RequestMethod.PUT,produces = { "application/json","application/xml"},consumes= { "application/json","application/xml"})
	public @ResponseBody  ResponseEntity<Object> updateQuestionnaire(@PathVariable String id,@RequestBody Questionnaire q) {
		Questionnaire quest=null;
		try
		{
			Long ident=Long.parseLong(id);
			 quest= questionnaireService.getQuestionnaire(ident);
			if (quest!=null) 
			{
				quest.setLibelle(q.getLibelle());
				questionnaireService.saveQuestionnaire(quest);
			}
			else return new ResponseEntity<Object>( "questionnaire inconnu",HttpStatus.NOT_FOUND) ;
		}
		catch (Exception e)
		{
			return new ResponseEntity<Object>( "une erreur s'est produite",HttpStatus.BAD_REQUEST) ;
		}
		return new ResponseEntity<Object>(quest, HttpStatus.OK);
		}

	}


