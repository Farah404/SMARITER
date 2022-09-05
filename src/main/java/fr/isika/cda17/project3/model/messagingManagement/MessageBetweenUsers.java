package fr.isika.cda17.project3.model.messagingManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.Service;

@Entity
@NamedQuery(name = "MessageBetweenUsers.findAllMessageReceivedByUser", query = "SELECT m FROM MessageBetweenUsers m WHERE m.userAccountReceiver.id = :useraccountid_param")
public class MessageBetweenUsers {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private UserAccount userAccountSender;
    
    @OneToOne
    private UserAccount userAccountReceiver;

    private Long serviceId;

    private String messageContent;

    private String referenceNumberConcerned;
    
    public MessageBetweenUsers() {
	super();
    }
    public MessageBetweenUsers(Long id, UserAccount userAccountSender, UserAccount userAccountReceiver, Long serviceId,
			String messageContent, String referenceNumberConcerned) {
		super();
		this.id = id;
		this.userAccountSender = userAccountSender;
		this.userAccountReceiver = userAccountReceiver;
		this.serviceId = serviceId;
		this.messageContent = messageContent;
		this.referenceNumberConcerned = referenceNumberConcerned;
	}

	public String getReferenceNumberConcerned() {
		return referenceNumberConcerned;
	}
	public void setReferenceNumberConcerned(String referenceNumberConcerned) {
		this.referenceNumberConcerned = referenceNumberConcerned;
	}
	public UserAccount getUserAccountSender() {
		return userAccountSender;
	}

	public void setUserAccountSender(UserAccount userAccountSender) {
		this.userAccountSender = userAccountSender;
	}

	public UserAccount getUserAccountReceiver() {
		return userAccountReceiver;
	}

	public void setUserAccountReceiver(UserAccount userAccountReceiver) {
		this.userAccountReceiver = userAccountReceiver;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
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

	public MessageBetweenUsers withMessage(final String message) {
    	this.messageContent=message;
    	return this;
    }
    
    public MessageBetweenUsers withSender(final UserAccount userAccountSending) {
    	this.userAccountSender= userAccountSending;
    	return this;
    }
    
    public MessageBetweenUsers withReceiver(final UserAccount userAccountReceiving) {
    	this.userAccountReceiver= userAccountReceiving;
    	return this;
    }
    
    public MessageBetweenUsers withRelatedService(final Long relatedServiceId) {
    	this.serviceId= relatedServiceId;
    	return this;
    }
    
    public MessageBetweenUsers withAppropriateReferenceNumber(final String referenceNumber) {
    	this.referenceNumberConcerned=referenceNumber;
    	return this;
    }
}
