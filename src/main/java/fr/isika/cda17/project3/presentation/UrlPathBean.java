package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;

@ManagedBean
@ViewScoped
public class UrlPathBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String goToIndex() {
	return "index.xhtml";
    }

    public String goToAbout() {
	return "about.xhtml";
    }

    public String goToTeam() {
	return "team.xhtml";
    }

    public String goToServices() {
	return "service.xhtml";
    }

    public String goToPricing() {
	return "pricing.xhtml";
    }

    public String goToBlog() {
	return "blog.xhtml";
    }

    public String goToContact() {
	return "contactForm.xhtml";
    }

    public String goToSignIn() {
	return "logInSignUp.xhtml";
    }

    public String goToPatterns() {
	return "patterns.xhtml";
    }

    public String goToOnlineStore() {
	return "onlineStore.xhtml";
    }

    public String goToBookings() {
	return "bookings.xhtml";
    }

    public String goToInvestors() {
	return "partners.xhtml";
    }

    public String goToTermsOfUse() {
	return "termsOfUse.xhtml";
    }

    public String goToSiteMap() {
	return "siteMap.xhtml";
    }
    
    public String goToPaymentForm() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	if (session.getAttribute("accountType") == AccountType.ADMINISTRATOR
		|| session.getAttribute("accountType") == AccountType.ENTITY) {
	    return "paymentForm.xhtml";
	} else {
	    return "logInSignUp.xhtml";
	}
    }

    public String goToStartService() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	if (session.getAttribute("accountType") == AccountType.ADMINISTRATOR
		|| session.getAttribute("accountType") == AccountType.ENTITY) {
	    return "service.xhtml";
	} else {
	    return "logInSignUp.xhtml";
	}
    }

    public String goToDashBoard() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	if (session.getAttribute("accountType") == AccountType.ADMINISTRATOR) {
	    return "adminBoard.xhtml";
	} else {
	    if (session.getAttribute("accountType") == AccountType.ENTITY) {
		return "customerProfile.xhtml";
	    } else {
		return "index.xhtml";
	    }
	}
    }
    
    public String goToUserProfile(Long id) {
		return "subUserProfile.xhtml?faces-redirect=true&userId="+id;
	}
}
