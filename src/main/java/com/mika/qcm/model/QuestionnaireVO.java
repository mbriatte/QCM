package com.mika.qcm.model;

import java.io.Serializable;
import java.util.List;

public class QuestionnaireVO implements Serializable {

	
	private Long id;

	private String libelle ;
	
	private List<Question> questions;

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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
