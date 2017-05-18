package ba.biblioteka.models;

import java.io.Serializable;
import java.sql.Date;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="clanbiblioteke")

public class ClanBiblioteke implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String broj_clanske_karte; 
    private Date datum_rodjenja;
    private String adresa;
    private String mjesto_stanovanja;
    private String broj_telefona;
    private String ustanova;
    private String email;
    
    @ManyToOne(targetEntity=Osoba.class)
    @JoinColumn(name="id_osobe")
    private Osoba osoba;
    
    public ClanBiblioteke() {
    	
    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBroj_clanske_karte() {
		return broj_clanske_karte;
	}

	public void setBroj_clanske_karte(String broj_clanske_karte) {
		this.broj_clanske_karte = broj_clanske_karte;
	}

	public Date getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMjesto_stanovanja() {
		return mjesto_stanovanja;
	}

	public void setMjesto_stanovanja(String mjesto_stanovanja) {
		this.mjesto_stanovanja = mjesto_stanovanja;
	}

	public String getBroj_telefona() {
		return broj_telefona;
	}

	public void setBroj_telefona(String broj_telefona) {
		this.broj_telefona = broj_telefona;
	}

	public String getUstanova() {
		return ustanova;
	}

	public void setUstanova(String ustanova) {
		this.ustanova = ustanova;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
}
