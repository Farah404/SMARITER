package project3.entity.solutionManagement;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class PersonalAssistanceService extends Service {
    
    @Enumerated
    private PersonalAssistanceType personalAssistanceType;
    
    private Boolean isUrgent;
    
    @OneToOne
    private Trajectory trajectory;

    public PersonalAssistanceService() {
	super();
    }

    public PersonalAssistanceService(PersonalAssistanceType personalAssistanceType, Boolean isUrgent,
	    Trajectory trajectory) {
	super();
	this.personalAssistanceType = personalAssistanceType;
	this.isUrgent = isUrgent;
	this.trajectory = trajectory;
    }

    public PersonalAssistanceType getPersonalAssistanceType() {
        return personalAssistanceType;
    }

    public void setPersonalAssistanceType(PersonalAssistanceType personalAssistanceType) {
        this.personalAssistanceType = personalAssistanceType;
    }

    public Boolean getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(Boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(Trajectory trajectory) {
        this.trajectory = trajectory;
    }
    

}
