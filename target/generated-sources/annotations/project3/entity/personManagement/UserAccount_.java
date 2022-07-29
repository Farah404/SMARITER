package project3.entity.personManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.financialManagement.BankDetails;
import project3.entity.financialManagement.BillingAddress;
import project3.entity.financialManagement.ShoppingCart;
import project3.entity.financialManagement.Wallet;
import project3.entity.solutionManagement.Reservation;
import project3.entity.solutionManagement.Service;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserAccount.class)
public abstract class UserAccount_ extends project3.entity.personManagement.Account_ {

	public static volatile SingularAttribute<UserAccount, BankDetails> bankDetails;
	public static volatile SingularAttribute<UserAccount, Wallet> wallet;
	public static volatile ListAttribute<UserAccount, Reservation> reservations;
	public static volatile SingularAttribute<UserAccount, ShoppingCart> shoppingCart;
	public static volatile SingularAttribute<UserAccount, BillingAddress> billingAddress;
	public static volatile ListAttribute<UserAccount, Service> services;

}

