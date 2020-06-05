package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Client;


public interface ClientRepository extends CrudRepository<Client,Long>{

	
    @Query(value = "SELECT * FROM user WHERE cin=?1",nativeQuery=true)
    public Client getClientByCin(Long cin);
}
