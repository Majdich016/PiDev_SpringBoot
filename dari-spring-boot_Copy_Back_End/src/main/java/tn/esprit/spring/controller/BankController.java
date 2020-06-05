package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.services.IBankService;

@RestController
@RequestMapping("/Bank")
public class BankController {

	@Autowired
	IBankService ibankService;
	
	// http://localhost:8081/SpringMVC/servlet/Bank/getAllBanks
	@GetMapping("/getAllBanks")
    @ResponseBody
	public List<Bank> getAllBanks() {
		
		return ibankService.getAllBanks();
	}
	
	// http://localhost:8081/SpringMVC/servlet/Bank/addBank
	@PostMapping("/addBank")
	@ResponseBody
	public Bank addBank(@RequestBody Bank bank){
		ibankService.addBank(bank);
		return bank;
	}
	
	// http://localhost:8081/SpringMVC/servlet/Bank/deleteBank/{bankId}
	@DeleteMapping("/deleteBank/{bankId}")
	@ResponseBody 
	public void deleteBankByID(@PathVariable("bankId") Long bankId ){
		ibankService.deleteBankByID(bankId);
	}
	
	// http://localhost:8081/SpringMVC/servlet/Bank/updateBank
	@PutMapping("/updateBank")
	@ResponseBody 
	public Bank updateBank(@RequestBody Bank bank){
		return ibankService.updateBank(bank);
	}	
	
	// http://localhost:8081/SpringMVC/servlet/Bank/getBankById/{id}
	@GetMapping("/getBankById/{id}")
	@ResponseBody
	public Bank getBankById(@PathVariable("id") Long id){
		return ibankService.getBankById(id);
	}
}
