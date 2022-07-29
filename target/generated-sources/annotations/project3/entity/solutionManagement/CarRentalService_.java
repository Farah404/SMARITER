package project3.entity.solutionManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.personManagement.Vehicule;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CarRentalService.class)
public abstract class CarRentalService_ extends project3.entity.solutionManagement.Service_ {

	public static volatile SingularAttribute<CarRentalService, String> keyPickUpAddress;
	public static volatile SingularAttribute<CarRentalService, Vehicule> vehicule;
	public static volatile SingularAttribute<CarRentalService, String> keyDropOffAddress;

}

