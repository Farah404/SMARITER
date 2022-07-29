package project3.entity.financialManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.personManagement.UserAccount;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StoreInvoice.class)
public abstract class StoreInvoice_ {

	public static volatile SingularAttribute<StoreInvoice, UserAccount> userAccount;
	public static volatile SingularAttribute<StoreInvoice, Long> id;
	public static volatile SingularAttribute<StoreInvoice, Store> store;
	public static volatile SingularAttribute<StoreInvoice, PurchaseType> purchaseType;

}

