package fr.isika.cda17.project3.model.solutionManagement;

public enum PaymentSystemChoice {

    NONE("None"), 
    MONETARY("Monetary"), 
    INTERNAL_CURRENCY("Internal currency")
    ;
	
	private String label;

	private PaymentSystemChoice(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
