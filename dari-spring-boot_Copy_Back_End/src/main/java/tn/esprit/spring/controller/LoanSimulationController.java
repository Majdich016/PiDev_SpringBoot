package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.LoanSimulation;
import tn.esprit.spring.repository.LoanSimulationRepository;
import tn.esprit.spring.services.IBankService;
import tn.esprit.spring.services.ILoanSimulationService;


@RestController
@RequestMapping("/Simulation")
public class LoanSimulationController {

	@Autowired
	ILoanSimulationService iLoanSimulationService;
	
	@Autowired
	IBankService iBankService;
	
	@Autowired
	LoanSimulationRepository loanSimulationRepository;
	
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/simulate/
	@PostMapping("/simulate/{idImmob}/{nameBank}/{nbrAnnee}/{salaire}")
	@ResponseBody
	public LoanSimulation Simulate(@PathVariable int idImmob,
									@PathVariable String nameBank,
									@PathVariable int nbrAnnee,
									@PathVariable double salaire ){
		
		LoanSimulation result=iLoanSimulationService.simulate(nameBank, nbrAnnee, idImmob, salaire);
		return result;
	}
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/addSimulation/
	@PostMapping("/addSimulation/{idImmob}/{idClient}/{nameBank}/{nbrAnnee}/{salaire}")
	@ResponseBody
	public ResponseEntity<String> addSimulation(@PathVariable int idImmob,
										@PathVariable Long idClient,
										@PathVariable String nameBank,
										@PathVariable int nbrAnnee,
										@PathVariable double salaire) throws MailException, MessagingException{
		
		 List<LoanSimulation> list=new ArrayList<LoanSimulation>();
		 list=loanSimulationRepository.countAllSimulationsByidClient(idClient);
		 
		if(list.isEmpty())
		{		
			iLoanSimulationService.addSimulation(nameBank, nbrAnnee, idImmob, salaire,idClient);
			System.out.println("aaaaa");
			
			return ResponseEntity.ok("simulation has been add ! ");
		}
		else 
			
		return ResponseEntity.ok("sorry you have a simulation already in progress! ");
	}
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/getAllSimulations
	@GetMapping("/getAllSimulations")
    @ResponseBody
	public List<LoanSimulation> getAllSimulations() {	
		return iLoanSimulationService.getAllSimulations();
	}
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/getAllSimulationsByCin
	@GetMapping("/getAllSimulationsByCin/{cin}")
    @ResponseBody
	public List<LoanSimulation> getAllSimulationsByCin(@PathVariable("cin") Long cin ) {	
		return iLoanSimulationService.getAllSimulationsByCin(cin);
	}
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/getAllSimulationsByNameBank
	@GetMapping("/getAllSimulationsByNameBank/{nameBank}")
    @ResponseBody
	public List<LoanSimulation> getAllSimulationsByNameBank(@PathVariable("nameBank") String nameBank ) {	
		return iLoanSimulationService.getAllSimulationsByNameBank(nameBank);
	}
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/deleteSimulationsByCin/{cin}
	@DeleteMapping("/deleteSimulationsByCin/{cin}")
	@ResponseBody 
	public void deleteSimulationsByCin(@PathVariable("cin") Long cin ){
		iLoanSimulationService.deleteSimulationsByCin(cin);
		}
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/deleteSimulationById/{cin}
	@DeleteMapping("/deleteSimulationById/{id}")
	@ResponseBody 
	public void deleteSimulationById(@PathVariable("id") Long id ){
		iLoanSimulationService.deleteSimulationById(id);
		}
	
//	// http://localhost:8081/SpringMVC/servlet/Simulation/deleteSimulationBy
//	@DeleteMapping("/deleteSimulationBy")
//	@ResponseBody 
//	public void deleteSimulationBy() throws MailException, MessagingException{
//		iLoanSimulationService.deleteOrNotifSimulationInScheduling();
//		}
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/confirmSimulation/{cin}
	@GetMapping("/confirmSimulation/{id}")
	//@ResponseBody 
	public void confirmSimulation(@PathVariable("id") Long id ) throws MailException, MessagingException{
		iLoanSimulationService.confirmSimulation(id);
		}
	
	// http://localhost:8081/SpringMVC/servlet/Simulation/unconfirmSimulation/{cin}
	@PutMapping("/unconfirmSimulation/{id}")
	@ResponseBody 
	public void unconfirmSimulation(@PathVariable("id") Long id ) throws MailException, MessagingException{
		iLoanSimulationService.unConfirmSimulation(id);
		        }
}
