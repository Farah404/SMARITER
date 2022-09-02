package fr.isika.cda17.project3.model.solutionManagement;

public enum PriceDeal {

    BUSINESS_VIP("Business VIP", 400 ), BUSINESS_UNLIMITED("Business Unlimited",300), BUSINESS_BASIC("Business Basic",150);

    private String label;
    private double amount;

    private PriceDeal(String label, double amount) {
	this.label = label;
	this.amount= amount;
    }

    public String getLabel() {
	return label;
    }

	public double getAmount() {
		return amount;
	}

    
}
