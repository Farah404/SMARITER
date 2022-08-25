package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Account;

@Stateless
public class AccountDaoImpl implements AccountDao {
	@PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account create(Account account) {
	try {
	          entityManager.persist(account);
	            return account;
	        } catch (Exception e) {
	            System.out.println("AccountDao.create() - Failed : " + e.getMessage());
	            return null;
	        }
    }

    @Override
    public void update(Account account) {
	 try {
	     Account updatedAccount = entityManager.find(Account.class, account.getId());
	     updatedAccount.setUsername(account.getUsername());
	     updatedAccount.setEmail(account.getEmail());
	     updatedAccount.setPassword(account.getPassword());
	     updatedAccount.setProfilePicturePath(account.getProfilePicturePath());
	     updatedAccount.setIsActive(account.getIsActive());
	     updatedAccount.setCreationDate(account.getCreationDate());
	          entityManager.merge(updatedAccount);
	        } catch (Exception e) {
	            System.out.println("AccountDao.update() - Failed : " + e.getMessage());
	        }
	
    }

    @Override
    public void delete(Long id) {
	 try {
	     Account deletedAccount = this.entityManager.find(Account.class, id);
	            this.entityManager.remove(deletedAccount);
	        } catch (Exception e) {
	            System.out.println("AccountDao.delete() - Failed : " + e.getMessage());
	        }
    }

    @Override
    public Account findById(Long id) {
	return this.entityManager.find(Account.class, id);
	    
    }

    @Override
    public List<Account> findAll() {
	return this.entityManager.createQuery("select a from account ea", Account.class).getResultList();
	    
    }

    @Override
    public Optional<Account> findByEmail(String email) {
	try {
	    Account account = this.entityManager
				.createNamedQuery("Account.findByEmail", Account.class)
				.setParameter("name_param", email)
				.getSingleResult();
		return Optional.ofNullable(account);
	} catch (NoResultException ex) {
		System.out.println("AccountDao.findByEmail() - not found : " + email);
	}
	return Optional.empty();
}
}
