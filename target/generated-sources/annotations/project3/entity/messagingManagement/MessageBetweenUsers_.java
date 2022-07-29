package project3.entity.messagingManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.personManagement.UserAccount;
import project3.entity.solutionManagement.Service;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MessageBetweenUsers.class)
public abstract class MessageBetweenUsers_ {

	public static volatile SingularAttribute<MessageBetweenUsers, Service> service;
	public static volatile SingularAttribute<MessageBetweenUsers, UserAccount> userAccount;
	public static volatile SingularAttribute<MessageBetweenUsers, Long> id;
	public static volatile SingularAttribute<MessageBetweenUsers, String> messageContent;

}

