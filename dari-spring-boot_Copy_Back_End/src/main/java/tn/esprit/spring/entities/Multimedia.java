package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "T_MULTIMEDIA")
public class Multimedia implements Serializable {
	private static final long serialVersionUID = 1L;
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private int IdMedia;
			private String Description;
			
			@Enumerated(EnumType.STRING)
			//@NotNull
			private TypeMedia typemedia;

			@ManyToOne
			private Ad ad;

			public Multimedia() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Multimedia(int idMedia, String description, TypeMedia typemedia) {
				super();
				IdMedia = idMedia;
				Description = description;
				this.typemedia = typemedia;
			}
			


			public int getIdMedia() {
				return IdMedia;
			}


			public void setIdMedia(int idMedia) {
				IdMedia = idMedia;
			}


			public String getDescription() {
				return Description;
			}


			public void setDescription(String description) {
				Description = description;
			}


			public TypeMedia getTypemedia() {
				return typemedia;
			}


			public void setTypemedia(TypeMedia typemedia) {
				this.typemedia = typemedia;
			}


			public static long getSerialversionuid() {
				return serialVersionUID;
			}


			@Override
			public String toString() {
				return "Multimedia [IdMedia=" + IdMedia + ", Description=" + Description + ", typemedia=" + typemedia
						+ "]";
			}



		

}
