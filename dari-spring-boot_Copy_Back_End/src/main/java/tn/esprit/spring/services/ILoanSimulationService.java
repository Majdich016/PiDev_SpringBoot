package tn.esprit.spring.services;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.LoanSimulation;

public interface ILoanSimulationService {

	public List<LoanSimulation> getAllSimulations();
	public List<LoanSimulation> getAllSimulationsByCin(Long cin);
	public LoanSimulation getSimulationById(Long id);
	public List<LoanSimulation> getAllSimulationsByNameBank(String nameBank);

	public LoanSimulation addSimulation(String nameBank,int nbrAnnee,int idImmob,double salaireClient,Long idClient) throws MailException, MessagingException;
	public LoanSimulation approcheSimulation();
	
	public void deleteSimulationsByCin(Long cin);
	public void deleteSimulationById(Long id);
	public void deleteOrNotifSimulationInScheduling() throws MailException, MessagingException;
	
	public void confirmSimulation(Long idSimulation) throws MailException, MessagingException;
	public void unConfirmSimulation(Long idSimulation) throws MailException, MessagingException;
	
	//////////////methode de calcul des simulations ////////////////

	public LoanSimulation simulate(String nameBank,int nbrAnnee,int idImmob,double salaireClient);
	public double calculTaux(Bank bank);
	public double calculTauxMensuel(Bank bank);
	public double calculNbrEcheance(int nbrAnnee); 
	public double calculCapaciteDeRemboursement(double salaire);
	public double calculInteret(Ad ad,Bank bank);
	public double calculMensualite(Ad ad,Bank bank,int nbrAnnee);
	public double calculPrincipale(Ad ad, Bank bank,int nbrAnnee);
	public double calculMontantRembourse(Ad ad, Bank bank,int nbrAnnee);
	public double calculInteretTotale(Ad ad, Bank bank,int nbrAnnee);
	
}
