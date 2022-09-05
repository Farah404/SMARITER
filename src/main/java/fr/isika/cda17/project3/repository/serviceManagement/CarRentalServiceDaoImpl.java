package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;

@Stateless
public class CarRentalServiceDaoImpl implements CarRentalServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CarRentalService create(CarRentalService carRentalService) {
	try {
	    entityManager.persist(carRentalService);
	    return carRentalService;
	} catch (Exception e) {
	    System.out.println("CarRentalServiceDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(CarRentalService carRentalService) {
	try {
	    entityManager.merge(carRentalService);
	} catch (Exception e) {
	    System.out.println("CarRentalServiceDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    CarRentalService deletedCarRentalService = entityManager.find(CarRentalService.class, id);
	    entityManager.remove(deletedCarRentalService);
	} catch (Exception e) {
	    System.out.println("CarRentalServiceDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public CarRentalService findById(Long id) {
	return entityManager.find(CarRentalService.class, id);

    }

    @Override
    public List<CarRentalService> findAll() {

	List<CarRentalService> c = this.entityManager
		.createQuery("select ea from CarRentalService ea", CarRentalService.class).getResultList();
	System.out.println(c);
	return c;

    }

	@Override
	public List<CarRentalService> findAllUserCarRentalServices(Long id) {
		List<CarRentalService> crsUserList = this.entityManager.createNamedQuery("CarRentalService.findAllUserCRS", CarRentalService.class)
				.setParameter("userid_param", id).getResultList();
		return crsUserList;
	}
	@Override
	public ServiceType findServiceType(Long id) {
		ServiceType serviceType = null;
		try {
			CarRentalService crs = entityManager.find(CarRentalService.class, id);
			serviceType = crs.getServicetype();
			return serviceType;	
		}catch (Exception e) {
			return serviceType;
		}
	}

	@Override
	public double findServicePrice(Long id) {
		double servicePrice = 0;
		try {
		CarRentalService crs = entityManager.find(CarRentalService.class, id);
		servicePrice = crs.getPrice();
		return servicePrice;
		}catch (Exception e) {
			return servicePrice;
		}
	}

	@Override
	public String findReferenceNumber(Long id) {
		String referenceNumber="";
		try {
		CarRentalService crs = entityManager.find(CarRentalService.class, id);
		referenceNumber = crs.getReferenceNumber();
		return referenceNumber;
	}catch (Exception e) {
		return referenceNumber;
	}
	}
	@Override
	public Long findByReferenceNumber(String referenceNumber) {
		CarRentalService crs = this.entityManager.createNamedQuery("CarRentalService.findByReferenceNumber", CarRentalService.class).setParameter("referencenumber_param", referenceNumber).getSingleResult();
		return crs.getId();
	}
}
