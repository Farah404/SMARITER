package fr.isika.cda17.project3.repository.serviceManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;

@Stateless
public class PersonalAssistanceServiceDaoImpl implements PersonalAssistanceServiceDao {

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
		entityManager.merge(personalAssistanceService);
	} catch (Exception e) {
	    System.out.println("PersonalAssistanceServiceDao.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    PersonalAssistanceService deletedPersonalAssistanceService = entityManager
		    .find(PersonalAssistanceService.class, id);
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
	List<PersonalAssistanceService> pASList = this.entityManager
		.createQuery("select pas from PersonalAssistanceService pas", PersonalAssistanceService.class)
		.getResultList();
	return pASList;
    }

	@Override
	public List<PersonalAssistanceService> findAllUserPersonalAssistanceServices(Long id) {
		List<PersonalAssistanceService> pasUserList = this.entityManager.createNamedQuery("PersonalAssistanceService.findAllUserPAS", PersonalAssistanceService.class).setParameter("userid_param", id).getResultList();
		return pasUserList;
	}
	
	@Override
	public ServiceType findServiceType(Long id) {
		ServiceType serviceType = null;
		try {
			PersonalAssistanceService pas = entityManager.find(PersonalAssistanceService.class, id);
			serviceType = pas.getServicetype();
			return serviceType;	
		}catch (Exception e) {
			return serviceType;
		}
	}

	@Override
	public double findServicePrice(Long id) {
		double servicePrice = 0;
		try {
			PersonalAssistanceService pas = entityManager.find(PersonalAssistanceService.class, id);
		servicePrice = pas.getPrice();
		return servicePrice;
		}catch (Exception e) {
			return servicePrice;
		}
	}

	@Override
	public String findReferenceNumber(Long id) {
		String referenceNumber="";
		try {
			PersonalAssistanceService pas = entityManager.find(PersonalAssistanceService.class, id);
		referenceNumber = pas.getReferenceNumber();
		return referenceNumber;
	}catch (Exception e) {
		return referenceNumber;
	}
	}

}
