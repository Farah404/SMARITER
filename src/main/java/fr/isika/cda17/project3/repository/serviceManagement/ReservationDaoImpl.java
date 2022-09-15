package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.serviceManagement.Reservation;

@Stateless
public class ReservationDaoImpl implements ReservationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Reservation create(Reservation reservation) {
	try {

	    entityManager.persist(reservation);

	    return reservation;
	} catch (Exception e) {
	    System.out.println("reservation.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Reservation reservation) {
	try {
	    entityManager.merge(reservation);
	} catch (Exception e) {
	    System.out.println("ReservationImpl.update() - Failed : " + e.getMessage());
	}
    }

    @Override
    public void delete(Long id) {
	try {
	    Reservation deletedReservation = entityManager.find(Reservation.class, id);
	    entityManager.remove(deletedReservation);
	} catch (Exception e) {
	    System.out.println("ReservationDaoImpl.delete() - Failed : " + e.getMessage());
	}
    }

    @Override
    public Reservation findById(Long id) {
	return entityManager.find(Reservation.class, id);
    }

    @Override
    public List<Reservation> findAll() {
	return this.entityManager.createQuery("select ea from Reservation ea", Reservation.class).getResultList();
    }

}
