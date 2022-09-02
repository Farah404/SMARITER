package fr.isika.cda17.project3.model.solutionManagement;

public enum TemplateChoice {
	BASIC("Basic"), ZEN("Zen"), PORTFOLIO("Portfolio"),MINIMALIST("Minimalist");

    private String label;

    private TemplateChoice(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}
