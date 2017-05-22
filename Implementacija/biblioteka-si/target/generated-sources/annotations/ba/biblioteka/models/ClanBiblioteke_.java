package ba.biblioteka.models;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClanBiblioteke.class)
public abstract class ClanBiblioteke_ {

	public static volatile SingularAttribute<ClanBiblioteke, String> ustanova;
	public static volatile SingularAttribute<ClanBiblioteke, String> broj_clanske_karte;
	public static volatile SingularAttribute<ClanBiblioteke, String> mjesto_stanovanja;
	public static volatile SingularAttribute<ClanBiblioteke, String> adresa;
	public static volatile SingularAttribute<ClanBiblioteke, Osoba> osoba;
	public static volatile SingularAttribute<ClanBiblioteke, Date> datum_rodjenja;
	public static volatile SingularAttribute<ClanBiblioteke, Integer> id;
	public static volatile SingularAttribute<ClanBiblioteke, String> broj_telefona;
	public static volatile SingularAttribute<ClanBiblioteke, String> email;

}

