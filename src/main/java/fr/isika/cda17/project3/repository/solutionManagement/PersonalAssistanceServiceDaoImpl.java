package fr.isika.cda17.project3.repository.solutionManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.solutionManagement.CarPoolingService;
import fr.isika.cda17.project3.model.solutionManagement.PersonalAssistanceService;

@Stateless
public class PersonalAssistanceServiceDaoImpl implements PersonalAssistanceServiceDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PersonalAssistanceService create(PersonalAssistanceService personalAssistanceService) {
	try {
	    entityManager.persist(personalAssistanceService);
	    return personalAssistanceService;
	} catch (Exception e) {
	    System.out.println("PersonalAssistanceServiceDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(PersonalAssistanceService personalAssistanceService) {
	try {
	    PersonalAssistanceService updatedPersonalAssistanceService = entityManager.find(PersonalAssistanceService.class, personalAssistanceService.getId());
	    updatedPersonalAssistanceService.setPublicationDate(personalAssistanceService.getPublicationDate());
	    updatedPersonalAssistanceService.setExpirationDate(personalAssistanceService.getExpirationDate());
	    updatedPersonalAssistanceService.setStartDate(personalAssistanceService.getStartDate());
	    updatedPersonalAssistanceService.setEndDate(personalAssistanceService.getEndDate());
	    updatedPersonalAssistanceService.setReferenceNumber(personalAssistanceService.getReferenceNumber());
	    updatedPersonalAssistanceService.setIsRequest(personalAssistanceService.getIsRequest());
	    updatedPersonalAssistanceService.setPrice(personalAssistanceService.getPrice());
	    
	    updatedPersonalAssistanceService.setIsUrgent(personalAssistanceService.getIsUrgent());
	    updatedPersonalAssistanceService.setPersonalAssistanceType(personalAssistanceService.getPersonalAssistanceType());
	    
	    entityManager.persist(personalAssistanceService);
	} catch (Exception e) {
	    System.out.println("PersonalAssistanceServiceDao.update() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public void delete(Long id) {
	try {
	    PersonalAssistanceService deletedPersonalAssistanceService = entityManager.find(PersonalAssistanceService.class, id);
	    entityManager.remove(deletedPersonalAssistanceService);
	} catch (Exception e) {
	    System.out.println("PersonalAssistanceServiceDao.delete() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public PersonalAssistanceService findById(Long id) {
	return entityManager.find(PersonalAssistanceService.class, id);
	
    }

    @Override
    public List<PersonalAssistanceService> findAll() {
	// TODO Auto-generated method stub
	return null;
    }


}
