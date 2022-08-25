package fr.isika.cda17.project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	EntityAccount ea = new EntityAccount();
	ea.setName("EcoCar@test.com");
	ea.setPassword("123");

	em.persist(ea);
	
	Solution so = new Solution();
	so.setIsCarRentalSolutionIncluded(true);
	so.setIsCarPoolingsolutionIncluded(false);
	so.setMessagingSystemChoice(MessagingSystemChoice.NO_RESTRICTION_MESSAGING);
	so.setPaymentSystemChoice(PaymentSystemChoice.NONE);
	so.setIsRatingSystemIncluded(false);
	so.setPriceDeal(PriceDeal.REDUCED_PRICE);
	so.setIsPersonalAssistanceSolutionIncluded(true);
	so.setIsParcelSolutionIncluded(true);
	
	em.persist(so);
	
	Solution sa = new Solution();

	sa.setIsCarRentalSolutionIncluded(false);
	sa.setIsCarPoolingsolutionIncluded(true);
	sa.setMessagingSystemChoice(MessagingSystemChoice.SERVICE_RELATED_MESSAGING);
	sa.setPaymentSystemChoice(PaymentSystemChoice.MONETARY);
	sa.setIsRatingSystemIncluded(true);
	sa.setPriceDeal(PriceDeal.FULL_PRICE);
	sa.setIsPersonalAssistanceSolutionIncluded(false);
	sa.setIsParcelSolutionIncluded(true);
	
	em.persist(sa);
	
	Solution si = new Solution();

	si.setIsCarRentalSolutionIncluded(false);
	si.setIsCarPoolingsolutionIncluded(true);
	si.setMessagingSystemChoice(MessagingSystemChoice.NONE);
	si.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
	si.setIsRatingSystemIncluded(true);
	si.setPriceDeal(PriceDeal.FULL_PRICE);
	si.setIsPersonalAssistanceSolutionIncluded(true);
	si.setIsParcelSolutionIncluded(true);
	
	em.persist(si);
	
    }

}
