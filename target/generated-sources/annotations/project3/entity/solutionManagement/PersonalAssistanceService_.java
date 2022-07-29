package project3.entity.solutionManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonalAssistanceService.class)
public abstract class PersonalAssistanceService_ extends project3.entity.solutionManagement.Service_ {

	public static volatile SingularAttribute<PersonalAssistanceService, Boolean> isUrgent;
	public static volatile SingularAttribute<PersonalAssistanceService, PersonalAssistanceType> personalAssistanceType;
	public static volatile SingularAttribute<PersonalAssistanceService, Trajectory> trajectory;

}

