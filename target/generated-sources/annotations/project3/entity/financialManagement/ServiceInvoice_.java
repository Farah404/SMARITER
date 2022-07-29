package project3.entity.financialManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.personManagement.UserAccount;
import project3.entity.solutionManagement.Service;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ServiceInvoice.class)
public abstract class ServiceInvoice_ {

	public static volatile SingularAttribute<ServiceInvoice, Service> service;
	public static volatile SingularAttribute<ServiceInvoice, UserAccount> userAccount;
	public static volatile SingularAttribute<ServiceInvoice, Long> id;

}

