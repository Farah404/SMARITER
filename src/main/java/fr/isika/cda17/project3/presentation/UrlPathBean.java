package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UrlPathBean implements Serializable{

    private static final long serialVersionUID = 1L;

    public String goToIndex() {
	return "index.xhtml?faces-redirect=true";
    }
    
    public String goToAbout() {
	return "about.xhtml?faces-redirect=true";
    }
    
    public String goToTeam() {
	return "team.xhtml?faces-redirect=true";
    }
    
    public String goToServices() {
	return "service.xhtml?faces-redirect=true";
    }
    
    public String goToPricing() {
	return "pricing.xhtml?faces-redirect=true";
    }
    
    public String goToBlog() {
	return "blog.xhtml?faces-redirect=true";
    }
    
    public String goToContact() {
	return "contactForm.xhtml?faces-redirect=true";
    }
    
    public String goToSignIn() {
	return "logInSignUp.xhtml?faces-redirect=true";
    }
}
