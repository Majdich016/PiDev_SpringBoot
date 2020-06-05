package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "T_AD")
public class Ad implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int IdAd;
		
		private String Description;
		private String Location;
		//private int Area; area heya location o.O
		
		@Temporal(TemporalType.DATE)
		private Date AddDate;

		private int ViewsNumber;
		private Boolean Success;
		private int Score;
		
		
		private float Price;
		private int nbRooms;
		private int surface;
		
		
		//options
		private Boolean Terrace;
		private Boolean SwimmingPool;
		private Boolean Garage;
		private Boolean Garden;
		private Boolean Furnished;
		private Boolean AirConditioning;
		private Boolean heater;
		//ces 2 derniers attributs si l'annonces est pour un terrain (constructible/viabilisé)
		private Boolean buildable;  
		private Boolean serviced;
		
		
		@Enumerated(EnumType.STRING)
		//@NotNull
		private KindOfGood kindofgood;
		@ManyToOne
		User user;
		
		
		@OneToMany
		(mappedBy="ads", 
				cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
				fetch=FetchType.EAGER)
		private List<Comment> comments = new ArrayList<>();
		
		@OneToMany
		(cascade = CascadeType.ALL, mappedBy="ad")
		private Set<Multimedia> multimedias;
		
		@ManyToMany(cascade = CascadeType.ALL) 
		private Set<FavoriteAd> favoriteAd;

		
		public Ad() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public Ad(int idAd, String description, String location, Date addDate, int viewsNumber, Boolean success,
				int score, float price, int nbRooms, int surface, Boolean terrace, Boolean swimmingPool, Boolean garage,
				Boolean garden, Boolean furnished, Boolean airConditioning, Boolean heater, Boolean buildable,
				Boolean serviced, KindOfGood kindofgood, List<Comment> comments, Set<Multimedia> multimedias,
				Set<FavoriteAd> favoriteAd) {
			super();
			IdAd = idAd;
			Description = description;
			Location = location;
			AddDate = addDate;
			ViewsNumber = viewsNumber;
			Success = success;
			Score = score;
			Price = price;
			this.nbRooms = nbRooms;
			this.surface = surface;
			Terrace = terrace;
			SwimmingPool = swimmingPool;
			Garage = garage;
			Garden = garden;
			Furnished = furnished;
			AirConditioning = airConditioning;
			this.heater = heater;
			this.buildable = buildable;
			this.serviced = serviced;
			this.kindofgood = kindofgood;
			this.comments = comments;
			this.multimedias = multimedias;
			this.favoriteAd = favoriteAd;
		}




		public int getIdAd() {
			return IdAd;
		}


		public void setIdAd(int idAd) {
			IdAd = idAd;
		}


		public String getDescription() {
			return Description;
		}


		public void setDescription(String description) {
			Description = description;
		}


		public String getLocation() {
			return Location;
		}


		public void setLocation(String location) {
			Location = location;
		}


		public Date getAddDate() {
			return AddDate;
		}


		public void setAddDate(Date addDate) {
			AddDate = addDate;
		}


		public int getViewsNumber() {
			return ViewsNumber;
		}


		public void setViewsNumber(int viewsNumber) {
			ViewsNumber = viewsNumber;
		}


		public Boolean getSuccess() {
			return Success;
		}


		public void setSuccess(Boolean success) {
			Success = success;
		}


		public int getScore() {
			return Score;
		}


		public void setScore(int score) {
			Score = score;
		}


		public float getPrice() {
			return Price;
		}


		public void setPrice(float price) {
			Price = price;
		}


		public int getNbRooms() {
			return nbRooms;
		}


		public void setNbRooms(int nbRooms) {
			this.nbRooms = nbRooms;
		}


		public int getSurface() {
			return surface;
		}


		public void setSurface(int surface) {
			this.surface = surface;
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


		public KindOfGood getKindofgood() {
			return kindofgood;
		}


		public void setKindofgood(KindOfGood kindofgood) {
			this.kindofgood = kindofgood;
		}


		public List<Comment> getComments() {
			return comments;
		}


		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}


		public Set<Multimedia> getMultimedias() {
			return multimedias;
		}


		public void setMultimedias(Set<Multimedia> multimedias) {
			this.multimedias = multimedias;
		}


		public Set<FavoriteAd> getFavoriteAd() {
			return favoriteAd;
		}


		public void setFavoriteAd(Set<FavoriteAd> favoriteAd) {
			this.favoriteAd = favoriteAd;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}



		@Override
		public String toString() {
			return "Ad [IdAd=" + IdAd + ", Description=" + Description + ", Location=" + Location + ", AddDate="
					+ AddDate + ", ViewsNumber=" + ViewsNumber + ", Success=" + Success + ", Score=" + Score
					+ ", Price=" + Price + ", nbRooms=" + nbRooms + ", surface=" + surface + ", Terrace=" + Terrace
					+ ", SwimmingPool=" + SwimmingPool + ", Garage=" + Garage + ", Garden=" + Garden + ", Furnished="
					+ Furnished + ", AirConditioning=" + AirConditioning + ", heater=" + heater + ", buildable="
					+ buildable + ", serviced=" + serviced + ", kindofgood=" + kindofgood + ", comments=" + comments
					+ ", multimedias=" + multimedias + ", favoriteAd=" + favoriteAd + "]";
		}


		
		


	
	
		
		
		
}
