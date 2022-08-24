package fr.isika.cda17.project3.model.messagingManagement;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class HelpReport extends Report{
    
    @Enumerated
    private HelpReportType helpReportType;

    public HelpReport() {
	super();
    }

    public HelpReport(HelpReportType helpReportType) {
	super();
	this.helpReportType = helpReportType;
    }

    public HelpReportType getHelpReportType() {
        return helpReportType;
    }

    public void setHelpReportType(HelpReportType helpReportType) {
        this.helpReportType = helpReportType;
    }
    
    
    
    

}
