package fr.isika.cda17.project3.model.serviceManagement;

public enum PersonalAssistanceType {

    MEDICAL("Medical"), GROCERY("Grocery");

    private String label;

    private PersonalAssistanceType(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}
