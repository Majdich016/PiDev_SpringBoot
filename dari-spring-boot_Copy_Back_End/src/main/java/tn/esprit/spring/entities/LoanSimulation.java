package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "T_LOAN_SIMULATION")
public class LoanSimulation implements Serializable {


	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLoan")
	private Long idLoan;
	
	private double taux;
	
	private double mensuel;
	
	private double capaciteDeRembouresement;
	
	private double interet;
	
	private double interetTotale;
	
	private double mensualite;
	
	private double principale;
	
	private double montantRembourse;
	
	private double prixImmob;
	
	private double salaire;
	
	private String status;
	
	@CreationTimestamp
	private Date publishedDate;
	
					/* Association */
	
	@ManyToOne
	Bank bank;
	
	@ManyToOne
	Client client;

		///////////////////////////////////////////////////
	
	public LoanSimulation() {
		super();
	}

	public LoanSimulation(Long idLoan, double taux, double mensuel, double capaciteDeRembouresement, double interet,
				double interetTotale, double mensualite, double principale, double montantRembourse, double prixImmob,
				double salaire, String status, Bank bank, Client client) {
			super();
			this.idLoan = idLoan;
			this.taux = taux;
			this.mensuel = mensuel;
			this.capaciteDeRembouresement = capaciteDeRembouresement;
			this.interet = interet;
			this.interetTotale = interetTotale;
			this.mensualite = mensualite;
			this.principale = principale;
			this.montantRembourse = montantRembourse;
			this.prixImmob = prixImmob;
			this.salaire = salaire;
			this.status = status;
			this.bank = bank;
			this.client = client;
		}

	public LoanSimulation(double taux, double mensuel, double capaciteDeRembouresement, double interet,
			double interetTotale, double mensualite, double principale, double montantRembourse, double prixImmob,
			double salaire, String status, Bank bank, Client client) {
		super();
		this.taux = taux;
		this.mensuel = mensuel;
		this.capaciteDeRembouresement = capaciteDeRembouresement;
		this.interet = interet;
		this.interetTotale = interetTotale;
		this.mensualite = mensualite;
		this.principale = principale;
		this.montantRembourse = montantRembourse;
		this.prixImmob = prixImmob;
		this.salaire = salaire;
		this.status = status;
		this.bank = bank;
		this.client = client;
	}
	
	

	public LoanSimulation(Long idLoan, double taux, double mensuel, double capaciteDeRembouresement, double interet,
			double interetTotale, double mensualite, double principale, double montantRembourse, double prixImmob,
			double salaire, String status, Date publishedDate, Bank bank, Client client) {
		super();
		this.idLoan = idLoan;
		this.taux = taux;
		this.mensuel = mensuel;
		this.capaciteDeRembouresement = capaciteDeRembouresement;
		this.interet = interet;
		this.interetTotale = interetTotale;
		this.mensualite = mensualite;
		this.principale = principale;
		this.montantRembourse = montantRembourse;
		this.prixImmob = prixImmob;
		this.salaire = salaire;
		this.status = status;
		this.publishedDate = publishedDate;
		this.bank = bank;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getIdLoan() {
		return idLoan;
	}

	public void setIdLoan(Long idLoan) {
		this.idLoan = idLoan;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getMensuel() {
		return mensuel;
	}

	public void setMensuel(double mensuel) {
		this.mensuel = mensuel;
	}

	public double getCapaciteDeRembouresement() {
		return capaciteDeRembouresement;
	}

	public void setCapaciteDeRembouresement(double capaciteDeRembouresement) {
		this.capaciteDeRembouresement = capaciteDeRembouresement;
	}

	public double getInteret() {
		return interet;
	}

	public void setInteret(double interet) {
		this.interet = interet;
	}

	public double getInteretTotale() {
		return interetTotale;
	}

	public void setInteretTotale(double interetTotale) {
		this.interetTotale = interetTotale;
	}

	public double getMensualite() {
		return mensualite;
	}

	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}

	public double getPrincipale() {
		return principale;
	}

	public void setPrincipale(double principale) {
		this.principale = principale;
	}

	public double getMontantRembourse() {
		return montantRembourse;
	}

	public void setMontantRembourse(double montantRembourse) {
		this.montantRembourse = montantRembourse;
	}

	public double getPrixImmob() {
		return prixImmob;
	}

	public void setPrixImmob(double prixImmob) {
		this.prixImmob = prixImmob;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

//	@ManyToOne
//	@JoinColumn(name="id_bank")
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bank == null) ? 0 : bank.hashCode());
		long temp;
		temp = Double.doubleToLongBits(capaciteDeRembouresement);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((idLoan == null) ? 0 : idLoan.hashCode());
		temp = Double.doubleToLongBits(interet);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(interetTotale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mensualite);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mensuel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(montantRembourse);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(principale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prixImmob);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(salaire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taux);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		LoanSimulation other = (LoanSimulation) obj;
		if (bank == null) {
			if (other.bank != null)
				return false;
		} else if (!bank.equals(other.bank))
			return false;
		if (Double.doubleToLongBits(capaciteDeRembouresement) != Double
				.doubleToLongBits(other.capaciteDeRembouresement))
			return false;
		if (idLoan == null) {
			if (other.idLoan != null)
				return false;
		} else if (!idLoan.equals(other.idLoan))
			return false;
		if (Double.doubleToLongBits(interet) != Double.doubleToLongBits(other.interet))
			return false;
		if (Double.doubleToLongBits(interetTotale) != Double.doubleToLongBits(other.interetTotale))
			return false;
		if (Double.doubleToLongBits(mensualite) != Double.doubleToLongBits(other.mensualite))
			return false;
		if (Double.doubleToLongBits(mensuel) != Double.doubleToLongBits(other.mensuel))
			return false;
		if (Double.doubleToLongBits(montantRembourse) != Double.doubleToLongBits(other.montantRembourse))
			return false;
		if (Double.doubleToLongBits(principale) != Double.doubleToLongBits(other.principale))
			return false;
		if (Double.doubleToLongBits(prixImmob) != Double.doubleToLongBits(other.prixImmob))
			return false;
		if (Double.doubleToLongBits(salaire) != Double.doubleToLongBits(other.salaire))
			return false;
		if (Double.doubleToLongBits(taux) != Double.doubleToLongBits(other.taux))
			return false;
		return true;
	}
	
					

	
	
}
