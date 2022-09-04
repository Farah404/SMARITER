package fr.isika.cda17.project3.repository.financialManagement.invoice;

import java.util.List;

import fr.isika.cda17.project3.model.financialManagement.invoice.ServiceInvoice;
import fr.isika.cda17.project3.repository.Dao;

public interface ServiceInvoiceDao extends Dao<ServiceInvoice> {
	String ServiceInvoiceNumber();

	List<ServiceInvoice> findAllUserAccountProviderServiceInvoice(Long id);

	List<ServiceInvoice> findAllUserAccountPurchaserServiceInvoice(Long id);
}
