package fr.isika.cda17.project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.model.solutionManagement.MessagingSystemChoice;
import fr.isika.cda17.project3.model.solutionManagement.PaymentSystemChoice;
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
	
	AdministratorAccount e = new AdministratorAccount();
	e.setEmail("Eco@test.com");
	e.setPassword("123");

	em.persist(e);
	
	Solution so = new Solution();
	so.setCarPoolingsolutionIncluded(true);
    so.setCarPoolingsolutionIncluded(true);
    so.setCarRentalSolutionIncluded(false);
    so.setRatingSystemIncluded(true);
    so.setPaymentSystemChoice(PaymentSystemChoice.INTERNAL_CURRENCY);
    so.setMessagingSystemChoice(MessagingSystemChoice.NO_RESTRICTION_MESSAGING);
	em.persist(so);
    }

}

