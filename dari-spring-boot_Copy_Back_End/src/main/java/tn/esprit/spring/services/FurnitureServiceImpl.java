package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Furniture;
import tn.esprit.spring.repository.FurnitureRepository;

@Service
public class FurnitureServiceImpl implements IFurnitureService{

	@Autowired
	FurnitureRepository furnitureRepository;
	
	
	
	@Override
	public int ajouterMeuble(Furniture furniture) {
		
		furnitureRepository.save(furniture);
		
		
		
		return furniture.getId();
	}

}
