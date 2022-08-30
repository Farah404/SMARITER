package fr.isika.cda17.project3.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceType;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;

@ManagedBean
@ViewScoped
public class PersonalAssistanceServiceBean {
	
	@Inject
	private PersonalAssistanceServiceDao assistanceServiceDao;
	
	private PersonalAssistanceService assistanceService = new PersonalAssistanceService();
	
	private TrajectoryType trajectoryType;
	
	 private List<PersonalAssistanceService> personnalAssistanceServiceList;
	 
	 private PersonalAssistanceType personalAssistanceType;
	
	
	
	
	

	public PersonalAssistanceType[] personalAssistanceType() {
		return PersonalAssistanceType.values();
	}
	
	public TrajectoryType[] trajectoryType() {
		return TrajectoryType.values();
	}
	public PersonalAssistanceServiceDao getAssistanceServiceDao() {
		return assistanceServiceDao;
	}

	public void setAssistanceServiceDao(PersonalAssistanceServiceDao assistanceServiceDao) {
		this.assistanceServiceDao = assistanceServiceDao;
	}

	public PersonalAssistanceService getAssistanceService() {
		return assistanceService;
	}

	public void setAssistanceService(PersonalAssistanceService assistanceService) {
		this.assistanceService = assistanceService;
	}

	public TrajectoryType getTrajectoryType() {
		return trajectoryType;
	}

	public void setTrajectoryType(TrajectoryType trajectoryType) {
		this.trajectoryType = trajectoryType;
	}
	public List<PersonalAssistanceService> getPersonnalAssistanceServiceList() {
		return personnalAssistanceServiceList;
	}
	public void setPersonnalAssistanceServiceList(List<PersonalAssistanceService> personnalAssistanceServiceList) {
		this.personnalAssistanceServiceList = personnalAssistanceServiceList;
	}
	public PersonalAssistanceType getPersonalAssistanceType() {
		return personalAssistanceType;
	}
	public void setPersonalAssistanceType(PersonalAssistanceType personalAssistanceType) {
		this.personalAssistanceType = personalAssistanceType;
	}
	

}
