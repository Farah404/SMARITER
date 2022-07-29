package project3.entity.financialManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BankDetails.class)
public abstract class BankDetails_ {

	public static volatile SingularAttribute<BankDetails, String> iban;
	public static volatile SingularAttribute<BankDetails, String> bankName;
	public static volatile SingularAttribute<BankDetails, Long> id;
	public static volatile SingularAttribute<BankDetails, String> swift;

}

