package fr.isika.cda17.project3.presentation;

import java.util.Optional;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda17.project3.model.personManagement.accounts.Account;
import fr.isika.cda17.project3.repository.personManagement.accounts.AccountDao;

public class LogInAccountBean {
    @NotEmpty(message = "Required")
    @NotNull(message = "Required")
    @Email
    private String email;
    
    @NotEmpty(message = "Required")
    @NotNull(message = "Required")
    private String password;
    
    @Inject
    private AccountDao accountDao;
    
    public String login() throws ServletException {
	Optional<Account> optional = accountDao.findByEmail(email);
	if (optional.isPresent()) {
	    Account account = optional.get();
	    if(account.getEmail().equals(email) && account.getPassword().equals(password)) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("id", account.getId());
		session.setAttribute("name", account.getUsername());
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public AccountDao getAccountDao() {
        return accountDao;
    }


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    
    
}
