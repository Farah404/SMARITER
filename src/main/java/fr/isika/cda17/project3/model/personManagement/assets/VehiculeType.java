package fr.isika.cda17.project3.model.personManagement.assets;

public enum VehiculeType {

    AUTOMATIC("Automatique"), MANUAL("Manuelle");
    
    private String label;

    private VehiculeType(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}
