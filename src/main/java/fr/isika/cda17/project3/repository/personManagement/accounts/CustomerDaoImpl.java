package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Customer;

@Stateless
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer create(Customer customer) {
	try {
	    entityManager.persist(customer);
	    return customer;
	} catch (Exception e) {
	    System.out.println("CustomerDaoImpl.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Customer customer) {
	try {
	    Customer updatedCustomer = this.entityManager.find(Customer.class, customer.getId());
	    updatedCustomer.setFirstName(customer.getFirstName());
	    updatedCustomer.setLastName(customer.getLastName());
	    updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
	    updatedCustomer.setEntityAccount(customer.getEntityAccount());
	    entityManager.merge(updatedCustomer);
	} catch (Exception e) {
	    System.out.println("CustomerDao.create() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    Customer customerToDelete = this.entityManager.find(Customer.class, id);
	    entityManager.remove(customerToDelete);
	} catch (Exception e) {
	    System.out.println("DaoImpl.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public Customer findById(Long id) {
	return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Customer findByEntityAccountId(Long id) {
	try {
	    Customer customer = this.entityManager.createNamedQuery("customer.findByEntityAccountId", Customer.class)
		    .setParameter("c_param", id).getSingleResult();
	    return customer;
	} catch (NoResultException ex) {
	    System.out.println("EntityAccountDaoImpl.findByEntityAccountId() - not found : " + id);
	}
	return null;
    }

}
