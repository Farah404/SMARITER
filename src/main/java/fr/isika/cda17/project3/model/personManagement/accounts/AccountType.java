package fr.isika.cda17.project3.model.personManagement.accounts;

public enum AccountType {
    ADMINISTRATOR("Administrator"), ENTITY("Entity"), USER("User");

    private String label;

    private AccountType(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }

}
