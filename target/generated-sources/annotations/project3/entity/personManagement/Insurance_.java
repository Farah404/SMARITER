package project3.entity.personManagement;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Insurance.class)
public abstract class Insurance_ {

	public static volatile SingularAttribute<Insurance, String> insuranceContractNumber;
	public static volatile SingularAttribute<Insurance, String> insuranceAgencyName;
	public static volatile SingularAttribute<Insurance, Long> id;
	public static volatile SingularAttribute<Insurance, Date> insuranceContractExpiration;

}

