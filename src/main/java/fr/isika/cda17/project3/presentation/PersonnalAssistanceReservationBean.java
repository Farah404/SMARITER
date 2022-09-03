package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.PersonalAssistanceService;
import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.financialManagement.store.WalletDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.PersonalAssistanceServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ReservationDao;

@ManagedBean
@ViewScoped
public class PersonnalAssistanceReservationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -933564076831708579L;
	private static final String SERVICE_LIST_XHTML = "subServiceList.xhtml";

	@Inject
	private PersonalAssistanceServiceDao personalAssistanceServiceDao;
	@Inject
	private ReservationDao reservationDao;

	@Inject
	private UserAccountsDao userAccountDao;

	@Inject
	private ServiceInvoiceDao serviceInvoiceDao;
	@Inject
	private WalletDao walletDao;

	private PersonalAssistanceService personalAssistanceService;
	private Reservation reservation;
	private ServiceInvoice serviceInvoice;
	private UserAccount userAccountPurchaser;
	private UserAccount userAccountProvider;
	private Wallet walletProvider;
	private Wallet walletPurchaser;

	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("personalAssistanceServiceId")) {
			String personalAssistanceServiceIdParamValue = map.get("personalAssistanceServiceId");
			System.err.println(personalAssistanceServiceIdParamValue);
			if (personalAssistanceServiceIdParamValue != null && !personalAssistanceServiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(personalAssistanceServiceIdParamValue);
				if (id != null) {
					personalAssistanceService = personalAssistanceServiceDao.findById(id);
					if (personalAssistanceService == null) {
						redirectError();
					}
				} else {
					redirectError();
				}
			} else {
				redirectError();
			}
		}
	}

	public void redirectError() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(SERVICE_LIST_XHTML);
	}

	public String reservation() throws IOException {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("id");
		userAccountPurchaser = userAccountDao.findById(id);
		userAccountProvider = userAccountDao.findById(personalAssistanceService.getUserAccountProvider().getId());
		walletPurchaser = walletDao.findById(userAccountPurchaser.getWallet().getId());
		walletProvider = walletDao.findById(userAccountProvider.getWallet().getId());

		if (userAccountPurchaser.getWallet().getInternalCurrencyAmount() >= personalAssistanceService.getPrice()) {
			int ref = serviceInvoiceDao.findAll().size() + 1;
			String invoiceNumber = "2022INV-" + ref + "-SMTR";

			walletPurchaser.withSubstractedValue(personalAssistanceService.getPrice());
			walletProvider.withAddedValue(personalAssistanceService.getPrice());

			serviceInvoice = (ServiceInvoice) new ServiceInvoice()
					.withService(personalAssistanceService)
					.withUserAccountProvider(personalAssistanceService.getUserAccountProvider())
					.withUserAccountPurchaser(userAccountPurchaser)
					.withServiceInvoiceType()
					.withIssueDate()
					.withInvoiceNumber(invoiceNumber);

			reservation = new Reservation()
					.withService(personalAssistanceService)
					.withServiceInvoice(serviceInvoice);

			personalAssistanceService.withReservation(reservation).withUnavailable(true);
			walletDao.update(walletProvider);
			walletDao.update(walletPurchaser);
			serviceInvoiceDao.create(serviceInvoice);
			reservationDao.create(reservation);
			personalAssistanceServiceDao.update(personalAssistanceService);

			return "subServiceInvoice.xhtml?faces-redirect=true&serviceInvoiceId=" + serviceInvoice.getId();
		} else {
			return "subStore.xhtml";
		}
	}

	public ServiceInvoice getServiceInvoice() {
		return serviceInvoice;
	}

	public void setServiceInvoice(ServiceInvoice serviceInvoice) {
		this.serviceInvoice = serviceInvoice;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public PersonalAssistanceService getPersonalAssistanceService() {
		return personalAssistanceService;
	}

	public void setPersonalAssistanceService(PersonalAssistanceService personalAssistanceService) {
		this.personalAssistanceService = personalAssistanceService;
	}

}
