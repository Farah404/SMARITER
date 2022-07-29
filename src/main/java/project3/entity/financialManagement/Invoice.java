package project3.entity.financialManagement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public abstract class Invoice {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private int invoiceNumber;
    
    private Date invoiceIssueDate;
    
    @Enumerated
    private InvoiceType invoiceType;

    public Invoice() {
	super();
    }

    public Invoice(Long id, int invoiceNumber, Date invoiceIssueDate, InvoiceType invoiceType) {
	super();
	this.id = id;
	this.invoiceNumber = invoiceNumber;
	this.invoiceIssueDate = invoiceIssueDate;
	this.invoiceType = invoiceType;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceIssueDate() {
        return invoiceIssueDate;
    }

    public void setInvoiceIssueDate(Date invoiceIssueDate) {
        this.invoiceIssueDate = invoiceIssueDate;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Long getId() {
        return id;
    }
    
}
