package ba.biblioteka.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="osoba")

public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idOsobe; 
    
    private String KorisnickoIme;
    private String Ime;
    private String Prezime;
    private String Sifra;
   
    
    public Osoba() {
    	
    }
    
	public String getKorisnickoIme() {
		return this.KorisnickoIme;
	}
	public void setKorisnickoIme(String username) {
		this.KorisnickoIme = username;
	}
	
	public String getSifra() {
		return Sifra;
	}
	public void setSifra(String password) {
		this.Sifra = password;
	}
	
	public String getIme() {
		return this.Ime;
	}
	public void setIme(String ime) {
		this.Ime = ime;
	}

	public String getPrezime() {
		return this.Prezime;
	}
	public void setPrezime(String prezime) {
		this.Prezime = prezime;
	}

	
	@Override
    public String toString() {
        return String.format("Osoba[idOsobe=%d, Korisnicko ime='%s', Sifra='%s']", idOsobe, KorisnickoIme, Sifra);
    }
}

