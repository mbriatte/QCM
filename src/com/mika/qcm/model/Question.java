package com.mika.qcm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "QUESTION")

public class Question implements Serializable {
	
	@Column(name = "ID", nullable = false)
	private String id;

	@Override
	public String toString() {
		return "Question [id=" + id + ", enonce=" + enonce + "]";
	}

	@Column(name = "ENONCE", nullable = false)
	private String enonce ;


	public String getEnonce() {
		return enonce;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEnonce(String enonce) {
		
		this.enonce = enonce;
	}

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(String id, String enonce) {
		super();
		this.id=id;
		this.enonce = enonce;
	}

}
