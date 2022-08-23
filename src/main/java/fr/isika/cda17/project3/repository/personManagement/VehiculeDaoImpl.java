package fr.isika.cda17.project3.repository.personManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.Vehicule;

@Stateless
public class VehiculeDaoImpl implements VehiculeDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Vehicule create(Vehicule vehicule) {
	try {
	    entityManager.persist(vehicule);
	    return vehicule;
	} catch (Exception e) {
	    System.out.println("VehiculeDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Vehicule vehicule) {
	try {
	    Vehicule updatedVehicule = entityManager.find(Vehicule.class, vehicule.getId());
	    updatedVehicule.setBrand(vehicule.getBrand());
	    updatedVehicule.setRegistrationNumber(vehicule.getRegistrationNumber());
	    updatedVehicule.setHybrid(vehicule.isHybrid());
	    updatedVehicule.setElectric(vehicule.isElectric());
	    updatedVehicule.setManual(vehicule.isManual());
	    updatedVehicule.setTechnicalTestExpiration(vehicule.getTechnicalTestExpiration());
	    
	    entityManager.persist(updatedVehicule);
	} catch (Exception e) {
	    System.out.println("VehiculeDao.update() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public void delete(Long id) {
	try {
	    Vehicule deletedVehicule = entityManager.find(Vehicule.class, id);
	    entityManager.remove(deletedVehicule);
	} catch (Exception e) {
	    System.out.println("VehiculeDao.delete() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public Vehicule findById(Long id) {
	return entityManager.find(Vehicule.class, id);
    }

    @Override
    public List<Vehicule> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
