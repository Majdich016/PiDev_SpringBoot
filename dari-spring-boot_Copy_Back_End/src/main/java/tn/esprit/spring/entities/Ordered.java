package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORDERED")
public class Ordered implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDRED_ID")
	private int ordredId;
	
	@Column(name = "ORDRED_NUMBER")
	private String number;
	
	@Column(name = "ORDRED_DATE")
	private Date 	ordredDate;
	
	@Column(name = "SHIPPED_DATE")
	private Date 	shippedDate;
	
	@Column(name = "ORDRED_SHIP_TO")
	private String 	shipTo;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Column(name = "ORDRED_TOTAL")
	private float 	total;
	
	@ManyToOne
	private Delivery delivery;
	
	@OneToOne
	private ShoppingCard shoppingCard;

	
	

}
