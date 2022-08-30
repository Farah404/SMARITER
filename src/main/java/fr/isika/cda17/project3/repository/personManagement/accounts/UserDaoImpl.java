package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Stateless
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public User create(User user) {
	try {
		
	    entityManager.persist(user);
	    return user;
	} catch (Exception e) {
	    System.out.println("UserDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(User user) {
	try {
	    User updatedUser = this.entityManager.find(User.class, user.getId());
	    updatedUser.setFirstName(user.getFirstName());
	    updatedUser.setLastName(user.getLastName());
	    updatedUser.setPhoneNumber(user.getPhoneNumber());
	    updatedUser.setBirthDate(user.getBirthDate());
	    updatedUser.setIdentityCardnumber(user.getIdentityCardnumber());
	    updatedUser.setDrivingPermitNumber(user.getDrivingPermitNumber());
	    updatedUser.setUserAccount(user.getUserAccount());
	    entityManager.merge(updatedUser);
	} catch (Exception e) {
	    System.out.println("UserDao.update() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public void delete(Long id) {
	try {
	    User deletedUser = entityManager.find(User.class, id);
	    entityManager.remove(deletedUser);
	} catch (Exception e) {
	    System.out.println("UserDao.delete() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public User findById(Long id) {
	return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
    	
    	List<User> u =  this.entityManager.createQuery("select ea from User ea", User.class).getResultList();
    	 System.out.println( u);
    	 return u;
	
    }

    @Override
    public User findByUserAccountId(Long id) {
	try {
		User user = this.entityManager
				.createNamedQuery("user.findByUserAccountId", User.class)
				.setParameter("u_param", id)
				.getSingleResult();
		return user;
	} catch (NoResultException ex) {
		System.out.println("UserDaoImpl.findByUserAccountId() - not found : " + id);
	}
	return null;
}
}
