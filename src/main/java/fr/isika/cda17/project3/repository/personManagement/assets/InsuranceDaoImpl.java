package fr.isika.cda17.project3.repository.personManagement.assets;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.assets.Insurance;

@Stateless
public class InsuranceDaoImpl implements InsuranceDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Insurance create(Insurance insurance) {
	try {
	    entityManager.persist(insurance);
	    return insurance;
	} catch (Exception e) {
	    System.out.println("InsuranceDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Insurance insurance) {
	try {
	    Insurance updatedInsurance  = entityManager.find(Insurance.class, insurance.getId());
	    updatedInsurance.setInsuranceAgencyName(insurance.getInsuranceAgencyName());
	    updatedInsurance.setInsuranceContractNumber(insurance.getInsuranceContractNumber());
	    updatedInsurance.setInsuranceContractExpiration(insurance.getInsuranceContractExpiration());
	    entityManager.persist(updatedInsurance);
	} catch (Exception e) {
	    System.out.println("InsuranceDao.update() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public void delete(Long id) {
	try {
	    Insurance deletedInsurance = entityManager.find(Insurance.class, id);
	    entityManager.remove(deletedInsurance);
	} catch (Exception e) {
	    System.out.println("InsuranceDao.delete() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public Insurance findById(Long id) {
	return entityManager.find(Insurance.class, id);
    }

    @Override
    public List<Insurance> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
