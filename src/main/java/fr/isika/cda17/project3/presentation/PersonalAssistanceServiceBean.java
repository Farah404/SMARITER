package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceType;
import fr.isika.cda17.project3.model.serviceManagement.TrajectoryType;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;

@ManagedBean
@ViewScoped
public class PersonalAssistanceServiceBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String LIST_PERSONALASSISTANCESERVICE_XHTML = "listPersonalAssistanceService.xhtml";
	
	@Inject
	private PersonalAssistanceServiceDao assistanceServiceDao;
	
	private PersonalAssistanceService personalAssistanceService = new PersonalAssistanceService();
	
	private TrajectoryType trajectoryType;
	
	 private List<PersonalAssistanceService> personnalAssistanceServiceList;
	 
	 private PersonalAssistanceType personalAssistanceType;
	
	
	 public void init() throws IOException {
			Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			
			if (map.containsKey("personalAssistanceServiceId")) {
				String personalAssistanceServiceIdParamValue = map.get("personalAssistanceServiceId");
				System.err.println(personalAssistanceServiceIdParamValue);
				if (personalAssistanceServiceIdParamValue != null && !personalAssistanceServiceIdParamValue.isBlank()) {
					Long id = Long.valueOf(personalAssistanceServiceIdParamValue);
					if(id != null) {
						personalAssistanceService = assistanceServiceDao.findById(id);
						if (personalAssistanceService == null) {
							redirectError();
						}
					} else {
						redirectError();
					}
				} else {
					redirectError();
				}
			}
		}
		public void redirectError() throws IOException {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(LIST_PERSONALASSISTANCESERVICE_XHTML);
		}
		public String updapte() {
			assistanceServiceDao.update(personalAssistanceService);
			System.out.println((personalAssistanceService));
			return LIST_PERSONALASSISTANCESERVICE_XHTML;
		}
		
		public String detail(Long id) {
			assistanceServiceDao.toString();
			
			return "detailAndBookingCarPoolingService.xhtml?faces-redirect=true&carPoolingServiceId=" + id;
		}
			
		private void refresh() {
			personnalAssistanceServiceList = assistanceServiceDao.findAll();

		}
		@PostConstruct
		public void freshinit() {
			refresh();
		}
		
		public String showUpdate(Long id) {
			System.err.println(id);
			return "editcarPoolingService.xhtml?faces-redirect=true&carPoolingServiceId=" + id;
		}
	
	

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
	public PersonalAssistanceService getPersonalAssistanceService() {
		return personalAssistanceService;
	}
	public void setPersonalAssistanceService(PersonalAssistanceService personalAssistanceService) {
		this.personalAssistanceService = personalAssistanceService;
	}
	

}
