package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;

@ManagedBean
@ViewScoped
public class UserProfileByCustomerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserDao userDao;
    
    @Inject
    private CarPoolingServiceDao carPoolingServiceDao;
    
    @Inject
    private CarRentalServiceDao carRentalServiceDao;
    
    @Inject
    private ParcelServiceDao parcelServiceDao;
    
    @Inject
    private PersonalAssistanceServiceDao personnalAssistanceServiceDao;
    
    private List<CarPoolingService> cpsListUserRelated;
    private List<CarRentalService> crsListUserRelated;
    private List<ParcelService> psListUserRelated;
    private List<PersonalAssistanceService> pasListUserRelated;
    private User user;
    private String formatDateCreation;
    
    public void init() throws IOException {
    	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

    	if (map.containsKey("userId")) {
    	    String userIdParamValue = map.get("userId");
    	    System.err.println(userIdParamValue);
    	    if (userIdParamValue != null && !userIdParamValue.isBlank()) {
    		Long id = Long.valueOf(userIdParamValue);
    		if (id != null) {

    		    user = userDao.findById(id);
    		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    		    formatDateCreation = user.getUserAccount().getCreationDate().format(formatter);
    		    
    		    cpsListUserRelated = carPoolingServiceDao.findAllUserCarPoolingServices(user.getUserAccount().getId());
    		    crsListUserRelated = carRentalServiceDao.findAllUserCarRentalServices(user.getUserAccount().getId());
    		    psListUserRelated = parcelServiceDao.findAllUserParcelServices(user.getUserAccount().getId());
    		    pasListUserRelated = personnalAssistanceServiceDao.findAllUserPersonalAssistanceServices(user.getUserAccount().getId());
    		    if (user == null) {
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
    	ec.redirect("customerProfile.xhtml");
        }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public String getFormatDateCreation() {
		return formatDateCreation;
	}

	public void setFormatDateCreation(String formatDateCreation) {
		this.formatDateCreation = formatDateCreation;
	}

	public List<CarPoolingService> getCpsListUserRelated() {
		return cpsListUserRelated;
	}

	public void setCpsListUserRelated(List<CarPoolingService> cpsListUserRelated) {
		this.cpsListUserRelated = cpsListUserRelated;
	}

	public List<CarRentalService> getCrsListUserRelated() {
		return crsListUserRelated;
	}

	public void setCrsListUserRelated(List<CarRentalService> crsListUserRelated) {
		this.crsListUserRelated = crsListUserRelated;
	}

	public List<ParcelService> getPsListUserRelated() {
		return psListUserRelated;
	}

	public void setPsListUserRelated(List<ParcelService> psListUserRelated) {
		this.psListUserRelated = psListUserRelated;
	}

	public List<PersonalAssistanceService> getPasListUserRelated() {
		return pasListUserRelated;
	}

	public void setPasListUserRelated(List<PersonalAssistanceService> pasListUserRelated) {
		this.pasListUserRelated = pasListUserRelated;
	}
    
}