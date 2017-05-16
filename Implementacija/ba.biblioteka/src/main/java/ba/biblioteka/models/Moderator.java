package ba.biblioteka.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="moderator")

public class Moderator implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idModeratora; 
    
    private Integer SigurnosniID;
    private String Adresa;
    private String Grad;
    private String Email;
    
    private String idOsobe;

   
    
    public Moderator() {
    	
    }	
	
	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}

	public String getGrad() {
		return Grad;
	}

	public void setGrad(String grad) {
		Grad = grad;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getIdOsobe() {
		return idOsobe;
	}

	public void setIdOsobe(String idOsobe) {
		this.idOsobe = idOsobe;
	}

	public Integer getSigurnosniID() {
		return SigurnosniID;
	}

	public void setSigurnosniID(Integer sigurnosniID) {
		SigurnosniID = sigurnosniID;
	}
	
}

