package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.User;
import fr.isika.cda17.project3.model.solutionManagement.Solution;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserDao;
import fr.isika.cda17.project3.repository.solutionManagement.SolutionDao;

@ManagedBean
@ViewScoped
public class ServiceInvoiceBean {
	@Inject
	private ServiceInvoiceDao serviceInvoiceDao;

	@Inject
	private UserDao userDao;
	
	private ServiceInvoice serviceInvoice;
	
	private User userPurchaser;
	
	private User userProvider;
	
//	private LocalDate dueDate;
//	
//	private LocalDate stampDate;

	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("serviceInvoiceId")) {
			String serviceInvoiceIdParamValue = map.get("serviceInvoiceId");
			if (serviceInvoiceIdParamValue != null && !serviceInvoiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(serviceInvoiceIdParamValue);
				if (id != null) {

					serviceInvoice = serviceInvoiceDao.findById(id);
					userPurchaser = userDao.findByUserAccountId(serviceInvoice.getUserAccountPurchaser().getId());
					userProvider = userDao.findByUserAccountId(serviceInvoice.getUserAccountProvider().getId());
					
				}
			}
		}
	}


}
