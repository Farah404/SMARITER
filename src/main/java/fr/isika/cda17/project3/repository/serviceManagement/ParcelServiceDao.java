package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.repository.Dao;

public interface ParcelServiceDao extends Dao<ParcelService> {
	List<ParcelService> findAllUserParcelServices(Long id);
	ServiceType findServiceType(Long id);
	double findServicePrice(Long id);
	String findReferenceNumber(Long id);
}
