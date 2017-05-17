package ba.biblioteka.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="arhiv")


public class Arhiv implements Serializable {
	private static final long serialVersionUID = 1L;
	  
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer ID; 
	
	private Integer UkupanBroj;
	private Integer BrojIznajmljenih;
	private Literatura literatura;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLiterature")
    public Literatura getLiteratural() {
        return literatura;
    }

    public void setLiteratura(Literatura literatura) {
        this.literatura = literatura;
    }
	
	
    public Arhiv() {
    	
    }

	public Integer getUkupanBroj() {
		return UkupanBroj;
	}

	public void setUkupanBroj(Integer ukupanBroj) {
		UkupanBroj = ukupanBroj;
	}

	public Integer getBrojIznajmljenih() {
		return BrojIznajmljenih;
	}

	public void setBrojIznajmljenih(Integer brojIznajmljenih) {
		BrojIznajmljenih = brojIznajmljenih;
	}

	
    
}
