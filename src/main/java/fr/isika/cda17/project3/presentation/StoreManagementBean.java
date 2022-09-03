package fr.isika.cda17.project3.presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.store.Store;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.repository.financialManagement.store.StoreDao;
import fr.isika.cda17.project3.repository.financialManagement.store.WalletDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;

@ManagedBean
@ViewScoped
public class StoreManagementBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Store ecoStore = new Store();

    private Wallet wallet;

    private UserAccount userAccount;

    @Inject
    StoreDao storeDao;

    @Inject
    private UserAccountsDao userAccountsDao;

    @Inject
    private WalletDao walletDao;

//    public void createStore() {
//	ecoStore.setMonthlySubscriptionName("Mensuel");
//	ecoStore.setMonthlySubscriptionPrice(15);
//	ecoStore.setMonthlySubscriptionQuantity(30);
//	ecoStore.setTrimestrialSubscriptionName("Trimestriel");
//	ecoStore.setTrimestrialSubscriptionPrice(45);
//	ecoStore.setTrimestrialSubscriptionQuantity(30);
//	ecoStore.setSemestrialSubscriptionName("Semestriel");
//	ecoStore.setSemestrialSubscriptionPrice(80);
//	ecoStore.setSemestrialSubscriptionQuantity(30);
//    }

    public void purchaseBatchOne() {

	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	userAccount = userAccountsDao.findById(id);
	wallet = walletDao.findById(userAccount.getWallet().getId());
	double oldAmount = wallet.getInternalCurrencyAmount();
	ecoStore.setBatchOneName("Lot EcoLeaf");
	ecoStore.setBatchOnePrice(10);
	ecoStore.setBatchOneQuantity(15);
	storeDao.create(ecoStore);
	double newAmount = oldAmount + ecoStore.getBatchOneQuantity();
	System.out.println(newAmount);
	wallet.setInternalCurrencyAmount(newAmount);
	walletDao.update(wallet);
    }

    public void purchaseBatchTwo() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	System.out.println(id);
	userAccount = userAccountsDao.findById(id);
	wallet = walletDao.findById(userAccount.getWallet().getId());
	ecoStore.setBatchTwoName("Lot EcoTree");
	ecoStore.setBatchTwoPrice(20);
	ecoStore.setBatchTwoQuantity(35);
	storeDao.create(ecoStore);
	double oldAmount = wallet.getInternalCurrencyAmount();
	System.out.println(oldAmount);
	double newAmount = oldAmount + ecoStore.getBatchTwoQuantity();
	System.out.println(newAmount);
	wallet.setInternalCurrencyAmount(newAmount);
	walletDao.update(wallet);
    }

    public void purchaseBatchThree() {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = Long.valueOf(session.getAttribute("id").toString());
	System.out.println(id);
	userAccount = userAccountsDao.findById(id);
	wallet = walletDao.findById(userAccount.getWallet().getId());
	ecoStore.setBatchThreeName("Lot EcoForest");
	ecoStore.setBatchThreePrice(30);
	ecoStore.setBatchThreeQuantity(50);
	storeDao.create(ecoStore);
	double oldAmount = wallet.getInternalCurrencyAmount();
	System.out.println(oldAmount);
	double newAmount = oldAmount + ecoStore.getBatchThreeQuantity();
	System.out.println(newAmount);
	wallet.setInternalCurrencyAmount(newAmount);
	walletDao.update(wallet);
    }

}
