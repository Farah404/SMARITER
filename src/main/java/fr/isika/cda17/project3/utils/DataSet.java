package fr.isika.cda17.project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Account;
import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.solutionManagement.MessagingSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PaymentSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PriceDeal;
import fr.isika.cda17.project3.model.solutionManagement.Solution;

@Singleton
@Startup
public class DataSet {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void initData() {

	EntityAccount ea = new EntityAccount();
	ea.setEmail("EcoCar@test.com");
	ea.setPassword("123");

	em.persist(ea);
	
	Solution so = new Solution();
	so.setCarRentalSolutionIncluded(true);
	so.setCarPoolingsolutionIncluded(false);
	so.setMessagingSystemChoice(MessagingSystemChoice.NO_RESTRICTION_MESSAGING);
	so.setPaymentSystemChoice(PaymentSystemChoice.NONE);
	so.setRatingSystemIncluded(false);
	so.setPriceDeal(PriceDeal.BUSINESS_BASIC);
	so.setPersonalAssistanceSolutionIncluded(true);
	so.setParcelSolutionIncluded(true);
	
	em.persist(so);
	
	Solution sa = new Solution();

	sa.setCarRentalSolutionIncluded(false);
	sa.setCarPoolingsolutionIncluded(true);
	sa.setMessagingSystemChoice(MessagingSystemChoice.SERVICE_RELATED_MESSAGING);
	sa.setPaymentSystemChoice(PaymentSystemChoice.MONETARY);
	sa.setRatingSystemIncluded(true);
	sa.setPriceDeal(PriceDeal.BUSINESS_VIP);
	sa.setPersonalAssistanceSolutionIncluded(false);
	sa.setParcelSolutionIncluded(true);
	
	em.persist(sa);
	
	Solution si = new Solution();

	si.setCarRentalSolutionIncluded(false);
	si.setCarPoolingsolutionIncluded(true);
	si.setMessagingSystemChoice(MessagingSystemChoice.NONE);
	si.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
	si.setRatingSystemIncluded(true);
	si.setPriceDeal(PriceDeal.BUSINESS_UNLIMITED);
	si.setPersonalAssistanceSolutionIncluded(true);
	si.setParcelSolutionIncluded(true);
	
	em.persist(si);
  
	EntityAccount eb = new EntityAccount();
	eb.setName("EcoCar2@test.com");
	eb.setPassword("1234");

	AdministratorAccount e = new AdministratorAccount();
	e.setEmail("Eco@test.com");
	e.setPassword("123");

	em.persist(e);
	
//	Solution sosix = new Solution();
//	so.setCarPoolingsolutionIncluded(true);
//    so.setCarPoolingsolutionIncluded(true);
//    so.setCarRentalSolutionIncluded(false);
//    so.setRatingSystemIncluded(true);
//    so.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
//    so.setMessagingSystemChoice(MessagingSystemChoice.NO_RESTRICTION_MESSAGING);
//	em.persist(sosix);
	
	
	User u = new User();
	u.setFirstName("houda");
	u.setLastName("madi");
	u.setPhoneNumber(06666666);
	u.setDrivingPermitNumber(123586);
	em.persist(u);
	
    }
    
    
    

}