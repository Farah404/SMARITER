package fr.isika.cda.project3.model.solutionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ParcelSolution {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private Boolean atypicalVolumeOption;
    
    private Boolean fragileOoption;
    
    private Boolean weightKilogrammesOption;

    public ParcelSolution() {
	super();
    }

    public ParcelSolution(Long id, Boolean atypicalVolumeOption, Boolean fragileOoption,
	    Boolean weightKilogrammesOption) {
	super();
	this.id = id;
	this.atypicalVolumeOption = atypicalVolumeOption;
	this.fragileOoption = fragileOoption;
	this.weightKilogrammesOption = weightKilogrammesOption;
    }

    public Boolean getAtypicalVolumeOption() {
        return atypicalVolumeOption;
    }

    public void setAtypicalVolumeOption(Boolean atypicalVolumeOption) {
        this.atypicalVolumeOption = atypicalVolumeOption;
    }

    public Boolean getFragileOoption() {
        return fragileOoption;
    }

    public void setFragileOoption(Boolean fragileOoption) {
        this.fragileOoption = fragileOoption;
    }

    public Boolean getWeightKilogrammesOption() {
        return weightKilogrammesOption;
    }

    public void setWeightKilogrammesOption(Boolean weightKilogrammesOption) {
        this.weightKilogrammesOption = weightKilogrammesOption;
    }

    public Long getId() {
        return id;
    }
    
}
