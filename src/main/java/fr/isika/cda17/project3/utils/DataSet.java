package fr.isika.cda17.project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;
import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
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
	eb.setName("EcoCar");
	eb.setPassword("1234");
	eb.setAccountType(AccountType.ENTITY);
	eb.setEmail("ecocar@text.com");


	
	Solution sosix = new Solution();
	so.setCarPoolingsolutionIncluded(true);
    so.setCarPoolingsolutionIncluded(true);
    so.setCarRentalSolutionIncluded(false);
    so.setRatingSystemIncluded(true);
    so.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
    so.setMessagingSystemChoice(MessagingSystemChoice.NO_RESTRICTION_MESSAGING);
	em.persist(sosix);
    }

}