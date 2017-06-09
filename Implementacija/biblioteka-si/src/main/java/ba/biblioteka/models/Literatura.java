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
@Table(name="literatura")

public class Literatura implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 
    
    private String autor_literature;
    private String naziv_literature;
    private String izdavac;
    private Integer godina_izdavanja;
    private Integer broj_strana;
    private String komentar;
    private Integer mogucnost_preuzimanja;
    private Date datum_unosa;
    
    private Date datum_iznajmljivanja;
    private Date datum_povratka;
    
    @ManyToOne(targetEntity=Kategorija.class)
    @JoinColumn(name="kategorija")
    private Kategorija kategorija;
    
    @ManyToOne(targetEntity=ClanBiblioteke.class)
    @JoinColumn(name="unajmio_clan")
    private ClanBiblioteke clan;
    
    @ManyToOne(targetEntity=Administrator.class)
    @JoinColumn(name="iznajmio_administrator")
    private Administrator administrator;
    
    @ManyToOne(targetEntity=Moderator.class)
    @JoinColumn(name="iznajmio_moderator")
    private Moderator moderator;
    

    public Literatura() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutor_literature() {
		return autor_literature;
	}

	public void setAutor_literature(String autor_literature) {
		this.autor_literature = autor_literature;
	}

	public String getNaziv_literature() {
		return naziv_literature;
	}

	public void setNaziv_literature(String naziv_literature) {
		this.naziv_literature = naziv_literature;
	}

	public String getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}

	public Integer getGodina_izdavanja() {
		return godina_izdavanja;
	}

	public void setGodina_izdavanja(Integer godina_izdavanja) {
		this.godina_izdavanja = godina_izdavanja;
	}

	public Integer getBroj_strana() {
		return broj_strana;
	}

	public void setBroj_strana(Integer broj_strana) {
		this.broj_strana = broj_strana;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public Integer getMogucnost_preuzimanja() {
		return mogucnost_preuzimanja;
	}

	public void setMogucnost_preuzimanja(Integer mogucnost_preuzimanja) {
		this.mogucnost_preuzimanja = mogucnost_preuzimanja;
	}

	public Date getDatum_unosa() {
		return datum_unosa;
	}

	public void setDatum_unosa(Date datum_unosa) {
		this.datum_unosa = datum_unosa;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	
	public ClanBiblioteke getClanBiblioteke() {
		return clan;
	}

	public void setClanBiblioteke(ClanBiblioteke clan) {
		this.clan = clan;
	}
	
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
	public Moderator getModerator () {
		return moderator ;
	}

	public void setModerator (Moderator moderator) {
		this.moderator = moderator;
	}

	public Date getDatum_iznajmljivanja() {
		return datum_iznajmljivanja;
	}

	public void setDatum_iznajmljivanja(Date datum_iznajmljivanja) {
		this.datum_iznajmljivanja = datum_iznajmljivanja;
	}

	public Date getDatum_povratka() {
		return datum_povratka;
	}

	public void setDatum_povratka(Date datum_povratka) {
		this.datum_povratka = datum_povratka;
	}
	
	
}
