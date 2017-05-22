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
	private Integer id; 
	 
	private Date datum_povratka;
	private Date datum_iznajmljivanja;
	
	@ManyToOne(targetEntity=ClanBiblioteke.class)
	@JoinColumn(name="unajmio_clan")
	private ClanBiblioteke unajmio_clan;
	
	@ManyToOne(targetEntity=Literatura.class)
	@JoinColumn(name="id_literature")
	private Literatura literatura;
		
	@ManyToOne(targetEntity=Moderator.class)
	@JoinColumn(name="iznajmio_moderator")
	private Moderator moderator;
	
	@ManyToOne(targetEntity=Administrator.class)
	@JoinColumn(name="iznajmio_administrator")
	private Administrator administrator;
	
	public Iznajmljeno() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatum_povratka() {
		return datum_povratka;
	}

	public void setDatum_povratka(Date datum_povratka) {
		this.datum_povratka = datum_povratka;
	}

	public Date getDatum_iznajmljivanja() {
		return datum_iznajmljivanja;
	}

	public void setDatum_iznajmljivanja(Date datum_iznajmljivanja) {
		this.datum_iznajmljivanja = datum_iznajmljivanja;
	}

	public ClanBiblioteke getUnajmio_clan() {
		return unajmio_clan;
	}

	public void setUnajmio_clan(ClanBiblioteke unajmio_clan) {
		this.unajmio_clan = unajmio_clan;
	}

	public Literatura getLiteratura() {
		return literatura;
	}

	public void setLiteratura(Literatura literatura) {
		this.literatura = literatura;
	}

	public Moderator getModerator() {
		return moderator;
	}

	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
}