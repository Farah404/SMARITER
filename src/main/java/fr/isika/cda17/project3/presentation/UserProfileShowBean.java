package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.messagingManagement.MessageBetweenUsers;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.repository.messagingManagement.MessageDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
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
	private UserAccountsDao userAccountDao;

	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;

	@Inject
	private CarRentalServiceDao carRentalServiceDao;

	@Inject
	private ParcelServiceDao parcelServiceDao;

	@Inject
	private PersonalAssistanceServiceDao personnalAssistanceServiceDao;

	@Inject
	private MessageDao messageDao;
	
	private MessageBetweenUsers message;
	private String messageContent = "";
	private String referenceNumber = "";
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

    public void sendMessage() {
    	Long serviceId = 1L;
    	UserAccount userAccountProvider = new UserAccount();
    	UserAccount userAccountSender = new UserAccount();
    	if(referenceNumber.contains("CP")==true) {
    		serviceId=carPoolingServiceDao.findByReferenceNumber(referenceNumber);
    		CarPoolingService cps = carPoolingServiceDao.findById(serviceId);
    		userAccountProvider = cps.getUserAccountProvider();
    	}
    	if(referenceNumber.contains("CR")==true) {
    		serviceId=carRentalServiceDao.findByReferenceNumber(referenceNumber);
    		CarRentalService crs = carRentalServiceDao.findById(serviceId);
    		userAccountProvider = crs.getUserAccountProvider();
    	}
    	if(referenceNumber.contains("PS")==true) {
    		serviceId=parcelServiceDao.findByReferenceNumber(referenceNumber);
    		ParcelService ps = parcelServiceDao.findById(serviceId);
    		userAccountProvider = ps.getUserAccountProvider();
    	}
    	if(referenceNumber.contains("PAS")==true) {
    		serviceId=personnalAssistanceServiceDao.findByReferenceNumber(referenceNumber);
    		PersonalAssistanceService pas = personnalAssistanceServiceDao.findById(serviceId);
    		userAccountProvider = pas.getUserAccountProvider();
    	}
    	
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	Long id = Long.valueOf(session.getAttribute("id").toString());
    	if (id != null) {
    	    userAccountSender = userAccountDao.findById(id);
    	}
    	
    	message = new MessageBetweenUsers()
    			.withSender(userAccountSender)
    			.withMessage(messageContent)
    			.withRelatedService(serviceId)
    			.withReceiver(userAccountProvider)
    			.withAppropriateReferenceNumber(referenceNumber);
    	
    	messageDao.create(message);
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



	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
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