package ba.biblioteka.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="kategorija")


public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    private String Kategorija;
    
    private String NazivKategorije;
    private String Potkategorija;
    private String Opis;
    
    
     
    public Kategorija() {
    	
    }

    public String getNazivKategorije() {
		return NazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		NazivKategorije = nazivKategorije;
	}





	public String getPotkategorija() {
		return Potkategorija;
	}





	public void setPotkategorija(String potkategorija) {
		Potkategorija = potkategorija;
	}





	public String getOpis() {
		return Opis;
	}





	public void setOpis(String opis) {
		Opis = opis;
	}

}
