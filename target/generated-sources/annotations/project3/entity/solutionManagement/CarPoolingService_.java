package project3.entity.solutionManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.personManagement.Vehicule;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarPoolingService.class)
public abstract class CarPoolingService_ extends project3.entity.solutionManagement.Service_ {

	public static volatile SingularAttribute<CarPoolingService, Vehicule> vehicule;
	public static volatile SingularAttribute<CarPoolingService, Integer> availableSeats;
	public static volatile SingularAttribute<CarPoolingService, Boolean> isPetAllowed;
	public static volatile SingularAttribute<CarPoolingService, CarPoolingType> carPoolingType;
	public static volatile SingularAttribute<CarPoolingService, Boolean> isSmokingAllowed;
	public static volatile SingularAttribute<CarPoolingService, Boolean> isChattingAllowed;
	public static volatile SingularAttribute<CarPoolingService, Trajectory> trajectory;
	public static volatile SingularAttribute<CarPoolingService, Boolean> isMusicAllowed;

}

