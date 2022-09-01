package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.repository.Dao;

public interface PersonalAssistanceServiceDao extends Dao<PersonalAssistanceService> {
	List<PersonalAssistanceService> findAllUserPersonalAssistanceServices(Long id);
}
