package ba.biblioteka.models;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Literatura.class)
public abstract class Literatura_ {

	public static volatile SingularAttribute<Literatura, String> mogucnost_preuzimanja;
	public static volatile SingularAttribute<Literatura, String> izdavac;
	public static volatile SingularAttribute<Literatura, String> komentar;
	public static volatile SingularAttribute<Literatura, Date> godina_izdavanja;
	public static volatile SingularAttribute<Literatura, Integer> broj_strana;
	public static volatile SingularAttribute<Literatura, Date> datum_unosa;
	public static volatile SingularAttribute<Literatura, Integer> id;
	public static volatile SingularAttribute<Literatura, Integer> autor_literature;
	public static volatile SingularAttribute<Literatura, String> naziv_literature;
	public static volatile SingularAttribute<Literatura, Kategorija> kategorija;

}

