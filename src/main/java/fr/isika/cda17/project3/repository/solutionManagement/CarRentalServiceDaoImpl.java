package fr.isika.cda17.project3.repository.solutionManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.solutionManagement.CarPoolingService;
import fr.isika.cda17.project3.model.solutionManagement.CarRentalService;
import fr.isika.cda17.project3.model.solutionManagement.Itinerary;

@Stateless
public class CarRentalServiceDaoImpl implements CarRentalServiceDao{
    
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
	    CarRentalService updatedCarRentalService = entityManager.find(CarRentalService.class, carRentalService.getId());
	    updatedCarRentalService.setPublicationDate(carRentalService.getPublicationDate());
	    updatedCarRentalService.setExpirationDate(carRentalService.getExpirationDate());
	    updatedCarRentalService.setStartDate(carRentalService.getStartDate());
	    updatedCarRentalService.setEndDate(carRentalService.getEndDate());
	    updatedCarRentalService.setReferenceNumber(carRentalService.getReferenceNumber());
	    updatedCarRentalService.setIsRequest(carRentalService.getIsRequest());
	    updatedCarRentalService.setPrice(carRentalService.getPrice());
	    
	    updatedCarRentalService.setKeyPickUpAddress(carRentalService.getKeyPickUpAddress());
	    updatedCarRentalService.setKeyDropOffAddress(carRentalService.getKeyDropOffAddress());
	    
	    entityManager.persist(carRentalService);
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
	// TODO Auto-generated method stub
	return null;
    }

    

}
