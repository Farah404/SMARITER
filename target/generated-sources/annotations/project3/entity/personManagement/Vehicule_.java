package project3.entity.personManagement;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Vehicule.class)
public abstract class Vehicule_ {

	public static volatile SingularAttribute<Vehicule, Insurance> insurance;
	public static volatile SingularAttribute<Vehicule, Boolean> isElectric;
	public static volatile SingularAttribute<Vehicule, String> registrationNumber;
	public static volatile SingularAttribute<Vehicule, Boolean> isManual;
	public static volatile SingularAttribute<Vehicule, UserAccount> userAccount;
	public static volatile SingularAttribute<Vehicule, Boolean> isHybrid;
	public static volatile SingularAttribute<Vehicule, Long> id;
	public static volatile SingularAttribute<Vehicule, String> brand;
	public static volatile SingularAttribute<Vehicule, Date> technicalTestExpiration;

}

