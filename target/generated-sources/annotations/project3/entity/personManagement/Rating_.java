package project3.entity.personManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.solutionManagement.Service;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rating.class)
public abstract class Rating_ {

	public static volatile SingularAttribute<Rating, Service> service;
	public static volatile SingularAttribute<Rating, UserAccount> userAccount;
	public static volatile SingularAttribute<Rating, String> comment;
	public static volatile SingularAttribute<Rating, Long> id;

}

