package fr.isika.cda17.project3.model.solutionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParcelSolution {

    @Id
    @GeneratedValue
    private Long id;

    private boolean atypicalVolumeOption;

    private boolean fragileOoption;

    private boolean weightKilogrammesOption;

    public ParcelSolution() {
	super();
    }

    public ParcelSolution(Long id, boolean atypicalVolumeOption, boolean fragileOoption,
	    boolean weightKilogrammesOption) {
	super();
	this.id = id;
	this.atypicalVolumeOption = atypicalVolumeOption;
	this.fragileOoption = fragileOoption;
	this.weightKilogrammesOption = weightKilogrammesOption;
    }

    public boolean getAtypicalVolumeOption() {
	return atypicalVolumeOption;
    }

    public void setAtypicalVolumeOption(boolean atypicalVolumeOption) {
	this.atypicalVolumeOption = atypicalVolumeOption;
    }

    public boolean getFragileOoption() {
	return fragileOoption;
    }

    public void setFragileOoption(boolean fragileOoption) {
	this.fragileOoption = fragileOoption;
    }

    public boolean getWeightKilogrammesOption() {
	return weightKilogrammesOption;
    }

    public void setWeightKilogrammesOption(boolean weightKilogrammesOption) {
	this.weightKilogrammesOption = weightKilogrammesOption;
    }

    public Long getId() {
	return id;
    }

}
