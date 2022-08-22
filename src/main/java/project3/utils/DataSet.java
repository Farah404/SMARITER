package project3.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import project3.entity.personManagement.User;

@Singleton
@Startup
public class DataSet {

	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	private void initData() {
		
		User u = new User();
		u.setEmail("test@test.com");
		
		em.persist(u);
	}
	
}
