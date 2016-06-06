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
	private Set<Question> questions ;

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
		questions=new  HashSet<Question>();
		// TODO Auto-generated constructor stub
	}
	
	public void AddQuestion(Question q) {
		questions.add(q);
		// TODO Auto-generated constructor stub
	}

	public Set<Question> getQuestions() {
		  return questions;
		 }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
}
