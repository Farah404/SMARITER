package fr.isika.cda17.project3.model.solutionManagement;

public enum PriceDeal {

    BUSINESS_VIP("Business VIP"), BUSINESS_UNLIMITED("Business Unlimited"), BUSINESS_BASIC("Business Basic");

    private String label;

    private PriceDeal(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }

}
