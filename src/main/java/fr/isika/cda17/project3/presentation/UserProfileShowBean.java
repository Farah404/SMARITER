package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
public class UserProfileShowBean implements Serializable {

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

    private User user;
    
    private List<CarPoolingService> cpsListUserRelated;
    private List<CarRentalService> crsListUserRelated;
    private List<ParcelService> psListUserRelated;
    private List<PersonalAssistanceService> pasListUserRelated;

    public void init() {
    	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

    	if (map.containsKey("userId")) {
    	    String userIdCartIdParamValue = map.get("userId");
    	    if (userIdCartIdParamValue != null && !userIdCartIdParamValue.isBlank()) {
    		Long id = Long.valueOf(userIdCartIdParamValue);
    		user = userDao.findByUserAccountId(id);
    		cpsListUserRelated = carPoolingServiceDao.findAllUserCarPoolingServices(id);
    	    crsListUserRelated = carRentalServiceDao.findAllUserCarRentalServices(id);
    	    psListUserRelated = parcelServiceDao.findAllUserParcelServices(id);
    	    pasListUserRelated = personnalAssistanceServiceDao.findAllUserPersonalAssistanceServices(id);
    	    } 
    	}
    }

    public String updateStepOne() {
	return "subUpdateUserProfile.xhtml?faces-redirect=true";
    }

    public String update() {
	userDao.update(user);
	System.out.println(user);
	return "subUserProfilePersonal.xhtml?faces-redirect=true";
    }

    public UserDao getUserDao() {
	return userDao;
    }

    public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
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