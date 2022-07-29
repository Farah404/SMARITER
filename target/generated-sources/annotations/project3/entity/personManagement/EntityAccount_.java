package project3.entity.personManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.financialManagement.BankDetails;
import project3.entity.financialManagement.BillingAddress;
import project3.entity.financialManagement.ShoppingCart;
import project3.entity.financialManagement.Wallet;
import project3.entity.solutionManagement.Solution;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EntityAccount.class)
public abstract class EntityAccount_ extends project3.entity.personManagement.Account_ {

	public static volatile SingularAttribute<EntityAccount, BankDetails> bankDetails;
	public static volatile SingularAttribute<EntityAccount, Wallet> wallet;
	public static volatile ListAttribute<EntityAccount, Solution> solutions;
	public static volatile SingularAttribute<EntityAccount, String> name;
	public static volatile SingularAttribute<EntityAccount, Integer> siretNumber;
	public static volatile SingularAttribute<EntityAccount, ShoppingCart> shoppingCart;
	public static volatile SingularAttribute<EntityAccount, Boolean> isPrivate;
	public static volatile SingularAttribute<EntityAccount, BillingAddress> billingAddress;

}

