package com.mika.qcm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
//@Table(name = "QUESTIONNAIRE")

public class Questionnaire implements Serializable {
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

//	@Column(name = "ID", nullable = false)
	private String id;

//	@Column(name = "LIBELLE", nullable = false)
	private String libelle ;
	
	@Transient
	private List<Question> questions ;

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
		// TODO Auto-generated constructor stub
	}
	
	public void AddQuestion(Question q) {
		questions.add(q);
		// TODO Auto-generated constructor stub
	}

	public List<Question> getQuestions() {
		  return questions;
		 }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
