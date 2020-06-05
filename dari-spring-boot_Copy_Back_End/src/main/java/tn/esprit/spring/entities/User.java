package tn.esprit.spring.entities;




import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class User implements Serializable {
	

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Long id;   
	
	private Long cin;
	
	private String FirstName;
	
	private String Lastname;

	private Date dateNaissance;
	private String Email;
	private String Password;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", cin=" + cin + ", FirstName=" + FirstName + ", Lastname=" + Lastname
				+ ", dateNaissance=" + dateNaissance + ", Email=" + Email + ", Password=" + Password + ", Ad=" + Ad
				+ "]";
	}
	
	
	
	public User(Long id, Long cin, String firstName, String lastname, Date dateNaissance, String email,
			String password) {
		super();
		this.id = id;
		this.cin = cin;
		FirstName = firstName;
		Lastname = lastname;
		this.dateNaissance = dateNaissance;
		Email = email;
		Password = password;
	}

	

	public User(Long cin, String firstName, String lastname, Date dateNaissance, String email, String password) {
		super();
		this.cin = cin;
		FirstName = firstName;
		Lastname = lastname;
		this.dateNaissance = dateNaissance;
		Email = email;
		Password = password;
	}



	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Ad> Ad;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}	
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public Set<Ad> getAd() {
		return Ad;
	}
	public void setAd(Set<Ad> ad) {
		Ad = ad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ad == null) ? 0 : Ad.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((Lastname == null) ? 0 : Lastname.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((cin == null) ? 0 : cin.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Ad == null) {
			if (other.Ad != null)
				return false;
		} else if (!Ad.equals(other.Ad))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (Lastname == null) {
			if (other.Lastname != null)
				return false;
		} else if (!Lastname.equals(other.Lastname))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (cin == null) {
			if (other.cin != null)
				return false;
		} else if (!cin.equals(other.cin))
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

	
	
	
	

}

	
	
	
	
	
	