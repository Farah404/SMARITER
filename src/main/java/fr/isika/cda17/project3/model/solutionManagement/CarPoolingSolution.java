package fr.isika.cda17.project3.model.solutionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CarPoolingSolution {

    @Id
    @GeneratedValue
    private Long id;

    private boolean carPoolingTypeOption;

    private boolean availableSeatsOption;

    private boolean petAllowedOption;

    private boolean smokingAllowedOption;

    private boolean musicAllowedOption;

    private boolean chattingAllowedOption;

    public CarPoolingSolution() {
	super();
    }

    public CarPoolingSolution(Long id, boolean carPoolingTypeOption, boolean availableSeatsOption,
	    boolean petAllowedOption, boolean smokingAllowedOption, boolean musicAllowedOption,
	    boolean chattingAllowedOption) {
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

    public void setCarPoolingTypeOption(boolean carPoolingTypeOption) {
	this.carPoolingTypeOption = carPoolingTypeOption;
    }

    public boolean isAvailableSeatsOption() {
	return availableSeatsOption;
    }

    public void setAvailableSeatsOption(boolean availableSeatsOption) {
	this.availableSeatsOption = availableSeatsOption;
    }

    public boolean isPetAllowedOption() {
	return petAllowedOption;
    }

    public void setPetAllowedOption(boolean petAllowedOption) {
	this.petAllowedOption = petAllowedOption;
    }

    public boolean isSmokingAllowedOption() {
	return smokingAllowedOption;
    }

    public void setSmokingAllowedOption(boolean smokingAllowedOption) {
	this.smokingAllowedOption = smokingAllowedOption;
    }

    public boolean isMusicAllowedOption() {
	return musicAllowedOption;
    }

    public void setMusicAllowedOption(boolean musicAllowedOption) {
	this.musicAllowedOption = musicAllowedOption;
    }

    public boolean isChattingAllowedOption() {
	return chattingAllowedOption;
    }

    public void setChattingAllowedOption(boolean chattingAllowedOption) {
	this.chattingAllowedOption = chattingAllowedOption;
    }

    public Long getId() {
	return id;
    }

}
