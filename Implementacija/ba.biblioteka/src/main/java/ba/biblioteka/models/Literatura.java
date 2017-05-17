package ba.biblioteka.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="literatura")


public class Literatura implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idLiterature; 
    
    private Integer AutorLiterature;
    private String NazivLiterature;
    private String Izdavac;
    private Date GodinaIzdavanja;
  
    private Integer BrojStrana;
    private String Komentar;
    private String MogucnostPreuzimanja;
    private Date DatumUnosa;
    
    private Arhiv arhiv;
    
    
    @ManyToOne(targetEntity=Kategorija.class)
    @JoinColumn(name="Kategorija")
    private Kategorija kategorija;


    public Literatura() {
    	
    }

	public Integer getAutorLiterature() {
		return AutorLiterature;
	}

	public void setAutorLiterature(Integer autorLiterature) {
		AutorLiterature = autorLiterature;
	}

	public String getNazivLiterature() {
		return NazivLiterature;
	}

	public void setNazivLiterature(String nazivLiterature) {
		NazivLiterature = nazivLiterature;
	}

	public String getIzdavac() {
		return Izdavac;
	}

	public void setIzdavac(String izdavac) {
		Izdavac = izdavac;
	}

	public Date getGodinaIzdavanja() {
		return GodinaIzdavanja;
	}

	public void setGodinaIzdavanja(Date godinaIzdavanja) {
		GodinaIzdavanja = godinaIzdavanja;
	}

	public Integer getBrojStrana() {
		return BrojStrana;
	}

	public void setBrojStrana(Integer brojStrana) {
		BrojStrana = brojStrana;
	}

	public String getKomentar() {
		return Komentar;
	}

	public void setKomentar(String komentar) {
		Komentar = komentar;
	}

	public String getMogucnostPreuzimanja() {
		return MogucnostPreuzimanja;
	}

	public void setMogucnostPreuzimanja(String mogucnostPreuzimanja) {
		MogucnostPreuzimanja = mogucnostPreuzimanja;
	}

	public Date getDatumUnosa() {
		return DatumUnosa;
	}

	public void setDatumUnosa(Date datumUnosa) {
		DatumUnosa = datumUnosa;
	}

	
	 public Kategorija getKategorija(){
	    	return kategorija;
	 }
	    
	public void setFakultet(Kategorija kategorija) {
			this.kategorija = kategorija;
	}
    
	
	 @OneToOne(mappedBy = "literatura")
	    public Arhiv getArhiv() {
	        return arhiv;
	    }

	    public void setArhiv(Arhiv arhiv) {
	        this.arhiv = arhiv;
	    }

}
