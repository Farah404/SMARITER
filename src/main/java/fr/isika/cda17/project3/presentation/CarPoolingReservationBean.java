package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.financialManagement.store.Wallet;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.financialManagement.store.WalletDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ReservationDao;

@ManagedBean
@ViewScoped
public class CarPoolingReservationBean implements Serializable {

	private static final String SERVICE_LIST_XHTML = "subServiceList.xhtml";

	private static final long serialVersionUID = -1025290862154591864L;

	@Inject
	private UserAccountsDao userAccountDao;
	@Inject
	private ReservationDao reservationDao;

	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;

	@Inject
	private ServiceInvoiceDao serviceInvoiceDao;
	@Inject
	private WalletDao walletDao;

	private Reservation reservation;
	private ServiceInvoice serviceInvoice;
	private Wallet walletProvider;

	private Wallet walletPurchaser;
	private UserAccount userAccountPurchaser;
	private UserAccount userAccountProvider;
	private CarPoolingService carPooling;
	private UserAccount user = new UserAccount();

	public void init() throws IOException {
		System.out.println("starting reservation bean");

		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("carPoolingServiceId")) {
			String carPoolingServiceIdParamValue = map.get("carPoolingServiceId");
			System.err.println("carPoolingServiceIdParamValue : " + carPoolingServiceIdParamValue);
			if (carPoolingServiceIdParamValue != null && !carPoolingServiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(carPoolingServiceIdParamValue);
				if (id != null) {
					carPooling = carPoolingServiceDao.findById(id);
					if (carPooling == null) {
						redirectError();
					}
					System.out.println(carPooling);

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

	public String reservation() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = (Long) session.getAttribute("id");
		userAccountPurchaser = userAccountDao.findById(id);
		userAccountProvider = userAccountDao.findById(carPooling.getUserAccountProvider().getId());
		walletPurchaser = walletDao.findById(userAccountPurchaser.getWallet().getId());
		walletProvider = walletDao.findById(userAccountProvider.getWallet().getId());

		if (userAccountPurchaser.getWallet().getInternalCurrencyAmount() >= carPooling.getPrice()) {
			int ref = serviceInvoiceDao.findAll().size() + 1;
			String invoiceNumber = "2022INV-" + ref + "-SMTR";
			if (carPooling.getAvailableSeats() > 0) {

				walletPurchaser.withSubstractedValue(carPooling.getPrice());
				walletProvider.withAddedValue(carPooling.getPrice());
				serviceInvoice = (ServiceInvoice) new ServiceInvoice().withService(carPooling)
						.withUserAccountProvider(carPooling.getUserAccountProvider())
						.withUserAccountPurchaser(userAccountPurchaser).withServiceInvoiceType().withIssueDate()
						.withInvoiceNumber(invoiceNumber);

				reservation = new Reservation().withService(carPooling).withServiceInvoice(serviceInvoice);

				walletDao.update(walletProvider);
				walletDao.update(walletPurchaser);
				serviceInvoiceDao.create(serviceInvoice);
				reservationDao.create(reservation);

				if (carPooling.getAvailableSeats() > 1) {
					carPooling.setAvailableSeats(carPooling.getAvailableSeats() - 1);
					carPooling.withReservation(reservation);
					carPoolingServiceDao.update(carPooling);
				} else {
					carPooling.setAvailableSeats(carPooling.getAvailableSeats() - 1);
					carPooling.withReservation(reservation).withUnavailable(true);
					carPoolingServiceDao.update(carPooling);
				}
			} else {
				return "subServiceList.xhtml";
			}
			return "subServiceInvoice.xhtml?faces-redirect=true&serviceInvoiceId=" + serviceInvoice.getId();
		} else {
			return "subStore.xhtml";
		}
	}

	public CarPoolingService getCarPooling() {
		return carPooling;
	}

	public void setCarPooling(CarPoolingService carPooling) {
		this.carPooling = carPooling;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public ServiceInvoice getServiceInvoice() {
		return serviceInvoice;
	}

	public void setServiceInvoice(ServiceInvoice serviceInvoice) {
		this.serviceInvoice = serviceInvoice;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

}
