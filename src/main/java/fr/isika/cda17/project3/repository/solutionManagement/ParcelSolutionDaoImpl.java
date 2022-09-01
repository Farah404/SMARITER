package fr.isika.cda17.project3.repository.solutionManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.solutionManagement.ParcelSolution;

@Stateless
public class ParcelSolutionDaoImpl implements ParcelSolutionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ParcelSolution create(ParcelSolution parcelSolution) {
	try {
	    entityManager.persist(parcelSolution);
	    return parcelSolution;
	} catch (Exception e) {
	    System.out.println("ParcelSolutionDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(ParcelSolution parcelSolution) {
	try {
	    ParcelSolution updatedParcelSolution = entityManager.find(ParcelSolution.class, parcelSolution.getId());
	    updatedParcelSolution.setAtypicalVolumeOption(parcelSolution.getAtypicalVolumeOption());
	    updatedParcelSolution.setFragileOoption(parcelSolution.getFragileOoption());
	    updatedParcelSolution.setWeightKilogrammesOption(parcelSolution.getWeightKilogrammesOption());

	    entityManager.persist(parcelSolution);
	} catch (Exception e) {
	    System.out.println("ParcelSolutionDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    ParcelSolution deletedParcelSolution = entityManager.find(ParcelSolution.class, id);
	    entityManager.remove(deletedParcelSolution);
	} catch (Exception e) {
	    System.out.println("ParcelSolutionDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public ParcelSolution findById(Long id) {
	return entityManager.find(ParcelSolution.class, id);
    }

    @Override
    public List<ParcelSolution> findAll() {
	return null;
    }

}
