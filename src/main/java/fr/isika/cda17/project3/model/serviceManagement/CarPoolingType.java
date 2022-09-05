package fr.isika.cda17.project3.model.serviceManagement;

public enum CarPoolingType {
    HOME_TO_WORK("Domicile - Travail"), HOME_TO_SCHOOL("Domicile - Ecole"), EVENTS("Evénements"), TRAVEL("Voyage");

    private String label;

    private CarPoolingType(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}