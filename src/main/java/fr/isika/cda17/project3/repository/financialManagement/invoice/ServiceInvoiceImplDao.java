package fr.isika.cda17.project3.repository.financialManagement.invoice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;

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
    public void update(ServiceInvoice serviceInvoice) {
    	try {
    	    entityManager.merge(serviceInvoice);
    	} catch (Exception e) {
    	    System.out.println("ServiceInvoiceDao.update() - Failed : " + e.getMessage());
    	}

    }

    @Override
    public void delete(Long id) {
    	try {
    	    ServiceInvoice deletedServiceInvoice = entityManager.find(ServiceInvoice.class, id);
    	    entityManager.remove(deletedServiceInvoice);
    	} catch (Exception e) {
    	    System.out.println("ServiceInvoiceDao.delete() - Failed : " + e.getMessage());
    	}

    }

    @Override
    public ServiceInvoice findById(Long id) {
	return entityManager.find(ServiceInvoice.class,id);
    }

    @Override
    public List<ServiceInvoice> findAll() {
    	List<ServiceInvoice> serviceInvoiceList = this.entityManager
    			.createQuery("SELECT si FROM ServiceInvoice si", ServiceInvoice.class)
    			.getResultList();
    		return serviceInvoiceList;
    }

	@Override
	public String ServiceInvoiceNumber() {
		List<ServiceInvoice> serviceInvoiceList = this.entityManager
    			.createQuery("SELECT si FROM ServiceInvoice si", ServiceInvoice.class)
    			.getResultList();
		int ref = serviceInvoiceList.size() + 1;
		String invoiceNumber = "2022 - 00" + ref + " - SI";
		return invoiceNumber;
	}
	 @Override
		public List<ServiceInvoice> findAllUserAccountProviderServiceInvoice(Long id) {
			List<ServiceInvoice> serviceInvoiceProviderList = this.entityManager.createNamedQuery("ServiceInvoice.findAllUserAccountProviderServiceInvoice", ServiceInvoice.class).setParameter("userid_param", id).getResultList();
			return serviceInvoiceProviderList;
		}
	 
	 @Override
		public List<ServiceInvoice> findAllUserAccountPurchaserServiceInvoice(Long id) {
			List<ServiceInvoice> serviceInvoicePurchaserList = this.entityManager.createNamedQuery("ServiceInvoice.findAllUserAccountPurchaserServiceInvoice", ServiceInvoice.class).setParameter("userid_param", id).getResultList();
			return serviceInvoicePurchaserList;
		}

}
