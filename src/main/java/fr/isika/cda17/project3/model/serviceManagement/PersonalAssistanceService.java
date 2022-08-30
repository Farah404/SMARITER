package fr.isika.cda17.project3.model.serviceManagement;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class PersonalAssistanceService extends Service {
    
    @Enumerated
    private PersonalAssistanceType personalAssistanceType;
    
    private boolean urgent;
    
    @OneToOne
    private Trajectory trajectory;

    public PersonalAssistanceService() {
	super();
    }

    public PersonalAssistanceService(PersonalAssistanceType personalAssistanceType, boolean isUrgent,
	    Trajectory trajectory) {
	super();
	this.personalAssistanceType = personalAssistanceType;
	this.urgent = isUrgent;
	this.trajectory = trajectory;
    }

    public PersonalAssistanceType getPersonalAssistanceType() {
        return personalAssistanceType;
    }

    public void setPersonalAssistanceType(PersonalAssistanceType personalAssistanceType) {
        this.personalAssistanceType = personalAssistanceType;
    }

    
    public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public Trajectory getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(Trajectory trajectory) {
        this.trajectory = trajectory;
    }
    

}
