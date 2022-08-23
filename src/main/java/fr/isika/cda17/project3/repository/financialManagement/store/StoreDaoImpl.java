package fr.isika.cda17.project3.repository.financialManagement.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.store.Store;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;

@Stateless
public class StoreDaoImpl implements StoreDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Store create(Store store) {
	try {
	    entityManager.persist(store);
	    return store;
	} catch (Exception e) {
	    System.out.println("StoreDao.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(Store store) {
	try {
	    Store updatedStore = entityManager.find(Store.class, store.getId());
	    updatedStore.setBatchOneName(store.getBatchOneName());
	    updatedStore.setBatchOneQuantity(store.getBatchOneQuantity());
	    updatedStore.setBatchOnePrice(store.getBatchOnePrice());
	    
	    updatedStore.setBatchTwoName(store.getBatchTwoName());
	    updatedStore.setBatchTwoQuantity(store.getBatchTwoQuantity());
	    updatedStore.setBatchTwoPrice(store.getBatchTwoPrice());
	    
	    updatedStore.setBatchThreeName(store.getBatchThreeName());
	    updatedStore.setBatchThreeQuantity(store.getBatchThreeQuantity());
	    updatedStore.setBatchThreePrice(store.getBatchThreePrice());
	    
	    updatedStore.setMonthlySubscriptionName(store.getMonthlySubscriptionName());
	    updatedStore.setMonthlySubscriptionQuantity(store.getMonthlySubscriptionQuantity());
	    updatedStore.setMonthlySubscriptionPrice(store.getMonthlySubscriptionPrice());
	    
	    updatedStore.setSemestrialSubscriptionName(store.getSemestrialSubscriptionName());
	    updatedStore.setSemestrialSubscriptionQuantity(store.getSemestrialSubscriptionQuantity());
	    updatedStore.setSemestrialSubscriptionPrice(store.getSemestrialSubscriptionPrice());
	    
	    updatedStore.setTrimestrialSubscriptionName(store.getTrimestrialSubscriptionName());
	    updatedStore.setTrimestrialSubscriptionQuantity(store.getTrimestrialSubscriptionQuantity());
	    updatedStore.setTrimestrialSubscriptionPrice(store.getTrimestrialSubscriptionPrice());
	    
	    
	    entityManager.persist(store);
	} catch (Exception e) {
	    System.out.println("StoreDao.update() - Failed : " + e.getMessage());
	}
    }

    @Override
    public void delete(Long id) {
	try {
	    Store deletedStore = entityManager.find(Store.class, id);
	    entityManager.remove(deletedStore);
	} catch (Exception e) {
	    System.out.println("StoreDao.delete() - Failed : " + e.getMessage());
	}
	
    }

    @Override
    public Store findById(Long id) {
	return entityManager.find(Store.class, id);
	
    }

    @Override
    public List<Store> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
