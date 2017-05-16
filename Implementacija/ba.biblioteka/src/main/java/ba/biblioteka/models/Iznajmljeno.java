package ba.biblioteka.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="iznajmljeno")

public class Iznajmljeno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer ID; 
	 
	private String NazivLiterature;
	private Date DatumPovratka;
	private Date DatumIznajmljivanja;
	private String AutorLiterature;
	private Integer BrojClanskeKarte;
	private Integer idLiterature;
	private String IznajmioModerator;
	private String IznajmioAdministrator;
	public String getNazivLiterature() {
		return NazivLiterature;
	}
	public void setNazivLiterature(String nazivLiterature) {
		NazivLiterature = nazivLiterature;
	}
	public Date getDatumPovratka() {
		return DatumPovratka;
	}
	public void setDatumPovratka(Date datumPovratka) {
		DatumPovratka = datumPovratka;
	}
	public Date getDatumIznajmljivanja() {
		return DatumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(Date datumIznajmljivanja) {
		DatumIznajmljivanja = datumIznajmljivanja;
	}
	public String getAutorLiterature() {
		return AutorLiterature;
	}
	public void setAutorLiterature(String autorLiterature) {
		AutorLiterature = autorLiterature;
	}
	public Integer getBrojClanskeKarte() {
		return BrojClanskeKarte;
	}
	public void setBrojClanskeKarte(Integer brojClanskeKarte) {
		BrojClanskeKarte = brojClanskeKarte;
	}
	public Integer getIdLiterature() {
		return idLiterature;
	}
	public void setIdLiterature(Integer idLiterature) {
		this.idLiterature = idLiterature;
	}
	public String getIznajmioModerator() {
		return IznajmioModerator;
	}
	public void setIznajmioModerator(String iznajmioModerator) {
		IznajmioModerator = iznajmioModerator;
	}
	public String getIznajmioAdministrator() {
		return IznajmioAdministrator;
	}
	public void setIznajmioAdministrator(String iznajmioAdministrator) {
		IznajmioAdministrator = iznajmioAdministrator;
	}
	
}