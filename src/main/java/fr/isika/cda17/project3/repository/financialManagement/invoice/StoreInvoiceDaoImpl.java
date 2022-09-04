package fr.isika.cda17.project3.repository.financialManagement.invoice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.financialManagement.invoice.StoreInvoice;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;

@Stateless
public class StoreInvoiceDaoImpl implements StoreInvoiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StoreInvoice create(StoreInvoice storeInvoice) {
	try {
	    entityManager.persist(storeInvoice);
	    return storeInvoice;
	} catch (Exception e) {
	    System.out.println("StoreInvoiceDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(StoreInvoice storeInvoice) {
	try {
	    entityManager.persist(storeInvoice);
	} catch (Exception e) {
	    System.out.println("StoreInvoiceDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    StoreInvoice deletedStoreInvoice = entityManager.find(StoreInvoice.class, id);
	    entityManager.remove(deletedStoreInvoice);
	} catch (Exception e) {
	    System.out.println("StoreInvoiceDao.delete() - Failed : " + e.getMessage());
	}
    }

    @Override
    public StoreInvoice findById(Long id) {
	return entityManager.find(StoreInvoice.class, id);

    }

    @Override
    public List<StoreInvoice> findAll() {
    	List<StoreInvoice> storeInvoiceList = this.entityManager
    			.createQuery("SELECT si FROM StoreInvoice si", StoreInvoice.class)
    			.getResultList();
    		return storeInvoiceList;
    }
    
    @Override
	public List<StoreInvoice> findAllUserAccountStoreInvoice(Long id) {
		List<StoreInvoice> storeInvoiceList = this.entityManager.createNamedQuery("StoreInvoice.findAllUserAccountStoreInvoice", StoreInvoice.class).setParameter("userid_param", id).getResultList();
		return storeInvoiceList;
	}
}
