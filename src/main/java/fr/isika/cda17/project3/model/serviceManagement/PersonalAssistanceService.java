package fr.isika.cda17.project3.model.serviceManagement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class PersonalAssistanceService extends Service {
    
    @Enumerated(EnumType.STRING)
    private PersonalAssistanceType personalAssistanceType;
    
    private Boolean isUrgent;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Trajectory trajectory;
    
    @OneToMany
    private List<PersonalAssistanceService> personnalAssistanceServiceList = new ArrayList<PersonalAssistanceService>();

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

	public List<PersonalAssistanceService> getPersonnalAssistanceServiceList() {
		return personnalAssistanceServiceList;
	}

	public void setPersonnalAssistanceServiceList(List<PersonalAssistanceService> personnalAssistanceServiceList) {
		this.personnalAssistanceServiceList = personnalAssistanceServiceList;
	}
    

}
