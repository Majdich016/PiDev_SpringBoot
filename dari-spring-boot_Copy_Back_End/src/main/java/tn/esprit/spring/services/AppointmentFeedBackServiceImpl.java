package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.AppointmentFeedBack;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AppointmentFeedBackRepository;
import tn.esprit.spring.repository.ClientRepository;


@Service
public class AppointmentFeedBackServiceImpl implements AppointmentFeedBackService {
	@Autowired
	AppointmentFeedBackRepository AppointmentFeedBackRepository;
	
	private static final Logger l= LogManager.getLogger(AppointmentServiceImpl.class);

	@Override
	public List<AppointmentFeedBack> retrieveAllAppointmentFeedBack() {
		List<AppointmentFeedBack> appF=(List<AppointmentFeedBack>) AppointmentFeedBackRepository.findAll();
		for(AppointmentFeedBack appointmentF:appF) {
			l.info("appointmentFeedBacks +++++++++"+ appointmentF);}
		
		return null;
	}

	@Override
	public AppointmentFeedBack addAppointmentFeedBack(AppointmentFeedBack af) {
		List<AppointmentFeedBack> appF=(List<AppointmentFeedBack>) AppointmentFeedBackRepository.findAll();
		int max=0;
		for(AppointmentFeedBack appointmentF:appF) {
			if(appointmentF.isLikes()==true) {
				max++;
			}
			if(max>3) {
				af.setDescriptionFeedBack("good appointment good user");
			
		}
		}
		
		AppointmentFeedBackRepository.save(af);
		return null;
	}

	@Override
	public void deleteAppointmentFeedBack(String id) {
		AppointmentFeedBackRepository.deleteById(Long.parseLong(id));		

		
	}

	@Override
	public AppointmentFeedBack updateAppointmentFeedBack(AppointmentFeedBack af) {
		AppointmentFeedBackRepository.save(af);

		return null;
	}

	@Override
	public AppointmentFeedBack retrieveAppointmentFeedBack(String id) {
		return null;
	}

	@Override
	public int countLikes() {
		List<AppointmentFeedBack> appF=(List<AppointmentFeedBack>) AppointmentFeedBackRepository.findAll();
		int max=0;
		for(AppointmentFeedBack appointmentF:appF) {
			if(appointmentF.isLikes()==true) {
				max++;
			}}
			l.info("you have +++++++++"+ max+"likes");

		
		
		return max;
	}

	
	}

		
	

