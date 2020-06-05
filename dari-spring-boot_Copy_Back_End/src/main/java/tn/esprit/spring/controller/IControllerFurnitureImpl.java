package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Furniture;

import tn.esprit.spring.services.IFurnitureService;

@Controller
public class IControllerFurnitureImpl {
	
	@Autowired
	IFurnitureService iFurnitureService;
	
	
	
	public int ajouterMeuble(Furniture furniture){
		
		iFurnitureService.ajouterMeuble(furniture);
		
		return furniture.getId();
	}

}
