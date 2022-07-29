package project3.entity.financialManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BillingAddress.class)
public abstract class BillingAddress_ {

	public static volatile SingularAttribute<BillingAddress, String> country;
	public static volatile SingularAttribute<BillingAddress, String> city;
	public static volatile SingularAttribute<BillingAddress, Integer> postalCode;
	public static volatile SingularAttribute<BillingAddress, Long> id;
	public static volatile SingularAttribute<BillingAddress, String> addressLine;
	public static volatile SingularAttribute<BillingAddress, String> region;

}

