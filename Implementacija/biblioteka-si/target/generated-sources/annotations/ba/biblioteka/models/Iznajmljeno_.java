package ba.biblioteka.models;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Iznajmljeno.class)
public abstract class Iznajmljeno_ {

	public static volatile SingularAttribute<Iznajmljeno, Administrator> administrator;
	public static volatile SingularAttribute<Iznajmljeno, ClanBiblioteke> unajmio_clan;
	public static volatile SingularAttribute<Iznajmljeno, Moderator> moderator;
	public static volatile SingularAttribute<Iznajmljeno, Date> datum_povratka;
	public static volatile SingularAttribute<Iznajmljeno, Integer> id;
	public static volatile SingularAttribute<Iznajmljeno, Date> datum_iznajmljivanja;
	public static volatile SingularAttribute<Iznajmljeno, Literatura> literatura;

}

