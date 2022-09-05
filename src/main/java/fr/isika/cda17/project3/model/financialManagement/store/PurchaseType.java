package fr.isika.cda17.project3.model.financialManagement.store;

public enum PurchaseType {

    SUBSCRIPTION("Abonnement"),
    INTERNAL_CURRENCY("Monnaie interne");
	
	private String label;
	
	private PurchaseType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
