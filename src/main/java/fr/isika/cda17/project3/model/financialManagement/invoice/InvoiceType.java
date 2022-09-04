package fr.isika.cda17.project3.model.financialManagement.invoice;

public enum InvoiceType {

    STORE_INVOICE("Store invoice"),
    SERVICE_INVOICE("Service invoice"),
    CUSTOMER_INVOICE("Customer invoice");

	private String label;

	private InvoiceType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
