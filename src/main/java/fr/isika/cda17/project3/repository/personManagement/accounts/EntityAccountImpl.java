package fr.isika.cda17.project3.repository.personManagement.accounts;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;

@Stateless
public class EntityAccountImpl implements EntityAccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityAccount create(EntityAccount entityAccount) {
	try {
	    entityManager.persist(entityAccount);
	    return entityAccount;
	} catch (Exception e) {
	    System.out.println("EntityAccountDaoImpl.create() - Failed : " + e.getMessage());
	    return null;
	}
    }

    @Override
    public void update(EntityAccount entityAccount) {
	try {
	    entityManager.merge(entityAccount);
	} catch (Exception e) {
	    System.out.println("EntityAccountDaoImpl.update() - Failed : " + e.getMessage());
	}

    }

    @Override
    public void delete(Long id) {
	try {
	    EntityAccount entityAccountToDelete = this.entityManager.find(EntityAccount.class, id);
	    this.entityManager.remove(entityAccountToDelete);
	} catch (Exception e) {
	    System.out.println("EntityAccountDaoImpl.delete() - Failed : " + e.getMessage());
	}

    }

    @Override
    public EntityAccount findById(Long id) {
	return this.entityManager.find(EntityAccount.class, id);
    }

    @Override
    public List<EntityAccount> findAll() {
	return this.entityManager.createQuery("select ea from EntityAccount ea", EntityAccount.class).getResultList();
    }

    @Override
    public Optional<EntityAccount> findByName(String name) {
	try {
	    EntityAccount entityAccount = this.entityManager
		    .createNamedQuery("EntityAccount.findByName", EntityAccount.class).setParameter("name_param", name)
		    .getSingleResult();
	    return Optional.ofNullable(entityAccount);
	} catch (NoResultException ex) {
	    System.out.println("EntityAccountDaoImpl.findByEmail() - not found : " + name);
	}
	return Optional.empty();
    }

    @Override
    public Optional<EntityAccount> findByEmail(String email) {
	try {
	    EntityAccount entityAccount = this.entityManager
		    .createNamedQuery("EntityAccount.findByEmail", EntityAccount.class)
		    .setParameter("email_param", email).getSingleResult();
	    return Optional.ofNullable(entityAccount);
	} catch (NoResultException ex) {
	    System.out.println("EntityAccountDaoImpl.findByEmail() - not found : " + email);
	}
	return Optional.empty();
    }

}