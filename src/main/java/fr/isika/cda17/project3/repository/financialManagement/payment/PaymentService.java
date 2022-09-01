package fr.isika.cda17.project3.repository.financialManagement.payment;

import fr.isika.cda17.project3.model.personManagement.accounts.Customer;
import fr.isika.cda17.project3.model.solutionManagement.Solution;

public interface PaymentService {
    
    public String createCustomer(Customer customer);
    public void chargeCreditCard(Solution solution);

}
