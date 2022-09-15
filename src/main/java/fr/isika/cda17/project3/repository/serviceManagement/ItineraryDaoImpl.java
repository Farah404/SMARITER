package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.serviceManagement.Itinerary;
import fr.isika.cda17.project3.model.solutionManagement.CarPoolingSolution;

@Stateless
public class ItineraryDaoImpl implements ItineraryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Itinerary create(Itinerary itinerary) {
	try {
	    entityManager.persist(itinerary);
	    return itinerary;
	} catch (Exception e) {
	    System.out.println("ItineraryDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Itinerary itinerary) {
	try {
	    entityManager.persist(itinerary);
	} catch (Exception e) {
	    System.out.println("ItineraryDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    Itinerary deletedItinerary = entityManager.find(Itinerary.class, id);
	    entityManager.remove(deletedItinerary);
	} catch (Exception e) {
	    System.out.println("ItineraryDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public Itinerary findById(Long id) {
	return entityManager.find(Itinerary.class, id);

    }

    @Override
    public List<Itinerary> findAll() {
	return this.entityManager.createQuery("SELECT i FROM Itinerary i", Itinerary.class).getResultList();
    }

}
