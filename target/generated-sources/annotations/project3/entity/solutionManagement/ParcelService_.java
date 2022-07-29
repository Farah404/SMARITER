package project3.entity.solutionManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.personManagement.Vehicule;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ParcelService.class)
public abstract class ParcelService_ extends project3.entity.solutionManagement.Service_ {

	public static volatile SingularAttribute<ParcelService, Boolean> isAtypicalVolume;
	public static volatile SingularAttribute<ParcelService, Vehicule> vehicule;
	public static volatile SingularAttribute<ParcelService, Double> weightKilogrammes;
	public static volatile SingularAttribute<ParcelService, Boolean> isFragile;
	public static volatile SingularAttribute<ParcelService, Trajectory> trajectory;
	public static volatile SingularAttribute<ParcelService, Integer> barCode;

}

