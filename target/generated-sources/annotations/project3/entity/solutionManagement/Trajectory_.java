package project3.entity.solutionManagement;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trajectory.class)
public abstract class Trajectory_ {

	public static volatile SingularAttribute<Trajectory, Integer> durationHours;
	public static volatile SingularAttribute<Trajectory, Integer> stopNumber;
	public static volatile SingularAttribute<Trajectory, TrajectoryType> trajectoryType;
	public static volatile SingularAttribute<Trajectory, Integer> stopDurationMinutes;
	public static volatile SingularAttribute<Trajectory, String> deliveryAddress;
	public static volatile SingularAttribute<Trajectory, String> pickUpAddress;
	public static volatile SingularAttribute<Trajectory, Itinerary> itinerary;
	public static volatile SingularAttribute<Trajectory, Long> id;

}

