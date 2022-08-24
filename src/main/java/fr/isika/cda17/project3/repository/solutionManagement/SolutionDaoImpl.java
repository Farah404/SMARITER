package fr.isika.cda17.project3.repository.solutionManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.Administrator;
import fr.isika.cda17.project3.model.solutionManagement.Solution;

@Stateless
public class SolutionDaoImpl implements SolutionDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Solution create(Solution solution) {
	try {
	    entityManager.persist(solution);
	    return solution;
	} catch (Exception e) {
	    System.out.println("solution.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Solution solution) {
	try {
	    Solution updatedSolution = entityManager.find(Solution.class, solution.getId());
	    updatedSolution.setPaymentSystemChoice(solution.getPaymentSystemChoice());
	    updatedSolution.setMessagingSystemChoice(solution.getMessagingSystemChoice());
	    updatedSolution.setPriceDeal(solution.getPriceDeal());
	    updatedSolution.setRatingSystemIncluded(solution.isRatingSystemIncluded());
	    updatedSolution.setCarPoolingsolutionIncluded(solution.isCarPoolingsolutionIncluded());
	    updatedSolution.setCarRentalSolutionIncluded(solution.isCarRentalSolutionIncluded());
	    updatedSolution.setParcelSolutionIncluded(solution.isParcelSolutionIncluded());
	    updatedSolution.setPersonalAssistanceSolutionIncluded(solution.isPersonalAssistanceSolutionIncluded());
	    updatedSolution.setPrivate(solution.isPrivate());
	    
	    entityManager.persist(solution);
	} catch (Exception e) {
	    System.out.println("AdministratorDao.update() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public void delete(Long id) {
	try {
	    Solution deletedSolution = entityManager.find(Solution.class, id);
	    entityManager.remove(deletedSolution);
	} catch (Exception e) {
	    System.out.println("UserDao.delete() - Failed : " + e.getMessage());
	}
    }
    

    @Override
    public Solution findById(Long id) {
	return entityManager.find(Solution.class, id);
	
    }

    @Override
    public List<Solution> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
