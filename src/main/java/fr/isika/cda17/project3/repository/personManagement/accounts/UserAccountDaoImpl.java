package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Stateless
public class UserAccountDaoImpl implements UserAccountsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserAccount create(UserAccount userAccount) {
	try {
	    entityManager.persist(userAccount);
	    return userAccount;
	} catch (Exception e) {
	    System.out.println("AdministratorDaoImpl.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(UserAccount userAccount) {
	try {
	    UserAccount updatedUserAccount = entityManager.find(UserAccount.class, userAccount.getId());
	    updatedUserAccount.setUsername(userAccount.getUsername());
	    updatedUserAccount.setEmail(userAccount.getEmail());
	    entityManager.persist(updatedUserAccount);
	} catch (Exception e) {
	    System.out.println("AdministratorDao.update() - Failed : " + e.getMessage());
	}
    }

    @Override
    public void delete(Long id) {
	try {
	    UserAccount deletedUserAccount = entityManager.find(UserAccount.class, id);
	    entityManager.remove(deletedUserAccount);
	} catch (Exception e) {
	    System.out.println("AdministratorDao.update() - Failed : " + e.getMessage());
	}
    }

    @Override
    public UserAccount findById(Long id) {
	return entityManager.find(UserAccount.class, id);
    }

    @Override
    public List<UserAccount> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
	try {
	    UserAccount userAccount = this.entityManager.createNamedQuery("UserAccount.findByEmail", UserAccount.class)
		    .setParameter("email_param", email).getSingleResult();
	    return Optional.ofNullable(userAccount);
	} catch (NoResultException ex) {
	    System.out.println("userAccountDaoImpl.findByEmail() - not found : " + email);
	}
	return Optional.empty();
    }
}
