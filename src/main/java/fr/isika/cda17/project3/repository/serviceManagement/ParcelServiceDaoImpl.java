package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;

@Stateless
public class ParcelServiceDaoImpl implements ParcelServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ParcelService create(ParcelService parcelService) {
	try {
	    entityManager.persist(parcelService);
	    return parcelService;
	} catch (Exception e) {
	    System.out.println("ParcelServiceDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(ParcelService parcelService) {
	try {
	    entityManager.merge(parcelService);
	} catch (Exception e) {
	    System.out.println("ParcelServiceDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    ParcelService deletedParcelService = entityManager.find(ParcelService.class, id);
	    entityManager.remove(deletedParcelService);
	} catch (Exception e) {
	    System.out.println("ParcelServiceDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public ParcelService findById(Long id) {
	return entityManager.find(ParcelService.class, id);

    }

    @Override
    public List<ParcelService> findAll() {
	List<ParcelService> pSList = this.entityManager
		.createQuery("SELECT ps FROM ParcelService ps", ParcelService.class).getResultList();
	return pSList;
    }

	@Override
	public List<ParcelService> findAllUserParcelServices(Long id) {
		List<ParcelService> psUserList = this.entityManager.createNamedQuery("ParcelService.findAllUserPS", ParcelService.class).setParameter("userid_param", id).getResultList();
		return psUserList;
	}
	@Override
	public ServiceType findServiceType(Long id) {
		ServiceType serviceType = null;
		try {
			ParcelService ps = entityManager.find(ParcelService.class, id);
			serviceType = ps.getServicetype();
			return serviceType;	
		}catch (Exception e) {
			return serviceType;
		}
	}

	@Override
	public double findServicePrice(Long id) {
		double servicePrice = 0;
		try {
		ParcelService ps = entityManager.find(ParcelService.class, id);
		servicePrice = ps.getPrice();
		return servicePrice;
		}catch (Exception e) {
			return servicePrice;
		}
	}

	@Override
	public String findReferenceNumber(Long id) {
		String referenceNumber="";
		try {
		ParcelService ps = entityManager.find(ParcelService.class, id);
		referenceNumber = ps.getReferenceNumber();
		return referenceNumber;
	}catch (Exception e) {
		return referenceNumber;
	}
	}
	
	@Override
	public Long findByReferenceNumber(String referenceNumber) {
		ParcelService ps = this.entityManager.createNamedQuery("ParcelService.findByReferenceNumber", ParcelService.class).setParameter("referencenumber_param", referenceNumber).getSingleResult();
		return ps.getId();
	}

}
