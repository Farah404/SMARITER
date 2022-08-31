package fr.isika.cda17.project3.presentation;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.CarPoolingService;
import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.repository.financialManagement.invoice.ServiceInvoiceDao;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.CarPoolingServiceDao;

@ManagedBean
@SessionScoped
public class ReservationBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    	@Inject
	private UserAccountsDao userAccontDao;

	@Inject
	private ServiceInvoiceDao serviceInvoiceDao;

	@Inject
	private CarPoolingServiceDao carPoolingServiceDao;

	private Reservation reservation = new Reservation();
	private ServiceInvoice serviceInvoice = new ServiceInvoice();

	private CarPoolingService carPooling = new CarPoolingService();
	private UserAccount user;
	
	public void create(long id) {

		carPooling = carPoolingServiceDao.findById(id);

		reservation.setService(carPooling);
		serviceInvoice.setService(carPooling);
		// TODO : pour contourner on utilise l'email qui sera remplacé par l'id plus
		// tard une fois le login/logout mergé
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String email = (String) session.getAttribute("email");
		
		
		if(email != null && !email.isBlank()) {
			Optional<UserAccount> optional = userAccontDao.findByEmail(email);
			if(optional.isPresent()) {
				serviceInvoice.setUserAccount(optional.get());
				
				if (carPooling.getAvailableSeats() > 0) {
					// reservationDao.create(reservation);
		
					reservation.setServiceinvoice(serviceInvoiceDao.create(serviceInvoice));
					carPooling.getReservations().add(reservation);
					carPooling.setAvailableSeats(carPooling.getAvailableSeats() - 1);
		
					carPoolingServiceDao.update(carPooling);
					System.out.println(reservation.getId());
		
				} else {
					System.out.println("reservation failed, no seats available");
				}
			} else {
				System.out.println("reservation failed, no user with email : " + email);
			}
		} else {
			System.out.println("reservation failed, email unknown : " + email);
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
    
    