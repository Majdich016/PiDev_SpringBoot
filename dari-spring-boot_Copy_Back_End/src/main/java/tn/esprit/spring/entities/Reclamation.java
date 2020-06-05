package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Reclamation implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id; 
	private String Description;
	@ManyToOne(cascade = CascadeType.ALL) 
	User userId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reclamation(Long id, String description) {
		super();
		this.id = id;
		Description = description;
	
	}
	
	
}
	