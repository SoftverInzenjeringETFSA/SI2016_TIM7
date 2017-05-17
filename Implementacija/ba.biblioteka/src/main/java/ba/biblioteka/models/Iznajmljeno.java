package ba.biblioteka.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String IznajmioModerator;
	private String IznajmioAdministrator;
	
	
	
	 @ManyToOne(targetEntity=ClanBiblioteke.class)
	    @JoinColumn(name="Broj clanske karte")
	    private ClanBiblioteke clan;
	    
	    public ClanBiblioteke getClanBiblioteke(){
	    	return clan;
	    }
	    
		public void setClanBiblioteke(ClanBiblioteke clan) {
			this.clan = clan;
		}
		
		

	 @ManyToOne(targetEntity=Literatura.class)
		@JoinColumn(name="idLiterature")
		private Literatura literatura;
		    
		public Literatura getLiteratura(){
		    return literatura;
		}
		    
		public void setLiteratura(Literatura literatura) {
			this.literatura = literatura;
		}	
	
	
	
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