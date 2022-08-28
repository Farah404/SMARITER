package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


import fr.isika.cda17.project3.model.personManagement.accounts.AdministratorAccount;
import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.repository.personManagement.accounts.AdministratorDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.EntityAccountDao;

@ManagedBean
@SessionScoped
public class LogInAccountBean implements Serializable {
	 private static final long serialVersionUID = -11574855474L;

    @NotEmpty(message = "Required")
    @NotNull(message = "Required")
    @Email
    private String email;
    
    @NotEmpty(message = "Required")
    @NotNull(message = "Required")
    private String password;
       
    private String sessionAccountId;
    
    @Inject
    private EntityAccountDao entityAccountDao;
    
    @Inject
    private AdministratorDao administratorDao;
    

	public String accountLogin() throws ServletException {
	Optional<EntityAccount> optional = entityAccountDao.findByEmail(email);
	Optional<AdministratorAccount> optional1 = administratorDao.findByEmail(email);
	if (optional.isPresent()) {
		
	    EntityAccount account = optional.get();
	    if(account.getEmail().equals(email) && account.getPassword().equals(password)) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("id", account.getId());
		session.setAttribute("email", account.getEmail());
		sessionAccountId=session.getAttribute("id").toString();
		System.out.println("LoginBean.accountLogin(): "+ session.getAttribute("email"));
		return "index?faces-redirect=true";
	     }
		    else {
		System.out.println("Wrong authentification");
	    }
		
	}
	if (optional1.isPresent()){
    	 AdministratorAccount administratorAccount = optional1.get();
	    if(administratorAccount.getEmail().equals(email) && administratorAccount.getPassword().equals(password)) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("id", administratorAccount.getId());
		session.setAttribute("email", administratorAccount.getEmail());
		sessionAccountId=session.getAttribute("id").toString();
		System.out.println("LoginBean.accountLogin(): "+ session.getAttribute("email"));
		return "index?faces-redirect=true";
	       
		}else {
		System.out.println("Wrong authentification");
	    }
	    
	}
	else {
	    System.out.println("Wrong authentification");
	}
	return "logInSignUp";
    }
	
    
    
    public void logout() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	// vider la session des infos mémorisées
	session.invalidate();
	
	// TODO : redirect to index plus tard
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSessionAccountId() {
		return sessionAccountId;
	}
}