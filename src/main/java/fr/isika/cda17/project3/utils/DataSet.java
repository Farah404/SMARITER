package fr.isika.cda17.project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;

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
	
	EntityAccount eb = new EntityAccount();
	eb.setName("EcoCar2@test.com");
	eb.setPassword("1234");

	em.persist(eb);
	
	EntityAccount ec = new EntityAccount();
	ec.setName("EcoCar3@test.com");
	ec.setPassword("12365");

	em.persist(ec);
	
    }

}
