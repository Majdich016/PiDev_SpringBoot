package tn.esprit.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Agent extends User{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;   
	
	private int phone;
	
	private String address;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="agentBank")
	private Set<Bank> banks;

	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Agent(Long id, String firstName, String lastname, Date dateNaissance, String email, String password,
			Long id2, int phone, String address, Set<Bank> banks) {
		super(id, firstName, lastname, dateNaissance, email, password);
		id = id2;
		this.phone = phone;
		this.address = address;
		this.banks = banks;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Set<Bank> getBanks() {
		return banks;
	}


	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}
	
	
	
}
