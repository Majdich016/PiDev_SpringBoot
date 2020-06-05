package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_BANK")
public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBank")
	private Long id;
	
	@Column(name = "nameBank")
	private String name;
	
	@Column(name = "descriptionBank")
	private String description;
	
	@Column(name = "addressBank")
	private String address;
	
	@Column(name = "tmmBank")
	private float tauxMoyenDuMarche;
	
	@Column(name = "margeBank")
	private float margeInteret;
	
					/* Association */
	@JsonBackReference
	@ManyToOne
	Agent agentBank;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="bank")
	@JsonIgnore
	private Set<BankOffers> bankOffer;
	
	@JsonIgnore
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="bank")
	private List<LoanSimulation> loanSimulation;

		///////////////////////////////////////////////////	
	
	public Bank() {
		super();
	}

	

	public Bank(Long id, String name, String description, String address, float tauxMoyenDuMarche, float margeInteret,
			Agent agentBank, List<LoanSimulation> loanSimulation) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.tauxMoyenDuMarche = tauxMoyenDuMarche;
		this.margeInteret = margeInteret;
		this.agentBank = agentBank;
		this.loanSimulation = loanSimulation;
	}

	

	public Bank(String name, String description, String address, float tauxMoyenDuMarche, float margeInteret,
			Agent agentBank, Set<BankOffers> bankOffer, List<LoanSimulation> loanSimulation) {
		super();
		this.name = name;
		this.description = description;
		this.address = address;
		this.tauxMoyenDuMarche = tauxMoyenDuMarche;
		this.margeInteret = margeInteret;
		this.agentBank = agentBank;
		this.bankOffer = bankOffer;
		this.loanSimulation = loanSimulation;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<BankOffers> getBankOffer() {
		return bankOffer;
	}

	public void setBankOffer(Set<BankOffers> bankOffer) {
		this.bankOffer = bankOffer;
	}

	public List<LoanSimulation> getLoanSimulation() {
		return loanSimulation;
	}

	public void setLoanSimulation(List<LoanSimulation> loanSimulation) {
		this.loanSimulation = loanSimulation;
	}

	public Agent getAgentBank() {
		return agentBank;
	}

	public void setAgentBank(Agent agentBank) {
		this.agentBank = agentBank;
	}

	


	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public float getTauxMoyenDuMarche() {
		return tauxMoyenDuMarche;
	}



	public void setTauxMoyenDuMarche(float tauxMoyenDuMarche) {
		this.tauxMoyenDuMarche = tauxMoyenDuMarche;
	}



	public float getMargeInteret() {
		return margeInteret;
	}



	public void setMargeInteret(float margeInteret) {
		this.margeInteret = margeInteret;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((agentBank == null) ? 0 : agentBank.hashCode());
		result = prime * result + ((bankOffer == null) ? 0 : bankOffer.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loanSimulation == null) ? 0 : loanSimulation.hashCode());
		result = prime * result + Float.floatToIntBits(margeInteret);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(tauxMoyenDuMarche);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (agentBank == null) {
			if (other.agentBank != null)
				return false;
		} else if (!agentBank.equals(other.agentBank))
			return false;
		if (bankOffer == null) {
			if (other.bankOffer != null)
				return false;
		} else if (!bankOffer.equals(other.bankOffer))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loanSimulation == null) {
			if (other.loanSimulation != null)
				return false;
		} else if (!loanSimulation.equals(other.loanSimulation))
			return false;
		if (Float.floatToIntBits(margeInteret) != Float.floatToIntBits(other.margeInteret))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(tauxMoyenDuMarche) != Float.floatToIntBits(other.tauxMoyenDuMarche))
			return false;
		return true;
	}
	
	
	
	
}
