package ba.biblioteka.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="arhiv")

public class Arhiv implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id; 
	
	private Integer ukupan_broj;
	private Integer broj_iznajmljenih;
	
	@ManyToOne(targetEntity=Literatura.class)
    @JoinColumn(name = "id_literature")
	private Literatura literatura;
	
	public Arhiv() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUkupan_broj() {
		return ukupan_broj;
	}

	public void setUkupan_broj(Integer ukupan_broj) {
		this.ukupan_broj = ukupan_broj;
	}

	public Integer getBroj_iznajmljenih() {
		return broj_iznajmljenih;
	}

	public void setBroj_iznajmljenih(Integer broj_iznajmljenih) {
		this.broj_iznajmljenih = broj_iznajmljenih;
	}

	public Literatura getLiteratura() {
		return literatura;
	}

	public void setLiteratura(Literatura literatura) {
		this.literatura = literatura;
	}
}
