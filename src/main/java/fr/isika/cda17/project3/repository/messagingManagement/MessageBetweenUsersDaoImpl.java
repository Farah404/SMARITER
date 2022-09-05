package fr.isika.cda17.project3.repository.messagingManagement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda17.project3.model.messagingManagement.MessageBetweenUsers;

@Stateless
public class MessageBetweenUsersDaoImpl implements MessageDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public MessageBetweenUsers create(MessageBetweenUsers message) {
		 entityManager.persist(message);
		 return message;
	
	}

	@Override
	public void update(MessageBetweenUsers message) {
		entityManager.merge(message);
		
	}

	@Override
	public void delete(Long id) {
		MessageBetweenUsers message = entityManager.find(MessageBetweenUsers.class, id);
		entityManager.remove(message);
		
	}

	@Override
	public MessageBetweenUsers findById(Long id) {
		MessageBetweenUsers message = entityManager.find(MessageBetweenUsers.class, id);
		return message;
	}

	@Override
	public List<MessageBetweenUsers> findAll() {
		List<MessageBetweenUsers> messageList = this.entityManager
				.createQuery("SELECT m FROM MessageBetweenUsers m", MessageBetweenUsers.class)
				.getResultList();
		return messageList;
	}
	@Override
	public List<MessageBetweenUsers> findAllMessageReceivedByUser(Long id) {
		List<MessageBetweenUsers> messageList = this.entityManager
				.createNamedQuery("MessageBetweenUsers.findAllMessageReceivedByUser", MessageBetweenUsers.class).setParameter("useraccountid_param", id)
				.getResultList();
		return messageList;
	}
}
