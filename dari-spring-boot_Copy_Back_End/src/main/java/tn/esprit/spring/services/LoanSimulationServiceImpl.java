package tn.esprit.spring.services;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Agent;
import tn.esprit.spring.entities.Bank;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.LoanSimulation;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.AgentRepository;
import tn.esprit.spring.repository.BankRepository;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.LoanSimulationRepository;

@Service
@Configuration
@ConditionalOnProperty(name="scheduling.enabled",matchIfMissing=true)
public class LoanSimulationServiceImpl implements ILoanSimulationService {

	@Autowired
	LoanSimulationRepository loanSimulationRepository;

	@Autowired
	BankRepository bankRepository;

	@Autowired
	AdRepository adRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	AgentRepository agentRepository;

	@Autowired
	IPdfService iPdfService;

	@Autowired
	IMailService iMailService;

	/*---------------Retrieve data from dataBase--------*/

	@Override
	public List<LoanSimulation> getAllSimulations() {
		return loanSimulationRepository.findAll();
	}

	@Override
	public List<LoanSimulation> getAllSimulationsByCin(Long cin) {
		return loanSimulationRepository.getAllSimulationsByCin(cin);
	}

	@Override
	public List<LoanSimulation> getAllSimulationsByNameBank(String nameBank) {

		return loanSimulationRepository.getAllSimulationsByNameBank(nameBank);
	}

	@Override
	public LoanSimulation getSimulationById(Long id) {

		return loanSimulationRepository.findById(id).get();
	}

	/*--------------Add simulation with sending mails to agent and client--------------*/

	@Override
	public LoanSimulation addSimulation(String nameBank, int nbrAnnee, int idImmob, double salaireClient, Long idClient)
			throws MailException, MessagingException {

		LoanSimulation simulation = simulate(nameBank, nbrAnnee, idImmob, salaireClient);
		Client client = clientRepository.findById(idClient).get();
		Agent agent = agentRepository.getAgentByNameBank(nameBank);
		simulation.setClient(client);
		simulation.setStatus("IN_PROGRESS");

		loanSimulationRepository.save(simulation);

		iMailService.sendEmailWithAttachment(client, agent, iPdfService.toPDF(simulation.getIdLoan()),
				simulation.getIdLoan());

		return (simulation);
	}

	@Override
	public LoanSimulation approcheSimulation() {

		return null;
	}

	/*--------------------Different Methods to delete simulation---------------- */

	@Override
	public void deleteSimulationsByCin(Long cin) {
		loanSimulationRepository.deleteAllSimulationsByCin(cin);
	}

	@Override
	public void deleteSimulationById(Long id) {
		loanSimulationRepository.delete(id);
	}

	@Override
	@Scheduled(cron="* 1 * * * *")
	public void deleteOrNotifSimulationInScheduling() throws MailException, MessagingException {

		List<LoanSimulation> list1 = loanSimulationRepository.getAllSimulationsDenied();
		List<LoanSimulation> list2= loanSimulationRepository.getAllSimulationsInProgress();
					   Agent agent=agentRepository.getAgent();
		
		if(!list1.isEmpty()){
					
			for (LoanSimulation simulation : list1) {
				deleteSimulationById(simulation.getIdLoan());
			}
			
			if(!list2.isEmpty()){

				int nbr = loanSimulationRepository.countAllSimulationsInProgress();
				System.out.println(nbr);
				iMailService.sendEmailNotifAgent(agent, nbr);
				
			}
			
		}
		
		else if(!list2.isEmpty()){

				int nbr = loanSimulationRepository.countAllSimulationsInProgress();
				System.out.println(nbr);
				iMailService.sendEmailNotifAgent(agent, nbr);
				
		}	

	}

	

	/*-----------------Methods of confirm the request of simulations-----------*/

	@Override
	public void confirmSimulation(Long idSimulation) throws MailException, MessagingException {

		LoanSimulation simulation = loanSimulationRepository.findById(idSimulation).get();
		Client client = simulation.getClient();
		simulation.setStatus("CONFIRMED");
		loanSimulationRepository.save(simulation);
		iMailService.sendEmailConfirmation(client, idSimulation);

	}

	@Override
	public void unConfirmSimulation(Long idSimulation) throws MailException, MessagingException {

		LoanSimulation simulation = loanSimulationRepository.findById(idSimulation).get();
		Client client = simulation.getClient();

		simulation.setStatus("DENIED");

		loanSimulationRepository.save(simulation);

		iMailService.sendEmailUnConfirmation(client, idSimulation);

	}

	/*---------------- Methods of Calculating simulations------------*/

	@Override
	public LoanSimulation simulate(String nameBank, int nbrAnnee, int idImmob, double salaireClient) {
		LoanSimulation simulation = new LoanSimulation();

		Bank bank = bankRepository.getBankByName(nameBank);

		Ad ad = adRepository.findById(idImmob).get();

		// Client client=clientRepository.getClientByCin(cin);
		// simulation.setClient(client);
		simulation.setBank(bank);
		simulation.setTaux(calculTaux(bank));
		simulation.setMensuel(calculTauxMensuel(bank));
		simulation.setCapaciteDeRembouresement(calculCapaciteDeRemboursement(salaireClient));
		simulation.setMensualite(calculMensualite(ad, bank, nbrAnnee));
		simulation.setInteret(calculInteret(ad, bank));
		simulation.setInteretTotale(calculInteretTotale(ad, bank, nbrAnnee));
		simulation.setPrincipale(calculPrincipale(ad, bank, nbrAnnee));
		simulation.setMontantRembourse(calculMontantRembourse(ad, bank, nbrAnnee));
		simulation.setPrixImmob(ad.getPrice());
		simulation.setSalaire(salaireClient);

		return simulation;
	}

	@Override
	public double calculTaux(Bank bank) {
		double taux = (bank.getTauxMoyenDuMarche() + bank.getMargeInteret()) / 100;
		return round(taux);
	}

	@Override
	public double calculTauxMensuel(Bank bank) {
		return round(calculTaux(bank) / 12);
	}

	@Override
	public double calculNbrEcheance(int nbrAnnee) {
		return round(nbrAnnee * 12);
	}

	@Override
	public double calculCapaciteDeRemboursement(double salaire) {
		return round((salaire * 0.4));
	}

	@Override
	public double calculInteret(Ad ad, Bank bank) {
		double montant = ad.getPrice();
		double tauxMensuel = calculTauxMensuel(bank);
		return round(montant * tauxMensuel);
	}

	@Override
	public double calculMensualite(Ad ad, Bank bank, int nbrAnnee) {
		double tauxMensuel = calculTauxMensuel(bank);
		double interet = ad.getPrice() * tauxMensuel;

		double nbrEcheance = calculNbrEcheance(nbrAnnee) * (-1);
		double puissance = Math.pow(1 + tauxMensuel, nbrEcheance);
		double q = 1 - puissance;
		return round(interet / q);
	}

	@Override
	public double calculPrincipale(Ad ad, Bank bank, int nbrAnnee) {
		double mensualite = calculMensualite(ad, bank, nbrAnnee);
		double interet = calculInteret(ad, bank);

		return round(mensualite - interet);
	}

	@Override
	public double calculMontantRembourse(Ad ad, Bank bank, int nbrAnnee) {
		return round(calculNbrEcheance(nbrAnnee) * calculMensualite(ad, bank, nbrAnnee));
	}

	@Override
	public double calculInteretTotale(Ad ad, Bank bank, int nbrAnnee) {
		return round(calculMontantRembourse(ad, bank, nbrAnnee) - ad.getPrice());
	}

	public double round(double d) {
		double db = (double) Math.round(d * 1000) / 1000;
		return db;
	}

}
