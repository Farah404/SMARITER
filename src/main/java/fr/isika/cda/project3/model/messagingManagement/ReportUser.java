package fr.isika.cda.project3.model.messagingManagement;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ReportUser extends Report{
    
    @Enumerated
    private UserReportType userReportType;

    public ReportUser() {
	super();
    }

    public ReportUser(UserReportType userReportType) {
	super();
	this.userReportType = userReportType;
    }

    public UserReportType getUserReportType() {
        return userReportType;
    }

    public void setUserReportType(UserReportType userReportType) {
        this.userReportType = userReportType;
    }
    
    

}
