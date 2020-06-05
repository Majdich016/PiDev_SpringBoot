package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Sell extends Ad{
	private static final long serialVersionUID = 1L;

	
	
	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
}
