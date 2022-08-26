package fr.isika.cda17.project3.model.serviceManagement;

public enum CarPoolingType {
    
    HOME_TO_WORK("HomeToWork"),
    HOME_TO_SCHOOL("HomeToSchool"),
    EVENTS("Events"),
    TRAVEL("Travel");
    
    private String label;
	private CarPoolingType(String label) {
		this.label=label;
	}
	public String getLabel() {
		return label;
	}
}
