package fr.isika.cda17.project3.repository.solutionManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.solutionManagement.CarPoolingSolution;

@Stateless
public class CarPoolingSolutionDaoImpl implements CarPoolingsolutionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CarPoolingSolution create(CarPoolingSolution carPoolingSolution) {
	try {
	    entityManager.persist(carPoolingSolution);
	    return carPoolingSolution;
	} catch (Exception e) {
	    System.out.println("CarPoolingsolutionDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(CarPoolingSolution carPoolingSolution) {
	try {
	    entityManager.persist(carPoolingSolution);
	} catch (Exception e) {
	    System.out.println("CarPoolingsolutionDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    CarPoolingSolution deletedCarPoolingSolution = entityManager.find(CarPoolingSolution.class, id);
	    entityManager.remove(deletedCarPoolingSolution);
	} catch (Exception e) {
	    System.out.println("CarPoolingsolutionDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public CarPoolingSolution findById(Long id) {
	return entityManager.find(CarPoolingSolution.class, id);

    }

    @Override
    public List<CarPoolingSolution> findAll() {
	return null;
    }

}
