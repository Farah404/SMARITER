package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;

@ManagedBean
@SessionScoped
public class UserProfileManagementBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserDao userDao;

    private List<User> userList;

    @PostConstruct
    private void init() {
	refresh();
    }

    public String showUpdate(Long id) {

	System.err.println(id);

	return "subUserProfileByCustomer.xhtml?faces-redirect=true&userId=" + id;
    }

    private void refresh() {
	userList = userDao.findAll();
    }

    public void delete(Long id) {
	userDao.delete(id);
	refresh();
    }

    public List<User> getUserList() {
	return userList;
    }

    public void setUserList(List<User> userList) {
	this.userList = userList;
    }

}
