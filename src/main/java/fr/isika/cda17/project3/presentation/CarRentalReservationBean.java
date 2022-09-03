package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
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
import fr.isika.cda17.project3.model.serviceManagement.CarRentalService;
import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.financialManagement.store.WalletDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarRentalServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ReservationDao;

@ManagedBean
@ViewScoped
public class CarRentalReservationBean implements Serializable{

	/**
	 * 
	 */
	
	private static final String LIST_CARRENTALSERVICE_XHTML = "listCarRentalService.xhtml";
	private static final long serialVersionUID = -1025290862154591864L;

	@Inject
	private CarRentalServiceDao carRentalServiceDao;
	
	@Inject
	private UserAccountsDao userAccountDao;
  
	@Inject
	private ReservationDao reservationDao;
	
	@Inject
	private ServiceInvoiceDao serviceInvoiceDao;
	@Inject 
	private WalletDao walletDao;
	
	
	private Reservation reservation;
	private ServiceInvoice serviceInvoice;
	
	private CarRentalService carRental;
	private UserAccount userAccountPurchaser;
	private UserAccount userAccountProvider;
	private Wallet walletProvider;
	private Wallet walletPurchaser;

	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if (map.containsKey("carRentalServiceId")) {
			String carRentalServiceIdParamValue = map.get("carRentalServiceId");
			System.err.println(carRentalServiceIdParamValue);
			if (carRentalServiceIdParamValue != null && !carRentalServiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(carRentalServiceIdParamValue);
				if(id != null) {
					carRental = carRentalServiceDao.findById(id);
					if (carRental == null) {
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
		ec.redirect(LIST_CARRENTALSERVICE_XHTML);
	}
	
public String reservation() throws IOException {
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	Long id = (Long) session.getAttribute("id");
	userAccountPurchaser = userAccountDao.findById(id);
	userAccountProvider = userAccountDao.findById(carRental.getUserAccountProvider().getId());
	walletPurchaser = walletDao.findById(userAccountPurchaser.getWallet().getId());
	walletProvider = walletDao.findById(userAccountProvider.getWallet().getId());
	
	if(userAccountPurchaser.getWallet().getInternalCurrencyAmount() >= carRental.getPrice()) {
		int ref = serviceInvoiceDao.findAll().size() + 1;
		String invoiceNumber = "2022INV-" + ref + "-SMTR";
		
		walletPurchaser.withSubstractedValue(carRental.getPrice());
		walletProvider.withAddedValue(carRental.getPrice());

		serviceInvoice = (ServiceInvoice) new ServiceInvoice()
				.withService(carRental)
				.withUserAccountProvider(carRental.getUserAccountProvider())
				.withUserAccountPurchaser(userAccountPurchaser)
				.withServiceInvoiceType()
				.withIssueDate()
				.withInvoiceNumber(invoiceNumber);
		
		reservation = new Reservation()
				.withService(carRental)
				.withServiceInvoice(serviceInvoice);

		carRental.withReservation(reservation).withUnavailable(true);
		walletDao.update(walletProvider);
		walletDao.update(walletPurchaser);
		serviceInvoiceDao.create(serviceInvoice);
		reservationDao.create(reservation);
		carRentalServiceDao.update(carRental);
		
		return "subServiceInvoice.xhtml?faces-redirect=true&serviceInvoiceId="+serviceInvoice.getId();
	}
	else {
		return "subStore.xhtml";
	}
	
//		System.out.println("DEBUT CREATION");
//
//		reservation.setService(carRental);
//		serviceInvoice.setService(carRental);
//		
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//		String email = (String) session.getAttribute("email");
//		
//		System.out.println(carRental);
//		if(email != null && !email.isBlank()) {
//			
//			Optional<UserAccount> optional = userAccountDao.findByEmail(email);
//			if(optional.isPresent()) {
//				serviceInvoice.setUserAccountProvider(user);
//				
//				reservation.setServiceinvoice(serviceInvoice);
//				
//				carRental.withReservation(reservation).withUnavailable(true);
//				
//				reservationDao.create(reservation);
//				carRentalServiceDao.update(carRental);
//				
//					
//				System.out.println("reservation : "+reservation.getId());
//	
//			} else {
//				System.out.println("reservation failed, no user with email : " + email);
//			}
//		
//		} else {
//			System.out.println("reservation failed, email unknown : " + email);
//		}
//		System.out.println("FIN CREATION");
	}
	
	
	
	
	
  /**
   * 
    getters et setters
   */




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



	public CarRentalService getCarRental() {
		return carRental;
	}
	public void setCarRental(CarRentalService carRental) {
		this.carRental = carRental;
	}
}
