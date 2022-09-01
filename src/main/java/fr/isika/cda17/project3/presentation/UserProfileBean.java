package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;

@ManagedBean
@ViewScoped
public class UserProfileBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserDao userDao;
    private User user;

    public void init() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	System.out.println(id);
	if (id != null) {
	    user = userDao.findByUserAccountId(id);
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

}