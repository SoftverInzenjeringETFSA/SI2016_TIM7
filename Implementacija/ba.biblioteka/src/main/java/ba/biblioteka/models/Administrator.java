package ba.biblioteka.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="administrator")

public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idAdministratora; 
    
    private Integer SigurnosniID;
    
    @ManyToOne(targetEntity=Osoba.class)
    @JoinColumn(name="idOsobe")
    private Osoba osoba;
    
    public Osoba getOsoba(){
    	return osoba;
    }
    
	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
    
    
    public Administrator() {
    	
    }
	
	
	public Integer getSigurnostniID() {
		return this.SigurnosniID;
	}
	public void setSigurnostniID(Integer security) {
		this.SigurnosniID= security;
	}
	
}

