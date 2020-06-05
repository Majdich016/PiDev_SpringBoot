package tn.esprit.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rent extends Ad {
	private static final long serialVersionUID = -3046278688391172322L;

	
	@Temporal(TemporalType.DATE)
	private Date StartDate;
	
	@Temporal(TemporalType.DATE)
	private Date EndDate;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private RentPeriod rentperiod;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private RentingType rentingtype;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rent") 
	private Set<RatingA> Ratings;


	public Rent() {
		super();
	}

	public Rent(Date startDate, Date endDate, RentPeriod rentperiod, RentingType rentingtype) {
		super();
		StartDate = startDate;
		EndDate = endDate;
		this.rentperiod = rentperiod;
		this.rentingtype = rentingtype;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public RentPeriod getRentperiod() {
		return rentperiod;
	}

	public void setRentperiod(RentPeriod rentperiod) {
		this.rentperiod = rentperiod;
	}

	public RentingType getRentingtype() {
		return rentingtype;
	}

	public void setRentingtype(RentingType rentingtype) {
		this.rentingtype = rentingtype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Rent [StartDate=" + StartDate + ", EndDate=" + EndDate + ", rentperiod=" + rentperiod + ", rentingtype="
				+ rentingtype + "]";
	}

	
	
}
