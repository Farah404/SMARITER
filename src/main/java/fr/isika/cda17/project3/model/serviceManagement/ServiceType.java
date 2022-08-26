package fr.isika.cda17.project3.model.serviceManagement;

public enum ServiceType {

    CAR_POOLING("CarPooling"),
    CAR_RENTAL("CarRental"),
    PARCEL("Parcel"),
    PERSONAL_ASSISTANCE("PersonalAssistance");
	
	private String label;
	private ServiceType(String label) {
		this.label=label;
	}
	public String getLabel() {
		return label;
	}
    
}
