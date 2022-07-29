package project3.entity.personManagement;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends project3.entity.personManagement.Person_ {

	public static volatile SingularAttribute<User, Integer> phoneNumber;
	public static volatile SingularAttribute<User, Integer> identityCardnumber;
	public static volatile SingularAttribute<User, Integer> drivingPermitNumber;
	public static volatile SingularAttribute<User, Date> birthDate;
	public static volatile SingularAttribute<User, String> email;

}

