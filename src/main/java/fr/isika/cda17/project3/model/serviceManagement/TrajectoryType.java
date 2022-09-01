package fr.isika.cda17.project3.model.serviceManagement;

public enum TrajectoryType {

    REGULAR("Régulier"), PUNCTUAL("Ponctuel");

    private String label;

    private TrajectoryType(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}
