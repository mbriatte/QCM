package com.mika.qcm.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;


import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity


public class Questionnaire implements Serializable {
	

	private Long id;


	private String libelle ;
	
	@Transient
	private List<Question> questions= new ArrayList<Question>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	public Questionnaire(String libelle) {
		super();
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", libelle=" + libelle + "]";
	}

	public Questionnaire() {
		super();
		questions=new  ArrayList<Question>();
		
	}
	
	public void addQuestion(Question q) {
		questions.add(q);
		
	}
	
	public void removeQuestion(Question q) {
		questions.remove(q);
	
	}

	public List<Question> getQuestions() {
		  return questions;
		 }

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	
}
