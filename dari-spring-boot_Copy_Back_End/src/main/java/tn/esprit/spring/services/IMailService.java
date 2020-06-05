package tn.esprit.spring.services;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import tn.esprit.spring.entities.User;

public interface IMailService {

	public void sendEmailConfirmation(User client,Long idSimulation) throws MailException, MessagingException;
	public void sendEmailWithAttachment(User client,User agent,String attch,Long idLoan) throws MessagingException, MailException;
	public void sendEmailUnConfirmation(User client,Long idSimulation) throws MailException, MessagingException;
	public void sendEmailNotifAgent(User agent,int nbrSimulation) throws MailException, MessagingException;
}
