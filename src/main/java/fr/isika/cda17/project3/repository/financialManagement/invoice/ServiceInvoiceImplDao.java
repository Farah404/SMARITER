package fr.isika.cda17.project3.repository.financialManagement.invoice;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;

@Stateless
public class ServiceInvoiceImplDao implements ServiceInvoiceDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public ServiceInvoice create(ServiceInvoice t) {
		  try {
	          entityManager.persist(t);
	            return t;
	        } catch (Exception e) {
	            System.out.println("ServiceInvoiceDaoImpl.create() - Failed : " + e.getMessage());
	            return null;
	        }
    }
	@Override
	public void update(ServiceInvoice t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServiceInvoice findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceInvoice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
