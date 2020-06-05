package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_WISHLIST")
public class WishList {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdW;
	
	private int surfacemin; 
	private int surfacemax; 
	private int budgetmin; 
	private int budgetmax;
	private int nbRooms;
	private Boolean buildable;
	private Boolean serviced;
	private Boolean Terrace;
	private Boolean SwimmingPool;
	private Boolean Garage;
	private Boolean Garden;
	private Boolean Furnished;
	private Boolean AirConditioning;
	private Boolean heater;
	
	
	@ManyToOne 
	Client client; 
	
	
	
	public WishList() {
		super();
	}
	
		
	
	public WishList(int idW, int surfacemin, int surfacemax, int budgetmin, int budgetmax, int nbRooms,
			Boolean buildable, Boolean serviced, Boolean terrace, Boolean swimmingPool, Boolean garage, Boolean garden,
			Boolean furnished, Boolean airConditioning, Boolean heater) {
		super();
		IdW = idW;
		this.surfacemin = surfacemin;
		this.surfacemax = surfacemax;
		this.budgetmin = budgetmin;
		this.budgetmax = budgetmax;
		this.nbRooms = nbRooms;
		this.buildable = buildable;
		this.serviced = serviced;
		Terrace = terrace;
		SwimmingPool = swimmingPool;
		Garage = garage;
		Garden = garden;
		Furnished = furnished;
		AirConditioning = airConditioning;
		this.heater = heater;
	}




	public int getIdW() {
		return IdW;
	}
	public void setIdW(int idW) {
		IdW = idW;
	}
	public int getSurfacemin() {
		return surfacemin;
	}
	public void setSurfacemin(int surfacemin) {
		this.surfacemin = surfacemin;
	}
	public int getSurfacemax() {
		return surfacemax;
	}
	public void setSurfacemax(int surfacemax) {
		this.surfacemax = surfacemax;
	}
	public int getBudgetmin() {
		return budgetmin;
	}
	public void setBudgetmin(int budgetmin) {
		this.budgetmin = budgetmin;
	}
	public int getBudgetmax() {
		return budgetmax;
	}
	public void setBudgetmax(int budgetmax) {
		this.budgetmax = budgetmax;
	}
	public int getNbRooms() {
		return nbRooms;
	}
	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}
	public Boolean getBuildable() {
		return buildable;
	}
	public void setBuildable(Boolean buildable) {
		this.buildable = buildable;
	}
	public Boolean getServiced() {
		return serviced;
	}
	public void setServiced(Boolean serviced) {
		this.serviced = serviced;
	}
	public Boolean getTerrace() {
		return Terrace;
	}
	public void setTerrace(Boolean terrace) {
		Terrace = terrace;
	}
	public Boolean getSwimmingPool() {
		return SwimmingPool;
	}
	public void setSwimmingPool(Boolean swimmingPool) {
		SwimmingPool = swimmingPool;
	}
	public Boolean getGarage() {
		return Garage;
	}
	public void setGarage(Boolean garage) {
		Garage = garage;
	}
	public Boolean getGarden() {
		return Garden;
	}
	public void setGarden(Boolean garden) {
		Garden = garden;
	}
	public Boolean getFurnished() {
		return Furnished;
	}
	public void setFurnished(Boolean furnished) {
		Furnished = furnished;
	}
	public Boolean getAirConditioning() {
		return AirConditioning;
	}
	public void setAirConditioning(Boolean airConditioning) {
		AirConditioning = airConditioning;
	}
	public Boolean getHeater() {
		return heater;
	}
	public void setHeater(Boolean heater) {
		this.heater = heater;
	}	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "WishList [IdW=" + IdW + ", surfacemin=" + surfacemin + ", surfacemax=" + surfacemax + ", budgetmin="
				+ budgetmin + ", budgetmax=" + budgetmax + ", nbRooms=" + nbRooms + ", buildable=" + buildable
				+ ", serviced=" + serviced + ", Terrace=" + Terrace + ", SwimmingPool=" + SwimmingPool + ", Garage="
				+ Garage + ", Garden=" + Garden + ", Furnished=" + Furnished + ", AirConditioning=" + AirConditioning
				+ ", heater=" + heater + "]";
	}
	
	
	
}
