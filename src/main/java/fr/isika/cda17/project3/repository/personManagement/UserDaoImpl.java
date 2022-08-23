package fr.isika.cda17.project3.repository.personManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.isika.cda17.project3.model.personManagement.User;

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
	    User updatedUser = entityManager.find(User.class, user.getId());
	    updatedUser.setFirstName(user.getFirstName());
	    updatedUser.setLastName(user.getLastName());
	    updatedUser.setEmail(user.getEmail());
	    updatedUser.setPhoneNumber(user.getPhoneNumber());
	    updatedUser.setBirthDate(user.getBirthDate());
	    updatedUser.setIdentityCardnumber(user.getDrivingPermitNumber());
	    updatedUser.setDrivingPermitNumber(user.getDrivingPermitNumber());
	    
	    entityManager.persist(updatedUser);
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
	// TODO Auto-generated method stub
	return null;
    }

}