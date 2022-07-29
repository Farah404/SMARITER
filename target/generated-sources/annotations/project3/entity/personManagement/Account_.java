package project3.entity.personManagement;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, String> password;
	public static volatile SingularAttribute<Account, AccountType> accountType;
	public static volatile SingularAttribute<Account, Long> id;
	public static volatile SingularAttribute<Account, Boolean> isActive;
	public static volatile SingularAttribute<Account, Date> creationDate;
	public static volatile SingularAttribute<Account, String> username;
	public static volatile SingularAttribute<Account, String> profilePicturePath;

}

