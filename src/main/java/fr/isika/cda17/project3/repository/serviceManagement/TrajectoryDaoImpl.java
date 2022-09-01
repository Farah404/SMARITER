package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.serviceManagement.Trajectory;

@Stateless
public class TrajectoryDaoImpl implements TrajectoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Trajectory create(Trajectory trajectory) {
	try {
	    entityManager.persist(trajectory);
	    return trajectory;
	} catch (Exception e) {
	    System.out.println("TrajectoryDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Trajectory trajectory) {
	try {
	    Trajectory updatedTrajectory = entityManager.find(Trajectory.class, trajectory.getId());
	    updatedTrajectory.setDurationHours(trajectory.getDurationHours());
	    updatedTrajectory.setStopNumber(trajectory.getStopNumber());
	    updatedTrajectory.setStopDurationMinutes(trajectory.getStopDurationMinutes());
	    updatedTrajectory.setPickUpAddress(trajectory.getPickUpAddress());
	    updatedTrajectory.setDeliveryAddress(trajectory.getDeliveryAddress());

	    entityManager.persist(trajectory);
	} catch (Exception e) {
	    System.out.println("TrajectoryDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    Trajectory deletedTrajectory = entityManager.find(Trajectory.class, id);
	    entityManager.remove(deletedTrajectory);
	} catch (Exception e) {
	    System.out.println("TrajectoryDao.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public Trajectory findById(Long id) {
	return entityManager.find(Trajectory.class, id);

    }

    @Override
    public List<Trajectory> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
