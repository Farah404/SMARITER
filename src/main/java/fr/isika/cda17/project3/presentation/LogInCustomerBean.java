package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.repository.personManagement.accounts.EntityAccountDao;

@ManagedBean
@SessionScoped
public class LogInCustomerBean implements Serializable {
    
    private static final long serialVersionUID = -11574855474L;
    
    @NotEmpty(message = "Required")
    @NotNull(message = "Required")
    @Email
    private String name;
    
    @NotEmpty(message = "Required")
    @NotNull(message = "Required")
    private String password;
    
    @Inject
    private EntityAccountDao entityAccountDao;
    
    public String customerLogin() throws ServletException {
	Optional<EntityAccount> optional = entityAccountDao.findByName(name);
	if (optional.isPresent()) {
	    EntityAccount account = optional.get();
	    if(account.getName().equals(name) && account.getPassword().equals(password)) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("id", account.getId());
		session.setAttribute("name", account.getName());
		System.out.println("LoginBean.customerLogin(): "+ session.getAttribute("name"));
		return "index?faces-redirect=true";
	    }
	    else {
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
    
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
