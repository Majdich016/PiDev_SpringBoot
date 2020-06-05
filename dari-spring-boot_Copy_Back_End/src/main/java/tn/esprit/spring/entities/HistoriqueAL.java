package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_HISTORIQUEAL")
public class HistoriqueAL implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdH;
	
	private String Action;
		
	@Temporal(TemporalType.DATE)
	private Date DateAction;

	//@OneToOne (mappedBy="historiqueAL") 
	//private	Client client; 
}
