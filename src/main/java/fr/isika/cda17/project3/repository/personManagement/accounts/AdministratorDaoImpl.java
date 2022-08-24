package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Administrator;

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

}
