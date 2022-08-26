package fr.isika.cda17.project3.presentation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;
import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;

import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;

import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;

@ManagedBean
@SessionScoped
public class CreateUserBean {

	/**
	*
	*/
	private static final long serialVersionUID = -8688644566487799148L;

	@Inject
	private UserDao userDao;

	private User user = new User();
	private UserAccount userAccount = new UserAccount();
	private BankDetails bankDetails = new BankDetails();
	private BillingAddress billingAddress = new BillingAddress();
	private List<User> userList;

	/**
	 * methodes
	 */

	public void create() {

		User created = userDao.create(user);
		System.out.println(created);
	}

	public String createStepOne() {
		userAccount.setBankDetails(bankDetails);
		userAccount.setBillingAddress(billingAddress);
		userAccount.setCreationDate(LocalDateTime.now());
		userAccount.setAccountType(AccountType.USER);

		userAccount.setIsActive(true);
		userAccount.setProfilePicturePath("media/gif/profilePictures/ProfileGif8.gif");
		user.setUserAccount(getUserAccount());
		userDao.create(user);
		System.err.println(user.getId());
		return "signUp2.xhtml?faces-redirect=true&userId=" + user.getId();
	}

	public String update() {
		userDao.update(user);
		System.out.println(user);
		return "index.xhtml?faces-redirect=true";
	}

	public void init() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (map.containsKey("userId")) {
			String userIdParamValue = map.get("userId");
			Long id = Long.valueOf(userIdParamValue);
			if (id != null) {
				user = userDao.findById(id);
			} else {
				System.err.println("no userId on page");
				return;
			}
		}
	}
	
	public String showUpdate(Long id) {
		
		System.err.println(id);
		
		return "signUp2.xhtml?faces-redirect=true&userId=" + id;
	}
	

	
	public void delete(Long id) {
		userDao.delete(id);
		refresh();
	}
	
	private void refresh() {
		userList = userDao.findAll();
	}

	/**
	 * getter et setters
	 */

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<User> getListUser() {
		return userList;
	}

	public void setListUser(List<User> listUser) {
		this.userList = listUser;
	}
}
