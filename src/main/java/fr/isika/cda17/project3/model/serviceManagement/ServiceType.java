package fr.isika.cda17.project3.model.serviceManagement;

public enum ServiceType {

    CAR_POOLING("Covoiturage"), CAR_RENTAL("Location de véhicule"), PARCEL("Transport de colis"), PERSONAL_ASSISTANCE("Aide à la personne");

    private String label;

    private ServiceType(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }

}