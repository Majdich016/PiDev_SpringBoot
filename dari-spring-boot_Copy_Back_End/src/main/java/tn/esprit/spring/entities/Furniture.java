package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_FURNITURE")
public class Furniture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "FURNITURE_ID")
	private int id;

	@Column(name = "FURNITURE_NAME")
	private String name;
	
	@Column(name = "FURNITURE_DESCRIPTION")
	private String description;

	@Column(name = "FURNITURE_PRICE")
	private float price;
	
	@Column(name = "FURNITURE_QUANTITY")
	private int quantity;
	
	@Column(name = "FURNITURE_PUBLISHED_DATE")
	@CreationTimestamp
	private Date publishedDate;
	
	
	
	@Enumerated(EnumType.STRING)
	private FurnitureType type;

	
	
	@OneToMany(mappedBy="furniture", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
	private List<ShoppingCard> shoppingCards= new ArrayList<>();


	
	

	public Furniture() {
		super();
	}





	public Furniture(int id, String name, String description, float price, int quantity, FurnitureType type,
			List<ShoppingCard> shoppingCards) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
		this.shoppingCards = shoppingCards;
	}





	public Furniture(int id, String name, String description, float price, int quantity, Date publishedDate,
			FurnitureType type, List<ShoppingCard> shoppingCards) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.publishedDate = publishedDate;
		this.type = type;
		this.shoppingCards = shoppingCards;
	}





	public Furniture(String name, String description, float price, int quantity, Date publishedDate, FurnitureType type,
			List<ShoppingCard> shoppingCards) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.publishedDate = publishedDate;
		this.type = type;
		this.shoppingCards = shoppingCards;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
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





	public float getPrice() {
		return price;
	}





	public void setPrice(float price) {
		this.price = price;
	}





	public int getQuantity() {
		return quantity;
	}





	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





	public Date getPublishedDate() {
		return publishedDate;
	}





	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}





	public FurnitureType getType() {
		return type;
	}





	public void setType(FurnitureType type) {
		this.type = type;
	}





	public List<ShoppingCard> getShoppingCards() {
		return shoppingCards;
	}





	public void setShoppingCards(List<ShoppingCard> shoppingCards) {
		this.shoppingCards = shoppingCards;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
