package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.store.ShoppingCart;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.repository.financialManagement.store.ShoppingCartDao;
import fr.isika.cda17.project3.repository.financialManagement.store.StoreDao;
import fr.isika.cda17.project3.repository.financialManagement.store.WalletDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;

@ManagedBean
@ViewScoped
public class ShoppingCartManagementBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ShoppingCart shoppingCart = new ShoppingCart();

    private Wallet wallet;

    private UserAccount userAccount;

    @Inject
    StoreDao storeDao;

    @Inject
    private UserAccountsDao userAccountsDao;

    @Inject
    private WalletDao walletDao;

    @Inject
    private ShoppingCartDao shoppingCartDao;

    public void init() throws IOException {

	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

	if (map.containsKey("shoppingCartId")) {
	    String shoppingCartIdParamValue = map.get("shoppingCartId");
	    if (shoppingCartIdParamValue != null && !shoppingCartIdParamValue.isBlank()) {
		Long id = Long.valueOf(shoppingCartIdParamValue);
		if (id != null) {
		    shoppingCart = shoppingCartDao.findById(id);

		} else {

		}
	    } else {

	    }
	}
    }

    public String purchaseButton() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	wallet = walletDao.findById(userAccount.getWallet().getId());
	shoppingCart = shoppingCartDao.findById(userAccount.getShoppingCart().getId());
	double oldEcoCoinsAmount = wallet.getInternalCurrencyAmount();
	double newEcoCoinsAmount = oldEcoCoinsAmount + shoppingCart.getBatchOneQuantity()
		+ shoppingCart.getBatchTwoQuantity() + shoppingCart.getBatchThreeQuantity()
		+ shoppingCart.getMonthlySubscriptionQuantity() + shoppingCart.getTrimestrialSubscriptionQuantity()
		+ shoppingCart.getSemestrialSubscriptionQuantity();
	wallet.setInternalCurrencyAmount(newEcoCoinsAmount);
	walletDao.update(wallet);
	
	return "subPaymentForm.xhtml?faces-redirect=true&shoppingCartId=" + shoppingCart.getId();
    }

    public ShoppingCart getShoppingCart() {
	return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
	this.shoppingCart = shoppingCart;
    }

}
