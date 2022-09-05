package fr.isika.cda17.project3.model.serviceManagement;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
	@NamedQuery(name = "PersonalAssistanceService.findAllUserPAS", query = "SELECT pas FROM PersonalAssistanceService pas WHERE pas.userAccountProvider.id = :userid_param"),
	@NamedQuery(name = "PersonalAssistanceService.findByReferenceNumber", query = "SELECT pas FROM PersonalAssistanceService pas WHERE pas.referenceNumber = :referencenumber_param")
})
public class PersonalAssistanceService extends Service {

    @Enumerated(EnumType.STRING)
    private PersonalAssistanceType personalAssistanceType;

    private boolean urgent;

    @OneToOne(cascade = CascadeType.ALL)
    private Trajectory trajectory;

    public PersonalAssistanceService() {
	super();
    }

    public PersonalAssistanceService(PersonalAssistanceType personalAssistanceType, boolean urgent,
	    Trajectory trajectory) {
	super();
	this.personalAssistanceType = personalAssistanceType;
	this.urgent = urgent;
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

    public Service withTrajectory(Trajectory trajectory) {
	this.trajectory = trajectory;
	return this;
    }
}
