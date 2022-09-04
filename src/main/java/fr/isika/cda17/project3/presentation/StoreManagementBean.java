package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.repository.financialManagement.store.ShoppingCartDao;
import fr.isika.cda17.project3.repository.financialManagement.store.StoreDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;

@ManagedBean
@ViewScoped
public class StoreManagementBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    StoreDao storeDao;

    @Inject
    private UserAccountsDao userAccountsDao;

    @Inject
    private ShoppingCartDao shoppingCartDao;

    private UserAccount userAccount;
    
    private ShoppingCart shoppingCart = new ShoppingCart();

    public String addBatchOneToCart() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	shoppingCart = shoppingCartDao.findById(userAccount.getShoppingCart().getId());
	shoppingCart.setBatchOneName("Lot EcoLeaf");
	shoppingCart.setBatchOnePrice(10);
	shoppingCart.setBatchOneQuantity(15);
	shoppingCart.setBoughtBatchOneQuantity(1);
	double toBePaidEurosAmount = shoppingCart.getBatchOnePrice() + shoppingCart.getBatchTwoPrice()
	+ shoppingCart.getBatchThreePrice() + shoppingCart.getMonthlySubscriptionPrice()
	+ shoppingCart.getTrimestrialSubscriptionPrice() + shoppingCart.getSemestrialSubscriptionPrice();
	shoppingCart.setToBePaidEurosAmount(toBePaidEurosAmount);
	shoppingCartDao.update(shoppingCart);
	return "subShoppingCart.xhtml?faces-redirect=true&shoppingCartId=" + shoppingCart.getId();
    }

    public String addBatchTwoToCart() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	shoppingCart = shoppingCartDao.findById(userAccount.getShoppingCart().getId());
	shoppingCart.setBatchTwoName("Lot EcoTree");
	shoppingCart.setBatchTwoPrice(20);
	shoppingCart.setBatchTwoQuantity(35);
	shoppingCart.setBoughtBatchTwoQuantity(1);
	double toBePaidEurosAmount = shoppingCart.getBatchOnePrice() + shoppingCart.getBatchTwoPrice()
	+ shoppingCart.getBatchThreePrice() + shoppingCart.getMonthlySubscriptionPrice()
	+ shoppingCart.getTrimestrialSubscriptionPrice() + shoppingCart.getSemestrialSubscriptionPrice();
	shoppingCart.setToBePaidEurosAmount(toBePaidEurosAmount);
	shoppingCartDao.update(shoppingCart);
	return "subShoppingCart.xhtml?faces-redirect=true&shoppingCartId=" + shoppingCart.getId();
    }

    public String addBatchThreeToCart() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	shoppingCart = shoppingCartDao.findById(userAccount.getShoppingCart().getId());
	shoppingCart.setBatchThreeName("Lot EcoForest");
	shoppingCart.setBatchThreePrice(30);
	shoppingCart.setBatchThreeQuantity(50);
	shoppingCart.setBoughtBatchThreeQuantity(1);
	double toBePaidEurosAmount = shoppingCart.getBatchOnePrice() + shoppingCart.getBatchTwoPrice()
	+ shoppingCart.getBatchThreePrice() + shoppingCart.getMonthlySubscriptionPrice()
	+ shoppingCart.getTrimestrialSubscriptionPrice() + shoppingCart.getSemestrialSubscriptionPrice();
	shoppingCart.setToBePaidEurosAmount(toBePaidEurosAmount);
	shoppingCartDao.update(shoppingCart);
	return "subShoppingCart.xhtml?faces-redirect=true&shoppingCartId=" + shoppingCart.getId();
    }

    public String addMonthlySubscriptionToCart() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	shoppingCart = shoppingCartDao.findById(userAccount.getShoppingCart().getId());
	shoppingCart.setMonthlySubscriptionName("Mensuel");
	shoppingCart.setMonthlySubscriptionPrice(15);
	shoppingCart.setMonthlySubscriptionQuantity(30);
	shoppingCart.setBoughtMonthlySubscriptionQuantity(1);
	double toBePaidEurosAmount = shoppingCart.getBatchOnePrice() + shoppingCart.getBatchTwoPrice()
	+ shoppingCart.getBatchThreePrice() + shoppingCart.getMonthlySubscriptionPrice()
	+ shoppingCart.getTrimestrialSubscriptionPrice() + shoppingCart.getSemestrialSubscriptionPrice();
	shoppingCart.setToBePaidEurosAmount(toBePaidEurosAmount);
	shoppingCartDao.update(shoppingCart);
	return "subShoppingCart.xhtml?faces-redirect=true&shoppingCartId=" + shoppingCart.getId();
    }

    public String addTrimestrialSubscriptionToCart() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	shoppingCart = shoppingCartDao.findById(userAccount.getShoppingCart().getId());
	shoppingCart.setTrimestrialSubscriptionName("Trimestriel");
	shoppingCart.setTrimestrialSubscriptionPrice(45);
	shoppingCart.setTrimestrialSubscriptionQuantity(30);
	shoppingCart.setTrimestrialSubscriptionQuantity(1);
	double toBePaidEurosAmount = shoppingCart.getBatchOnePrice() + shoppingCart.getBatchTwoPrice()
	+ shoppingCart.getBatchThreePrice() + shoppingCart.getMonthlySubscriptionPrice()
	+ shoppingCart.getTrimestrialSubscriptionPrice() + shoppingCart.getSemestrialSubscriptionPrice();
	shoppingCart.setToBePaidEurosAmount(toBePaidEurosAmount);
	shoppingCartDao.update(shoppingCart);
	return "subShoppingCart.xhtml?faces-redirect=true&shoppingCartId=" + shoppingCart.getId();
    }

    public String addSemestrialSubscriptionToCart() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	shoppingCart = shoppingCartDao.findById(userAccount.getShoppingCart().getId());
	shoppingCart.setSemestrialSubscriptionName("Semestriel");
	shoppingCart.setSemestrialSubscriptionPrice(80);
	shoppingCart.setSemestrialSubscriptionPrice(1);
	double toBePaidEurosAmount = shoppingCart.getBatchOnePrice() + shoppingCart.getBatchTwoPrice()
	+ shoppingCart.getBatchThreePrice() + shoppingCart.getMonthlySubscriptionPrice()
	+ shoppingCart.getTrimestrialSubscriptionPrice() + shoppingCart.getSemestrialSubscriptionPrice();
	shoppingCart.setToBePaidEurosAmount(toBePaidEurosAmount);
	shoppingCartDao.update(shoppingCart);
	return "subShoppingCart.xhtml?faces-redirect=true&shoppingCartId=" + shoppingCart.getId();
    }

}
