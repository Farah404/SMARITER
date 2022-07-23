package fr.isika.cda.project3.model.solutionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarPoolingSolution {

    @Id
    @GeneratedValue
    private Long id;
    
    private Boolean carPoolingTypeOption;
    
    private Boolean availableSeatsOption;

    private Boolean petAllowedOption;
    
    private Boolean smokingAllowedOption;
    
    private Boolean musicAllowedOption;
    
    private Boolean chattingAllowedOption;

    public CarPoolingSolution() {
	super();
    }

    public CarPoolingSolution(Long id, Boolean carPoolingTypeOption, Boolean availableSeatsOption,
	    Boolean petAllowedOption, Boolean smokingAllowedOption, Boolean musicAllowedOption,
	    Boolean chattingAllowedOption) {
	super();
	this.id = id;
	this.carPoolingTypeOption = carPoolingTypeOption;
	this.availableSeatsOption = availableSeatsOption;
	this.petAllowedOption = petAllowedOption;
	this.smokingAllowedOption = smokingAllowedOption;
	this.musicAllowedOption = musicAllowedOption;
	this.chattingAllowedOption = chattingAllowedOption;
    }

    public boolean isCarPoolingTypeOption() {
        return carPoolingTypeOption;
    }

    public void setCarPoolingTypeOption(Boolean carPoolingTypeOption) {
        this.carPoolingTypeOption = carPoolingTypeOption;
    }

    public boolean isAvailableSeatsOption() {
        return availableSeatsOption;
    }

    public void setAvailableSeatsOption(Boolean availableSeatsOption) {
        this.availableSeatsOption = availableSeatsOption;
    }

    public boolean isPetAllowedOption() {
        return petAllowedOption;
    }

    public void setPetAllowedOption(Boolean petAllowedOption) {
        this.petAllowedOption = petAllowedOption;
    }

    public boolean isSmokingAllowedOption() {
        return smokingAllowedOption;
    }

    public void setSmokingAllowedOption(Boolean smokingAllowedOption) {
        this.smokingAllowedOption = smokingAllowedOption;
    }

    public boolean isMusicAllowedOption() {
        return musicAllowedOption;
    }

    public void setMusicAllowedOption(Boolean musicAllowedOption) {
        this.musicAllowedOption = musicAllowedOption;
    }

    public boolean isChattingAllowedOption() {
        return chattingAllowedOption;
    }

    public void setChattingAllowedOption(Boolean chattingAllowedOption) {
        this.chattingAllowedOption = chattingAllowedOption;
    }

    public Long getId() {
        return id;
    }
    
}
