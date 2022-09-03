package fr.isika.cda17.project3.repository.financialManagement.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.store.Store;

@Stateless
public class StoreDaoImpl implements StoreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Store create(Store ecoStore) {
	try {
	    entityManager.persist(ecoStore);
	    return ecoStore;
	} catch (Exception e) {
	    return null;
	}
    }

    @Override
    public void update(Store store) {
	try {
	    entityManager.merge(store);
	} catch (Exception e) {
	}
    }

    @Override
    public void delete(Long id) {
	try {
	    Store deletedStore = entityManager.find(Store.class, id);
	    entityManager.remove(deletedStore);
	} catch (Exception e) {
	}
    }

    @Override
    public Store findById(Long id) {
	return entityManager.find(Store.class, id);

    }

    @Override
    public List<Store> findAll() {
	return null;
    }

}