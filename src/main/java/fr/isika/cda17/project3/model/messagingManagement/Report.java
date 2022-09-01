package fr.isika.cda17.project3.model.messagingManagement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Report {

    @Id
    @GeneratedValue
    private Long id;

    private Date reportIssueDate;

    private int reportReferenceNumber;

    private String reportContent;

    @ManyToOne
    private UserAccount userAccount;

    public Report() {
	super();
    }

    public Report(Long id, Date reportIssueDate, int reportReferenceNumber, String reportContent,
	    UserAccount userAccount) {
	super();
	this.id = id;
	this.reportIssueDate = reportIssueDate;
	this.reportReferenceNumber = reportReferenceNumber;
	this.reportContent = reportContent;
	this.userAccount = userAccount;
    }

    public Date getReportIssueDate() {
	return reportIssueDate;
    }

    public void setReportIssueDate(Date reportIssueDate) {
	this.reportIssueDate = reportIssueDate;
    }

    public int getReportReferenceNumber() {
	return reportReferenceNumber;
    }

    public void setReportReferenceNumber(int reportReferenceNumber) {
	this.reportReferenceNumber = reportReferenceNumber;
    }

    public String getReportContent() {
	return reportContent;
    }

    public void setReportContent(String reportContent) {
	this.reportContent = reportContent;
    }

    public UserAccount getUserAccount() {
	return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
	this.userAccount = userAccount;
    }

    public Long getId() {
	return id;
    }

}
