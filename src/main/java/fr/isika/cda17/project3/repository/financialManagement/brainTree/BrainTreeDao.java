package fr.isika.cda17.project3.repository.financialManagement.brainTree;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.brainTree.BrainTree;
import fr.isika.cda17.project3.repository.Dao;

public class BrainTreeDao implements Dao<BrainTree> {

	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public BrainTree create(BrainTree t) {
		try {
		    entityManager.persist(t);
		    return t;
		} catch (Exception e) {
		    System.out.println("BankDetailsDao.create() - Failed : " + e.getMessage());
		    return null;
		}
	}

	@Override
	public void update(BrainTree t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public BrainTree findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BrainTree> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}