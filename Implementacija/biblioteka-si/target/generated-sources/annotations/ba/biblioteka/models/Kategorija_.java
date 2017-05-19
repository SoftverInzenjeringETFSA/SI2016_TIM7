package ba.biblioteka.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Kategorija.class)
public abstract class Kategorija_ {

	public static volatile SingularAttribute<Kategorija, String> id;
	public static volatile SingularAttribute<Kategorija, String> naziv_kategorije;
	public static volatile SingularAttribute<Kategorija, String> potkategorija;
	public static volatile SingularAttribute<Kategorija, String> opis;

}

