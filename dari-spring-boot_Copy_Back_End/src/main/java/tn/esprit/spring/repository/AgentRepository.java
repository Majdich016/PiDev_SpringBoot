package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{

    @Query(value = "SELECT * FROM t_bank b join user u on u.id=b.agent_bank_id WHERE u.dtype='Agent' AND b.name_bank=?1",nativeQuery=true)
    public Agent getAgentByNameBank(String nameBank);
    
    @Query(value = "SELECT * FROM user WHERE dtype='Agent'",nativeQuery=true)
    public Agent getAgent();
}
