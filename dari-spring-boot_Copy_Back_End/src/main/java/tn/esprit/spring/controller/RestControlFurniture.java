package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Furniture;
import tn.esprit.spring.services.IFurnitureService;


@RestController
public class RestControlFurniture {
	
	
	@Autowired
	IFurnitureService iFurnitureService;
	
	@PostMapping("/ajouterMeuble")
	@ResponseBody
	public Furniture ajouterMeuble(@RequestBody Furniture furniture){
		iFurnitureService.ajouterMeuble(furniture);
		
		return furniture;
	}

}
