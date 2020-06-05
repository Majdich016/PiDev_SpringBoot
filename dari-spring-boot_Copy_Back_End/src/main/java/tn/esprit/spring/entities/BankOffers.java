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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_BANK_OFFERS")
public class BankOffers implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBankOffer")
	private Long idBankOffer;
	
	@Column(name = "nameBankOffer")
	private String nameBankoffer;
	
	@Column(name = "descriptionBankOffer")
	private String descriptionBankOffer;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal (TemporalType.DATE)
	private Date endDate;
	
				/* Association */
	
	@ManyToOne
	Bank bank;

		///////////////////////////////////////////////////				

	public BankOffers() {
		super();
	}

	public BankOffers(Long idBankOffer, String nameBankoffer, String descriptionBankOffer, Date startDate,
			Date endDate, Bank bank) {
		super();
		this.idBankOffer = idBankOffer;
		this.nameBankoffer = nameBankoffer;
		this.descriptionBankOffer = descriptionBankOffer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bank = bank;
		}

	public BankOffers(String nameBankoffer, String descriptionBankOffer, Date startDate, Date endDate, Bank bank) {
		super();
		this.nameBankoffer = nameBankoffer;
		this.descriptionBankOffer = descriptionBankOffer;
		this.startDate = startDate;
		this.endDate = endDate;
		this.bank = bank;
	}

	public Long getIdBankOffer() {
		return idBankOffer;
	}

	public void setIdBankOffer(Long idBankOffer) {
		this.idBankOffer = idBankOffer;
	}

	public String getNameBankoffer() {
		return nameBankoffer;
	}

	public void setNameBankoffer(String nameBankoffer) {
		this.nameBankoffer = nameBankoffer;
	}

	public String getDescriptionBankOffer() {
		return descriptionBankOffer;
	}

	public void setDescriptionBankOffer(String descriptionBankOffer) {
		this.descriptionBankOffer = descriptionBankOffer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
	
	
	
}
