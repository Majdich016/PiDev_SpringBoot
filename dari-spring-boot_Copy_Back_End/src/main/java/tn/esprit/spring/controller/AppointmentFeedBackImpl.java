package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.AppointmentFeedBack;
import tn.esprit.spring.services.AppointmentFeedBackService;

@RestController
public class AppointmentFeedBackImpl {
	@Autowired
	AppointmentFeedBackService AppointmentFeedBackService;
	
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-Feed

		@GetMapping("/retrieve-all-Feed")
		 @ResponseBody
		 public List<AppointmentFeedBack> getAppointmentFeedBack() {
		 List<AppointmentFeedBack> list = AppointmentFeedBackService.retrieveAllAppointmentFeedBack();
		 return list;
		} 
		
		// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-appointmentFeedBack
			  @PostMapping("/add-appointmentFeedBack")
			  @ResponseBody
			  public AppointmentFeedBack addAppointment(@RequestBody AppointmentFeedBack a) {
			  AppointmentFeedBack app = AppointmentFeedBackService.addAppointmentFeedBack(a);
			 return app;
			  }
			  
			  //http://localhost:8081/SpringMVC/servlet/remove-feed/{user-id}
			  @DeleteMapping("/remove-feed/{appointment-id}")
			   @ResponseBody
			   public void removeAppointment(@PathVariable("appointment-id") String id) {
			   AppointmentFeedBackService.deleteAppointmentFeedBack(id);
			   }
			  // http://localhost:8081/SpringMVC/servlet/modify-feed
			   @PutMapping("/modify-feed")
			   @ResponseBody
			   public AppointmentFeedBack modifyFeed(@RequestBody AppointmentFeedBack feed) {
			   return AppointmentFeedBackService.updateAppointmentFeedBack(feed);
			   }
			   
				// http://localhost:8081/SpringMVC/servlet/block-feed

			  // @PutMapping("/block-feed")
			   //@ResponseBody
			   //public void BlockFeed() {
				 //  AppointmentFeedBackService.BlockUserByFeedBack();;
			   //}
			   
			

}
