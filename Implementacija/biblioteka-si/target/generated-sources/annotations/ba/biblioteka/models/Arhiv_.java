package ba.biblioteka.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Arhiv.class)
public abstract class Arhiv_ {

	public static volatile SingularAttribute<Arhiv, Integer> ukupan_broj;
	public static volatile SingularAttribute<Arhiv, Integer> id;
	public static volatile SingularAttribute<Arhiv, Literatura> literatura;
	public static volatile SingularAttribute<Arhiv, Integer> broj_iznajmljenih;

}

