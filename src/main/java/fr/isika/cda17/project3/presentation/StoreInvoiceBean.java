package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.financialManagement.invoice.StoreInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.serviceManagement.ServiceType;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.financialManagement.invoice.StoreInvoiceDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class StoreInvoiceBean {
	@Inject
	private StoreInvoiceDao storeInvoiceDao;

	@Inject
	private UserDao userDao;

	private StoreInvoice storeInvoice;
	
	private User userPurchaser;
	
	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("storeInvoiceId")) {
			String storeInvoiceIdParamValue = map.get("storeInvoiceId");
			if (storeInvoiceIdParamValue != null && !storeInvoiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(storeInvoiceIdParamValue);
				if (id != null) {

					storeInvoice = storeInvoiceDao.findById(id);
					userPurchaser = userDao.findByUserAccountId(storeInvoice.getUserAccount().getId());
			}
			}
		}
	}

	public StoreInvoice getStoreInvoice() {
		return storeInvoice;
	}
	public User getUserPurchaser() {
		return userPurchaser;
	}
}
