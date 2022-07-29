package project3.entity.financialManagement;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Invoice.class)
public abstract class Invoice_ {

	public static volatile SingularAttribute<Invoice, Date> invoiceIssueDate;
	public static volatile SingularAttribute<Invoice, Integer> invoiceNumber;
	public static volatile SingularAttribute<Invoice, InvoiceType> invoiceType;
	public static volatile SingularAttribute<Invoice, Long> id;

}

