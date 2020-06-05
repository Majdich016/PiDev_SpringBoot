package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.repository.BankRepository;

@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	BankRepository bankRepository;
	
	@Override
	public List<Bank> getAllBanks() {
		return bankRepository.getAllBanks();
		
	}

	@Override
	public Long addBank(Bank bank) {
		bankRepository.save(bank);
		return bank.getId();
	}

	@Override
	public void deleteBankByID(Long bankID) {
		Bank bank = bankRepository.findById(bankID).get();
		bankRepository.delete(bank);
		
	}

	@Override
	public Bank updateBank(Bank bank) {
		
		return bankRepository.save(bank);
	}


	@Override
	public Bank getBankByName(String nameBank) {
		return  bankRepository.getBankByName(nameBank);
		
	}

	@Override
	public Bank getBankById(Long id) {	
		return bankRepository.getBankById(id);
	}

}
