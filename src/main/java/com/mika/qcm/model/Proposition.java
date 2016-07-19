package main.java.com.mika.qcm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
@SuppressWarnings("serial")
@Entity

@XmlRootElement(name = "proposition")
public class Proposition implements Serializable {
	
	private Long id;

	
	public String toString() {
		return "Proposition [id=" + id + ", contenu=" + contenu + "]";
	}


	private String contenu ;

	public Long getId() {
		return id;
	}

	public String getContenu() {
		return contenu;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public void setContenu(String contenu) {
		
		this.contenu = contenu;
	}

	public Proposition() {
		
	}

	public Proposition(String contenu) {
		super();
	
		this.contenu = contenu;
	}


}
