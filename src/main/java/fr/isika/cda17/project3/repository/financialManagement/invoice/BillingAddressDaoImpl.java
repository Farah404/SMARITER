package fr.isika.cda17.project3.repository.financialManagement.invoice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;

@Stateless
public class BillingAddressDaoImpl implements BillingAddressDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public BillingAddress create(BillingAddress billingAddress) {
	try {
	    entityManager.persist(billingAddress);
	    return billingAddress;
	} catch (Exception e) {
	    System.out.println("BillingAddressDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(BillingAddress billingAddress) {
	try {
	    BillingAddress updatedBillingAddress = entityManager.find(BillingAddress.class, billingAddress.getId());
	    updatedBillingAddress.setAddressLine(billingAddress.getAddressLine());
	    updatedBillingAddress.setCity(billingAddress.getCity());
	    updatedBillingAddress.setRegion(billingAddress.getRegion());
	    updatedBillingAddress.setCountry(billingAddress.getCountry());
	    updatedBillingAddress.setPostalCode(billingAddress.getPostalCode());
	   
	    entityManager.persist(billingAddress);
	} catch (Exception e) {
	    System.out.println("BillingAddressDao.update() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public void delete(Long id) {
	try {
	    BillingAddress deletedBillingAddress = entityManager.find(BillingAddress.class, id);
	    entityManager.remove(deletedBillingAddress);
	} catch (Exception e) {
	    System.out.println("BillingAddressDao.delete() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public BillingAddress findById(Long id) {
	return entityManager.find(BillingAddress.class, id);
	
    }

    @Override
    public List<BillingAddress> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
