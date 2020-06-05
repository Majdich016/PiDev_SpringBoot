package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_SHOPPING_CARD")
public class ShoppingCard implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "SHOPPING_CARD_ID")
	private int id;

	
	@Column(name = "SHOPPING_CARD_NBR_ARTICLE")
	private int nbrArticle;
	
	@Column(name = "SHOPPING_CARD_TOTAL_ARTICLE")
	private int totalArticle;
	
	@ManyToOne
	private Furniture furniture;
	
	@OneToOne(mappedBy="shoppingCard")
	private Ordered ordered;
}
