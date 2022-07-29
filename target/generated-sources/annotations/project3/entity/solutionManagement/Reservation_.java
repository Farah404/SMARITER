package project3.entity.solutionManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.financialManagement.ServiceInvoice;
import project3.entity.personManagement.UserAccount;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reservation.class)
public abstract class Reservation_ {

	public static volatile SingularAttribute<Reservation, ServiceInvoice> serviceinvoice;
	public static volatile SingularAttribute<Reservation, Service> service;
	public static volatile ListAttribute<Reservation, UserAccount> Useraccounts;
	public static volatile SingularAttribute<Reservation, Long> id;

}

