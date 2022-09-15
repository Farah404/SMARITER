package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.financialManagement.invoice.BankDetails;
import fr.isika.cda17.project3.model.financialManagement.invoice.BillingAddress;
import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.personManagement.accounts.AccountType;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.personManagement.assets.Insurance;
import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;

@ManagedBean
@SessionScoped
public class CreateUserBean implements Serializable {

    private static final long serialVersionUID = -8688644566487799148L;

    @Inject
    private UserDao userDao;

    private User user = new User();
    private UserAccount userAccount = new UserAccount();
    private BankDetails bankDetails = new BankDetails();
    private BillingAddress billingAddress = new BillingAddress();
    private ShoppingCart shoppingCart = new ShoppingCart();
    private Wallet wallet = new Wallet();
    private Vehicule vehicule = new Vehicule();
    private Insurance insurance = new Insurance();

    public String create() {
	userAccount.setBankDetails(bankDetails);
	userAccount.setBillingAddress(billingAddress);
	userAccount.setCreationDate(LocalDateTime.now());
	userAccount.setAccountType(AccountType.USER);
	userAccount.setShoppingCart(shoppingCart);
	userAccount.setWallet(wallet);
	userAccount.setIsActive(true);

	
	vehicule.setInsurance(insurance);
	userAccount.setVehicule(vehicule);
	user.setUserAccount(userAccount);
	User created = userDao.create(user);


	System.out.println(created);
	return "subIndex.xhtml";
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
	return "subIndex.xhtml?faces-redirect=true";
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

    public BankDetails getBankDetails() {
	return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
	this.bankDetails = bankDetails;
    }

    public BillingAddress getBillingAddress() {
	return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
	this.billingAddress = billingAddress;
    }

    public Vehicule getVehicule() {
	return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
	this.vehicule = vehicule;
    }

    public Insurance getInsurance() {
	return insurance;
    }

    public void setInsurance(Insurance insurance) {
	this.insurance = insurance;
    }

    public ShoppingCart getShoppingCart() {
	return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
	this.shoppingCart = shoppingCart;
    }

    public Wallet getWallet() {
	return wallet;
    }

    public void setWallet(Wallet wallet) {
	this.wallet = wallet;
    }

}
