package com.mika.qcm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;

import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity


public class Question implements Serializable {
	
	@Transient
	private List<Proposition> propositions= new ArrayList<Proposition>();
	
	private Long id;
	
	private String enonce ;
	
	public String toString() {
		return "Question [id=" + id + ", enonce=" + enonce + "]";
	}


	public Long getId() {
		return id;
	}

	public String getEnonce() {
		return enonce;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public void setEnonce(String enonce) {
		
		this.enonce = enonce;
	}

	public Question() {
		
	}

	public Question(String enonce) {
		super();
	
		this.enonce = enonce;
	}
	
	public void addProposition(Proposition q) {
		propositions.add(q);
		
	}
	
	public void removeProposition(Proposition q) {
		propositions.remove(q);
	
	}

	public List<Proposition> getPropositions() {
		  return propositions;
		 }

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	

}
