package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "t_Appointment")
//@Inheritance(strategy = InheritanceType.JOINED)

public class Appointment  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long IdAppointement; 
	@Temporal(TemporalType.DATE)
	private Date dateAppointement;
	private int Visibility;
	private String state;
	private int Heure;
	private String Attendance;

	
	
	@ManyToOne
	Client client;
	
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Long getIdAppointement() {
		return IdAppointement;
	}
	public void setIdAppointement(Long idAppointement) {
		IdAppointement = idAppointement;
	}
	public Date getDateAppointement() {
		return dateAppointement;
	}
	public void setDateAppointement(Date dateAppointement) {
		this.dateAppointement = dateAppointement;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	public int getVisibility() {
		return Visibility;
	}
	public void setVisibility(int visibility) {
		Visibility = visibility;
	}
	
	
	
	public int getHeure() {
		return Heure;
	}
	public void setHeure(int heure) {
		Heure = heure;
		
	}
	public String getAttendance() {
		return Attendance;
	}
	public void setAttendance(String attendance) {
		Attendance = attendance;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Appointment [IdAppointement=" + IdAppointement + ", dateAppointement=" + dateAppointement
				+ ", Visibility=" + Visibility + ", state=" + state + ", Heure=" + Heure + ", Attendance=" + Attendance
				+ "]";
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(Long idAppointement, Date dateAppointement, int visibility, String state, int heure,
			String attendance) {
		super();
		IdAppointement = idAppointement;
		this.dateAppointement = dateAppointement;
		Visibility = visibility;
		this.state = state;
		Heure = heure;
		Attendance = attendance;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
