package fr.isika.cda17.project3.repository.messagingManagement;

import java.util.List;

import fr.isika.cda17.project3.model.messagingManagement.MessageBetweenUsers;
import fr.isika.cda17.project3.repository.Dao;

public interface MessageDao extends Dao<MessageBetweenUsers>{

	List<MessageBetweenUsers> findAllMessageReceivedByUser(Long id);

}
