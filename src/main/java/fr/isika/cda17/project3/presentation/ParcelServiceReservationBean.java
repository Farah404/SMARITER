package fr.isika.cda17.project3.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.model.personManagement.accounts.UserAccount;
import fr.isika.cda17.project3.model.serviceManagement.ParcelService;
import fr.isika.cda17.project3.model.serviceManagement.Reservation;
import fr.isika.cda17.project3.repository.personManagement.accounts.UserAccountsDao;
import fr.isika.cda17.project3.repository.serviceManagement.ParcelServiceDao;
import fr.isika.cda17.project3.repository.serviceManagement.ReservationDao;

@ManagedBean
@SessionScoped
public class ParcelServiceReservationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SERVICE_LIST_XHTML = "subServiceList.xhtml";

	@Inject
	private ParcelServiceDao parcelServiceDao;
	
	@Inject
	private ReservationDao reservationDao;

	@Inject
	private UserAccountsDao userAccontDao;

	private ParcelService parcelService = new ParcelService();

	private Reservation reservation = new Reservation();
	private ServiceInvoice serviceInvoice = new ServiceInvoice();

	public void init() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

		if (map.containsKey("parcelServiceId")) {
			String parcelServiceIdParamValue = map.get("parcelServiceId");
			System.err.println(parcelServiceIdParamValue);
			if (parcelServiceIdParamValue != null && !parcelServiceIdParamValue.isBlank()) {
				Long id = Long.valueOf(parcelServiceIdParamValue);
				if (id != null) {

					parcelService = parcelServiceDao.findById(id);
					if (parcelService == null) {
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

	public void reservation() {

		System.out.println("starting reservation creation");

		reservation.setService(parcelService);
		serviceInvoice.setService(parcelService);

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		String email = (String) session.getAttribute("email");

		if (email != null && !email.isBlank()) {

			Optional<UserAccount> optional = userAccontDao.findByEmail(email);
			if (optional.isPresent()) {
				serviceInvoice.setUserAccount(optional.get());

				reservation.setServiceinvoice(serviceInvoice);
				parcelService.getReservations().add(reservation);
                reservationDao.create(reservation);
                parcelService.setUnavailable(true);
				parcelServiceDao.update(parcelService);
				System.out.println("reservation : " + reservation.getId());

			} else {
				System.out.println("reservation failed, no user with email : " + email);
			}

		} else {
			System.out.println("reservation failed, email unknown : " + email);
		}
		System.out.println("ending reservation creation");
	}

	public ParcelService getParcelService() {
		return parcelService;
	}

	public void setParcelService(ParcelService parcelService) {
		this.parcelService = parcelService;
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

}
