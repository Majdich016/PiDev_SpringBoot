package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.LoanSimulation;

public interface BankRepository extends JpaRepository<Bank, Long> {
  
    @Query(value = "SELECT * FROM t_bank",nativeQuery=true) 
    public List<Bank> getAllBanks();
    
    @Query(value = "SELECT * FROM t_bank WHERE name_bank=?1",nativeQuery=true)
    public Bank getBankByName(String nameBank);  
    
    @Query(value = "SELECT * FROM t_bank WHERE id_bank=?1",nativeQuery=true) 
    public Bank getBankById(Long id);
}
