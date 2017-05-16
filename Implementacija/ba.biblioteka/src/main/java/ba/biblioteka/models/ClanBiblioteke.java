package ba.biblioteka.models;

import java.io.Serializable;
import java.sql.Date;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clanbiblioteke")

public class ClanBiblioteke implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer brojClanskeKarte; 
    
    private Date DatumRodjenja;
    private String Adresa;
    private String MjestoStanovanja;
    private BigDecimal BrojTelefona;
    private String Ustanova;
    private String Email;
    private String idOsobe;
    
    
	public Date getDatumRodjenja() {
		return DatumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		DatumRodjenja = datumRodjenja;
	}
	public String getAdresa() {
		return Adresa;
	}
	public void setAdresa(String adresa) {
		Adresa = adresa;
	}
	public String getMjestoStanovanja() {
		return MjestoStanovanja;
	}
	public void setMjestoStanovanja(String mjestoStanovanja) {
		MjestoStanovanja = mjestoStanovanja;
	}
	public BigDecimal getBrojTelefona() {
		return BrojTelefona;
	}
	public void setBrojTelefona(BigDecimal brojTelefona) {
		BrojTelefona = brojTelefona;
	}
	public String getUstanova() {
		return Ustanova;
	}
	public void setUstanova(String ustanova) {
		Ustanova = ustanova;
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
}
