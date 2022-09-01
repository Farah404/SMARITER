package fr.isika.cda17.project3.model.messagingManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.Service;

@Entity
public class MessageBetweenUsers {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserAccount userAccount;

    @OneToOne
    private Service service;

    private String messageContent;

    public MessageBetweenUsers() {
	super();
    }

    public MessageBetweenUsers(Long id, UserAccount userAccount, Service service, String messageContent) {
	super();
	this.id = id;
	this.userAccount = userAccount;
	this.service = service;
	this.messageContent = messageContent;
    }

    public UserAccount getUserAccount() {
	return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
	this.userAccount = userAccount;
    }

    public Service getService() {
	return service;
    }

    public void setService(Service service) {
	this.service = service;
    }

    public String getMessageContent() {
	return messageContent;
    }

    public void setMessageContent(String messageContent) {
	this.messageContent = messageContent;
    }

    public Long getId() {
	return id;
    }

}
