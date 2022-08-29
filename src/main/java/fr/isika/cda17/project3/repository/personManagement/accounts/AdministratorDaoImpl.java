package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Administrator;
import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.Customer;

@Stateless
public class AdministratorDaoImpl implements AdministratorDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Administrator create(Administrator administrator) {
	try {
	    entityManager.persist(administrator);
	    return administrator;
	} catch (Exception e) {
	    System.out.println("AdministratorDaoImpl.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Administrator administrator) {
	try {
	    Administrator updatedAdministrator = entityManager.find(Administrator.class, administrator.getId());
	    updatedAdministrator.setFirstName(administrator.getFirstName());
	    updatedAdministrator.setLastName(administrator.getLastName());
	    updatedAdministrator.setEmployeeCode(administrator.getEmployeeCode());
	    
	    entityManager.persist(updatedAdministrator);
	} catch (Exception e) {
	    System.out.println("AdministratorDao.update() - Failed : " + e.getMessage());
	}
    }

    @Override
    public void delete(Long id) {
	try {
	    Administrator deletedAdministrator = entityManager.find(Administrator.class, id);
	    entityManager.remove(deletedAdministrator);
	} catch (Exception e) {
	    System.out.println("UserDao.delete() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public Administrator findById(Long id) {
	return entityManager.find(Administrator.class, id);
	    }

    @Override
    public List<Administrator> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

	@Override
	public Optional<AdministratorAccount> findByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			AdministratorAccount adminAccount = this.entityManager
					.createNamedQuery("AdministratorAccount.findByEmail", AdministratorAccount.class)
					.setParameter("email_param", email)
					.getSingleResult();
			return Optional.ofNullable(adminAccount);
		} catch (NoResultException ex) {
			System.out.println("administratorDaoImpl.findByEmail() - not found : " + email);
		}
		return Optional.empty();
	}

	@Override
	public Administrator findByAdminAccountId(Long id) {
	    {		
		try {
		    Administrator administrator = this.entityManager
					.createNamedQuery("administrator.findByAdminAccountId", Administrator.class)
					.setParameter("c_param", id)
					.getSingleResult();
			return administrator;
		} catch (NoResultException ex) {
			System.out.println("administratorDaoImpl.findByAdminAccountId() - not found : " + id);
		}
		return null;
	}
	}

}