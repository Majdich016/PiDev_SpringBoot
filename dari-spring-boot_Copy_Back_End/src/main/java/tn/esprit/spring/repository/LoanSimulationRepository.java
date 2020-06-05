package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.LoanSimulation;

public interface LoanSimulationRepository extends JpaRepository<LoanSimulation, Long> {

    @Query(value = "SELECT * FROM t_loan_simulation l "
    				+ "join user u on l.client_id=u.id  "
    				+ "WHERE dtype='Client' and u.cin=?1",nativeQuery=true)
    public List<LoanSimulation> getAllSimulationsByCin(Long cin);
    
    @Query(value="SELECT * FROM t_loan_simulation l "
    			+ "join t_bank b on l.bank_id_bank=b.id_bank "
    			+ "WHERE b.name_bank=?1",nativeQuery=true)
    public List<LoanSimulation> getAllSimulationsByNameBank(String nameBank);
    
    @Query(value="SELECT * FROM t_loan_simulation WHERE salaire=?1",nativeQuery=true)
    public List<LoanSimulation> getAllSimulationsBySalary(double salaire);
    
    @Query(value="SELECT * FROM t_loan_simulation WHERE client_id=?1",nativeQuery=true)
    public LoanSimulation getSimulationByidClient(Long idClinet);
    
    @Query(value="SELECT * FROM t_loan_simulation WHERE client_id=?1 AND status='IN_PROGRESS'",nativeQuery=true)
    public List<LoanSimulation> countAllSimulationsByidClient(Long idClient);
    
    @Query(value="SELECT COUNT(*) FROM t_loan_simulation WHERE status='IN_PROGRESS'",nativeQuery=true)
    public int countAllSimulationsInProgress();
    
    @Query(value="SELECT * FROM t_loan_simulation WHERE status='DENIED'",nativeQuery=true)
    public List<LoanSimulation> getAllSimulationsDenied();
    
    @Query(value="SELECT * FROM t_loan_simulation WHERE status='IN_PROGRESS'",nativeQuery=true)
    public List<LoanSimulation> getAllSimulationsInProgress();
    
    @Query(value="SELECT DISTINCT u.id FROM t_loan_simulation l"
    		  + " join t_bank b ON b.id_bank=l.bank_id_bank"
    		  + " JOIN user u ON u.id=b.agent_bank_id  "
    		  + "WHERE u.dtype='Agent'",nativeQuery=true)
    public Long getAgentFromSimulation();
    
    
    
    
    @Modifying
    @Transactional
    @Query(value="DELETE FROM t_loan_simulation WHERE id_loan=?1",nativeQuery=true)
    public void delete(Long id);
    
    @Modifying
    @Transactional
    @Query(value="DELETE FROM t_loan_simulation JOIN user u WHERE u.cin=?1 AND u.dtype='Client'",nativeQuery=true)
    public void deleteAllSimulationsByCin(Long id);
}
