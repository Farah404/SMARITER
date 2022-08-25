package fr.isika.cda17.project3.model.solutionManagement;

public enum MessagingSystemChoice {

    NONE("None"),
    SERVICE_RELATED_MESSAGING("Service related only"),
    NO_RESTRICTION_MESSAGING("Without restriction");
	
	private String label;
	
	private MessagingSystemChoice(String label) {
		this.label=label;
	}
    public String getLabel() {
		return label;
	}
}
