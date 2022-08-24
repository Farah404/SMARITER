package fr.isika.cda17.project3.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.isika.cda17.project3.model.solutionManagement.PaymentSystemChoice;

@ManagedBean
@RequestScoped
public class PaymentSystemChoiceBean {

	
	public PaymentSystemChoice[] paymentChoice() {
		return PaymentSystemChoice.values();
	}	
	
}
