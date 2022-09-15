package fr.isika.cda17.project3.repository.financialManagement.store;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;

@Stateless
public class ShoppingCartDaoImpl implements ShoppingCartDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
	try {
	    entityManager.persist(shoppingCart);
	    return shoppingCart;
	} catch (Exception e) {
	    return null;
	}
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
	try {
	    entityManager.merge(shoppingCart);
	} catch (Exception e) {
	}
    }

    @Override
    public void delete(Long id) {
	try {
	    ShoppingCart deletedShoppingCart = entityManager.find(ShoppingCart.class, id);
	    entityManager.remove(deletedShoppingCart);
	} catch (Exception e) {
	}
	
    }

    @Override
    public ShoppingCart findById(Long id) {
	return entityManager.find(ShoppingCart.class, id);
    }

    @Override
    public List<ShoppingCart> findAll() {
    return this.entityManager.createQuery("SELECT sc FROM ShoppingCart sc", ShoppingCart.class).getResultList();
    }

}
