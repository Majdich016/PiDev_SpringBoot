package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Furniture;

public interface FurnitureRepository extends CrudRepository<Furniture, Integer>{

}
