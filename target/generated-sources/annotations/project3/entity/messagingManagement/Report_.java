package project3.entity.messagingManagement;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import project3.entity.personManagement.UserAccount;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Report.class)
public abstract class Report_ {

	public static volatile SingularAttribute<Report, Integer> reportReferenceNumber;
	public static volatile SingularAttribute<Report, String> reportContent;
	public static volatile SingularAttribute<Report, UserAccount> userAccount;
	public static volatile SingularAttribute<Report, Long> id;
	public static volatile SingularAttribute<Report, Date> reportIssueDate;

}

