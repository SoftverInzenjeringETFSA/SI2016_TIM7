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
    private Integer id; 
    
    private Integer sigurnosni_id;
    
    @ManyToOne(targetEntity=Osoba.class)
    @JoinColumn(name="id_osobe")
    private Osoba osoba;
   
    public Administrator() {
    	
    }

	public Integer getSigurnosni_id() {
		return sigurnosni_id;
	}

	public void setSigurnosni_id(Integer sigurnosni_id) {
		this.sigurnosni_id = sigurnosni_id;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
}

