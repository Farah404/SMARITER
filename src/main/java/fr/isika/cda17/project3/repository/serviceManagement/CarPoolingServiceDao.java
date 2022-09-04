package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.repository.Dao;

public interface CarPoolingServiceDao extends Dao<CarPoolingService> {
	List<CarPoolingService> findAllUserCarPoolingServices(Long id);
	ServiceType findServiceType(Long id);
	double findServicePrice(Long id);
	String findReferenceNumber(Long id);
	
}
