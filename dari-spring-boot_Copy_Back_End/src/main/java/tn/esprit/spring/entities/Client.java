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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Client extends User{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;   
	private String picture;
	private String DescriptionBlock;
	private int nbre;
	private boolean block;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<AppointmentFeedBack> AppointmentFeedBack;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Appointment> Appointment;
	

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY, mappedBy="client")
	private Set<LoanSimulation> loanSimulations;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public boolean isBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public String getDescriptionBlock() {
		return DescriptionBlock;
	}
	public void setDescriptionBlock(String descriptionBlock) {
		DescriptionBlock = descriptionBlock;
	}
	public int getNbre() {
		return nbre;
	}
	public void setNbre(int nbre) {
		this.nbre = nbre;
	}
	
	
	
	public Set<LoanSimulation> getLoanSimulations() {
		return loanSimulations;
	}
	public void setLoanSimulations(Set<LoanSimulation> loanSimulations) {
		this.loanSimulations = loanSimulations;
	}

	
	public Client() {
		super();
	}
	public Client(Long id, Long cin, String firstName, String lastname, Date dateNaissance, String email,
			String password, Long id2, String picture, String descriptionBlock, int nbre, boolean block,
			Set<tn.esprit.spring.entities.AppointmentFeedBack> appointmentFeedBack,
			Set<tn.esprit.spring.entities.Appointment> appointment, Set<LoanSimulation> loanSimulations) {
		super(id, cin, firstName, lastname, dateNaissance, email, password);
		id = id2;
		this.picture = picture;
		DescriptionBlock = descriptionBlock;
		this.nbre = nbre;
		this.block = block;
		AppointmentFeedBack = appointmentFeedBack;
		Appointment = appointment;
		this.loanSimulations = loanSimulations;
	}
	
	
	public Client(Long id, Long cin, String firstName, String lastname, Date dateNaissance, String email,
			String password, String picture, String descriptionBlock, int nbre, boolean block,
			Set<tn.esprit.spring.entities.AppointmentFeedBack> appointmentFeedBack,
			Set<tn.esprit.spring.entities.Appointment> appointment, Set<LoanSimulation> loanSimulations) {
		super(id, cin, firstName, lastname, dateNaissance, email, password);
		this.picture = picture;
		DescriptionBlock = descriptionBlock;
		this.nbre = nbre;
		this.block = block;
		AppointmentFeedBack = appointmentFeedBack;
		Appointment = appointment;
		this.loanSimulations = loanSimulations;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", picture=" + picture + ", DescriptionBlock=" + DescriptionBlock + ", nbre=" + nbre
				+ ", block=" + block + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DescriptionBlock == null) ? 0 : DescriptionBlock.hashCode());
		result = prime * result + (block ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + nbre;
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (DescriptionBlock == null) {
			if (other.DescriptionBlock != null)
				return false;
		} else if (!DescriptionBlock.equals(other.DescriptionBlock))
			return false;
		if (block != other.block)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nbre != other.nbre)
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}
	
	

	
	
	


	


	
	
	
	
}