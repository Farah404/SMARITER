package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;

@Stateless
public class CarPoolingServiceDaoImpl implements CarPoolingServiceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CarPoolingService create(CarPoolingService carPoolingService) {
	try {
	    entityManager.persist(carPoolingService);
	    return carPoolingService;
	} catch (Exception e) {
	    System.out.println("CarPoolingServiceDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(CarPoolingService carPoolingService) {
	try {
	    entityManager.merge(carPoolingService);
	} catch (Exception e) {
	    System.out.println("CarPoolingServiceDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    CarPoolingService deletedCarPoolingService = entityManager.find(CarPoolingService.class, id);
	    entityManager.remove(deletedCarPoolingService);
	} catch (Exception e) {
	    System.out.println("CarPoolingServiceDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public CarPoolingService findById(Long id) {
	return entityManager.find(CarPoolingService.class, id);

    }

    @Override
    public List<CarPoolingService> findAll() {

	List<CarPoolingService> cPSList = this.entityManager
		.createQuery("SELECT ea FROM CarPoolingService ea", CarPoolingService.class).getResultList();
	return cPSList;

    }

	@Override
	public List<CarPoolingService> findAllUserCarPoolingServices(Long id) {
		List<CarPoolingService> cpsUserList = this.entityManager.createNamedQuery("CarPoolingService.findAllUserCPS", CarPoolingService.class).setParameter("userid_param", id).getResultList();
		return cpsUserList;
	}

}
