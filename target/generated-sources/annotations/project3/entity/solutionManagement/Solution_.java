package project3.entity.solutionManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.financialManagement.ClientInvoice;
import project3.entity.personManagement.EntityAccount;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Solution.class)
public abstract class Solution_ {

	public static volatile SingularAttribute<Solution, ClientInvoice> clientInvoice;
	public static volatile SingularAttribute<Solution, Boolean> isParcelSolutionIncluded;
	public static volatile SingularAttribute<Solution, Boolean> isPrivate;
	public static volatile SingularAttribute<Solution, CarPoolingSolution> carPoolingSolution;
	public static volatile SingularAttribute<Solution, PriceDeal> priceDeal;
	public static volatile SingularAttribute<Solution, PaymentSystemChoice> paymentSystemChoice;
	public static volatile SingularAttribute<Solution, Boolean> isCarRentalSolutionIncluded;
	public static volatile ListAttribute<Solution, EntityAccount> entityAccounts;
	public static volatile SingularAttribute<Solution, ParcelSolution> parcelSolution;
	public static volatile SingularAttribute<Solution, Boolean> isCarPoolingsolutionIncluded;
	public static volatile SingularAttribute<Solution, MessagingSystemChoice> messagingSystemChoice;
	public static volatile SingularAttribute<Solution, Long> id;
	public static volatile SingularAttribute<Solution, Boolean> isPersonalAssistanceSolutionIncluded;
	public static volatile SingularAttribute<Solution, Boolean> isRatingSystemIncluded;

}

