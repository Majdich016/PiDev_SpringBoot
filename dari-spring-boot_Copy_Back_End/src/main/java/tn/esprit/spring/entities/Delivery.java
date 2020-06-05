package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_DELIVERY")
public class Delivery implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DELIVERY_ID")
	private int deliveryId;
	
	
	@Column(name = "DELIVERY_CUSTOMER_NAME")
	private String customerName;
	
	@Column(name = "DELIVERY_CUSTOMER_ADDRESS")
	private String customerAddress;
	
	
	@Column(name = "DELIVERY_DESCRIPTION")
	private String description;
	
	
	@OneToMany(mappedBy="delivery", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
	private List<Ordered> ordereds= new ArrayList<>();
}
