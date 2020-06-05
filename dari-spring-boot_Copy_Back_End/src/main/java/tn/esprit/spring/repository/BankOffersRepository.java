package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.BankOffers;

public interface BankOffersRepository extends JpaRepository<BankOffers, Long> {

}
