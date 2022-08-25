//package fr.isika.cda17.project3.presentation;
//
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.Map;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//
//import fr.isika.cda17.project3.model.personManagement.accounts.Account;
//import fr.isika.cda17.project3.repository.personManagement.accounts.AccountDao;
//
//@ManagedBean
//@ViewScoped
//public class CreateAccountBean implements Serializable {
//
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	@Inject
//	private AccountDao accountDao;
//	
//	private Account account;
//	
//	public void init() throws IOException {
//	Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//	if (map.containsKey("accountId")) {
//		String accountIdParamValue = map.get("accountId");
//		System.err.println(accountIdParamValue);
//
//		if (!accountIdParamValue.isEmpty()) {
//			try {
//			Long id = Long.valueOf(accountIdParamValue);
//			account = accountDao.findById(id);
//
//			if (account == null) {
//				redirectError();
//			}
//			
//			} catch (NumberFormatException e) {
//				System.err.println("err : "+accountIdParamValue);
//				redirectError();
//			}
//
//		} else {
// 
//			redirectError();
//
//		}
//	}
//	}
//
//	
//	public void redirectError() throws IOException {
//		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//		ec.redirect("index.xhtml");
//	}
//
//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}
//	
//}
