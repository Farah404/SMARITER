package fr.isika.cda17.project3.repository.personManagement;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.personManagement.Customer;
import fr.isika.cda17.project3.model.personManagement.EntityAccount;

@Stateless
public class EntityAccountImpl implements EntityAccountDao{

    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public EntityAccount create (EntityAccount entityAccount) {
	  try {
	      EntityAccount entityAccountToCreate = new EntityAccount();
	      entityAccountToCreate.setUsername(entityAccount.getUsername());
	      entityAccountToCreate.setPassword(entityAccount.getPassword()); // Ajout de MD5 pour l'encryptage du mdp
	      entityAccountToCreate.setProfilePicturePath(entityAccount.getProfilePicturePath());
	      entityAccountToCreate.setCreationDate(entityAccount.getCreationDate());
	      entityAccountToCreate.setAccountType(entityAccount.getAccountType());
	            this.entityManager.persist(entityAccountToCreate);
	            return entityAccount;
	        } catch (Exception e) {
	            System.out.println("EntityAccountDaoImpl.create() - Failed : " + e.getMessage());
	            return null;
	        }
    }

    @Override
    public void update(EntityAccount entityAccount) {
	 try {
	     EntityAccount entityAccountToUpdate = this.entityManager.find(EntityAccount.class, entityAccount.getId());
	     entityAccountToUpdate.setUsername(entityAccount.getUsername());
	     entityAccountToUpdate.setPassword(entityAccount.getPassword()); // Ajout de MD5 pour l'encryptage du mdp
	     entityAccountToUpdate.setProfilePicturePath(entityAccount.getProfilePicturePath());
	     entityAccountToUpdate.setCreationDate(entityAccount.getCreationDate());
	     entityAccountToUpdate.setAccountType(entityAccount.getAccountType());
	            this.entityManager.persist(entityAccountToUpdate);
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
    public Optional<EntityAccount> findByEmail(String email) {
	 try {
	     EntityAccount entityAccount = this.entityManager.createNamedQuery("EntityAccount.findByEmail", EntityAccount.class)
	                    .setParameter("email_param", email).getSingleResult();
	            return Optional.ofNullable(entityAccount);
	        } catch (NoResultException ex) {
	            System.out.println("EntityAccountDaoImpl.findByEmail() - not found : " + email);
	        }
	        return Optional.empty();
    }

    
    
}
