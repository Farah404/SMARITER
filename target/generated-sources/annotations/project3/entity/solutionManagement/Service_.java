package project3.entity.solutionManagement;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.personManagement.UserAccount;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Service.class)
public abstract class Service_ {

	public static volatile SingularAttribute<Service, ServiceType> servicetype;
	public static volatile SingularAttribute<Service, Date> endDate;
	public static volatile SingularAttribute<Service, Integer> referenceNumber;
	public static volatile SingularAttribute<Service, Boolean> isRequest;
	public static volatile SingularAttribute<Service, Double> price;
	public static volatile ListAttribute<Service, UserAccount> userAccounts;
	public static volatile SingularAttribute<Service, Long> id;
	public static volatile SingularAttribute<Service, Date> publicationDate;
	public static volatile SingularAttribute<Service, Date> startDate;
	public static volatile SingularAttribute<Service, Date> expirationDate;

}

