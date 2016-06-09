package com.mika.qcm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity


public class Question implements Serializable {
	
	
	private Long id;

	
	public String toString() {
		return "Question [id=" + id + ", enonce=" + enonce + "]";
	}


	private String enonce ;

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
		// TODO Auto-generated constructor stub
	}

	public Question(String enonce) {
		super();
	
		this.enonce = enonce;
	}

}
