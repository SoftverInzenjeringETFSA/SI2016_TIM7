package ba.biblioteka.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="kategorija")

public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    
    private String naziv_kategorije;
    private String potkategorija;
    private String opis;
    
    public Kategorija() {
    	
    }

	public String getNaziv_kategorije() {
		return naziv_kategorije;
	}

	public void setNaziv_kategorije(String naziv_kategorije) {
		this.naziv_kategorije = naziv_kategorije;
	}

	public String getPotkategorija() {
		return potkategorija;
	}

	public void setPotkategorija(String potkategorija) {
		this.potkategorija = potkategorija;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
}
