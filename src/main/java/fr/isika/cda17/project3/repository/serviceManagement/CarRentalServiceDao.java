package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.repository.Dao;

public interface CarRentalServiceDao extends Dao<CarRentalService> {
	List<CarRentalService> findAllUserCarRentalServices(Long id);
	ServiceType findServiceType(Long id);
	double findServicePrice(Long id);
	String findReferenceNumber(Long id);
	Long findByReferenceNumber(String referenceNumber);
}
