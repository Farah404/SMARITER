package fr.isika.cda17.project3.model.personManagement.assets;

public enum VehiculePowerType {

    ELECTRIC("Electrique"), HYBRID("Hybride"), DIESEL("Diesel"), PETROL("Pétrole");
    
    private String label;
    
    private VehiculePowerType(String label) {
	this.label = label;
    }
    
    public String getLabel() {
	return label;
    }

}
