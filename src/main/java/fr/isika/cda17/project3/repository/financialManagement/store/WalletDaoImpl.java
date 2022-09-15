package fr.isika.cda17.project3.repository.financialManagement.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;

@Stateless
public class WalletDaoImpl implements WalletDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Wallet create(Wallet wallet) {
	try {
	    entityManager.persist(wallet);
	    return wallet;
	} catch (Exception e) {
	    return null;
	}
    }

    @Override
    public void update(Wallet wallet) {
	try {
	    entityManager.merge(wallet);
	} catch (Exception e) {
	}
	
    }

    @Override
    public void delete(Long id) {
	try {
	    Wallet deletedWallet = entityManager.find(Wallet.class, id);
	    entityManager.remove(deletedWallet);
	} catch (Exception e) {
	}
	
    }

    @Override
    public Wallet findById(Long id) {
		return entityManager.find(Wallet.class, id);
    }

    @Override
    public List<Wallet> findAll() {
    return this.entityManager.createQuery("SELECT w FROM Wallet w", Wallet.class).getResultList();
    }

}