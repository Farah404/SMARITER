package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.financialManagement.invoice.StoreInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.financialManagement.invoice.StoreInvoiceDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;

@ManagedBean
@ViewScoped
public class UserProfileBean implements Serializable {

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

    @Inject
    private StoreInvoiceDao storeInvoiceDao;
    
    @Inject
    private ServiceInvoiceDao serviceInvoiceDao;
    
    private User user;
    private List<CarPoolingService> cpsListUserRelated;
    private List<CarRentalService> crsListUserRelated;
    private List<ParcelService> psListUserRelated;
    private List<PersonalAssistanceService> pasListUserRelated;
    private List<StoreInvoice> userStoreInvoice;
    private List<ServiceInvoice> userServiceInvoiceWhenPurchaser;
    private List<ServiceInvoice> userServiceInvoiceWhenProvider;
    
    private String LabelServiceInvoice ="Facture de service";
    
    private String LabelStoreInvoice = "Facture d'EcoStore";
    
    public void init() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	System.out.println(id);
	if (id != null) {
	    user = userDao.findByUserAccountId(id);
	    cpsListUserRelated = carPoolingServiceDao.findAllUserCarPoolingServices(id);
	    crsListUserRelated = carRentalServiceDao.findAllUserCarRentalServices(id);
	    psListUserRelated = parcelServiceDao.findAllUserParcelServices(id);
	    pasListUserRelated = personnalAssistanceServiceDao.findAllUserPersonalAssistanceServices(id);
	    userStoreInvoice=storeInvoiceDao.findAllUserAccountStoreInvoice(user.getUserAccount().getId());
	    userServiceInvoiceWhenPurchaser=serviceInvoiceDao.findAllUserAccountPurchaserServiceInvoice(user.getUserAccount().getId());
	    userServiceInvoiceWhenProvider= serviceInvoiceDao.findAllUserAccountProviderServiceInvoice(user.getUserAccount().getId());
//	    System.out.println(cpsListUserRelated.isEmpty());
//	    System.out.println(crsListUserRelated.isEmpty());
//	    System.out.println(psListUserRelated.isEmpty());
//	    System.out.println(pasListUserRelated.isEmpty());
//	    System.out.println(id);
	    if (user == null) {
		System.out.println("not logical");
	    }
	} else {
	    System.out.println("id null");
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
    
    public String GoToServiceInvoice(Long id) {
    	return "subServiceInvoice.xhtml?faces-redirect=true&serviceInvoiceId="+id;
    }
    
    public String GoToStoreInvoice(Long id) {
    	return "subStoreInvoice.xhtml?faces-redirect=true&storeInvoiceId="+id;
    }

    public UserDao getUserDao() {
	return userDao;
    }

    public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
    }

    public String getLabelServiceInvoice() {
		return LabelServiceInvoice;
	}

	public void setLabelServiceInvoice(String labelServiceInvoice) {
		LabelServiceInvoice = labelServiceInvoice;
	}

	public String getLabelStoreInvoice() {
		return LabelStoreInvoice;
	}

	public void setLabelStoreInvoice(String labelStoreInvoice) {
		LabelStoreInvoice = labelStoreInvoice;
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

	public List<StoreInvoice> getUserStoreInvoice() {
		return userStoreInvoice;
	}

	public void setUserStoreInvoice(List<StoreInvoice> userStoreInvoice) {
		this.userStoreInvoice = userStoreInvoice;
	}

	public List<ServiceInvoice> getUserServiceInvoiceWhenPurchaser() {
		return userServiceInvoiceWhenPurchaser;
	}

	public void setUserServiceInvoiceWhenPurchaser(List<ServiceInvoice> userServiceInvoiceWhenPurchaser) {
		this.userServiceInvoiceWhenPurchaser = userServiceInvoiceWhenPurchaser;
	}

	public List<ServiceInvoice> getUserServiceInvoiceWhenProvider() {
		return userServiceInvoiceWhenProvider;
	}

	public void setUserServiceInvoiceWhenProvider(List<ServiceInvoice> userServiceInvoiceWhenProvider) {
		this.userServiceInvoiceWhenProvider = userServiceInvoiceWhenProvider;
	}
    
}