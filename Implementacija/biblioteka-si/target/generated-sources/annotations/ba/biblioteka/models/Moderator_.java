package ba.biblioteka.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Moderator.class)
public abstract class Moderator_ {

	public static volatile SingularAttribute<Moderator, Integer> sigurnosni_id;
	public static volatile SingularAttribute<Moderator, String> adresa;
	public static volatile SingularAttribute<Moderator, Osoba> osoba;
	public static volatile SingularAttribute<Moderator, Integer> id;
	public static volatile SingularAttribute<Moderator, String> grad;
	public static volatile SingularAttribute<Moderator, String> email;

}

