package fr.isika.cda17.project3.repository.solutionManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.solutionManagement.Solution;

@Stateless
public class SolutionImpl implements SolutionDao {

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
	    entityManager.merge(solution);
	} catch (Exception e) {
	    System.out.println("SolutionImpl.update() - Failed : " + e.getMessage());
	}
    }

    @Override
    public void delete(Long id) {
	try {
	    Solution deletedSolution = entityManager.find(Solution.class, id);
	    entityManager.remove(deletedSolution);
	} catch (Exception e) {
	    System.out.println("SolutionImpl.delete() - Failed : " + e.getMessage());
	}
    }

    @Override
    public Solution findById(Long id) {
	return entityManager.find(Solution.class, id);

    }

    @Override
    public List<Solution> findAll() {
	// TODO Auto-generated method stub
	return this.entityManager.createQuery("select ea from Solution ea", Solution.class).getResultList();
    }

}
