package com.mika.qcm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity


public class Questionnaire implements Serializable {
	

	private String id;


	private String libelle ;
	
	@Transient
	private List<Question> questions= new ArrayList<Question>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public Questionnaire(String id,String libelle) {
		super();
		this.id=id;
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", libelle=" + libelle + "]";
	}

	public Questionnaire() {
		super();
		questions=new  ArrayList<Question>();
		// TODO Auto-generated constructor stub
	}
	
	public void addQuestion(Question q) {
		questions.add(q);
		// TODO Auto-generated constructor stub
	}
	
	public void removeQuestion(Question q) {
		questions.remove(q);
		// TODO Auto-generated constructor stub
	}

	public List<Question> getQuestions() {
		  return questions;
		 }

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
