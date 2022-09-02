package fr.isika.cda17.project3.repository.financialManagement.invoice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.invoice.CustomerInvoice;

@Stateless
public class CustomerInvoiceDaoImpl implements CustomerInvoiceDao{

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public CustomerInvoice create(CustomerInvoice customerInvoice) {
	try {	
		entityManager.persist(customerInvoice);
		return customerInvoice;
	} catch (Exception e) {
	    System.out.println("ServiceInvoiceDaoImpl.create() - Failed : " + e.getMessage());
	    return null;
	}
	}

	@Override
	public void update(CustomerInvoice customerInvoice) {
		try {
		    entityManager.merge(customerInvoice);
		} catch (Exception e) {
		    System.out.println("SolutionImpl.update() - Failed : " + e.getMessage());
		}
		
	}

	@Override
	public void delete(Long id) {
		try {
		    CustomerInvoice customerInvoice = entityManager.find(CustomerInvoice.class, id);
		    entityManager.remove(customerInvoice);
		} catch (Exception e) {
		    System.out.println("SolutionImpl.delete() - Failed : " + e.getMessage());
		}
		
	}

	@Override
	public CustomerInvoice findById(Long id) {
		CustomerInvoice customerInvoice = entityManager.find(CustomerInvoice.class, id);
		return customerInvoice;
	}

	@Override
	public List<CustomerInvoice> findAll() {
		List<CustomerInvoice> customerInvoiceList = this.entityManager.createQuery("SELECT cu FROM CustomerInvoice cu", CustomerInvoice.class).getResultList();
		return customerInvoiceList;
	}
}
