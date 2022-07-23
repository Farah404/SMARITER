package fr.isika.cda.project3.model.solutionManagement;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda.project3.model.personManagement.Vehicule;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ParcelService extends Service{
    
    private int barCode;
    
    private double weightKilogrammes;
    
    private Boolean isAtypicalVolume;
    
    private Boolean isFragile;
    
    @OneToOne
    private Vehicule vehicule;
    
    @OneToOne
    private Trajectory trajectory;

    public ParcelService() {
	super();
    }

    public ParcelService(int barCode, double weightKilogrammes, Boolean isAtypicalVolume, Boolean isFragile,
	    Vehicule vehicule, Trajectory trajectory) {
	super();
	this.barCode = barCode;
	this.weightKilogrammes = weightKilogrammes;
	this.isAtypicalVolume = isAtypicalVolume;
	this.isFragile = isFragile;
	this.vehicule = vehicule;
	this.trajectory = trajectory;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public double getWeightKilogrammes() {
        return weightKilogrammes;
    }

    public void setWeightKilogrammes(double weightKilogrammes) {
        this.weightKilogrammes = weightKilogrammes;
    }

    public Boolean getIsAtypicalVolume() {
        return isAtypicalVolume;
    }

    public void setIsAtypicalVolume(Boolean isAtypicalVolume) {
        this.isAtypicalVolume = isAtypicalVolume;
    }

    public Boolean getIsFragile() {
        return isFragile;
    }

    public void setIsFragile(Boolean isFragile) {
        this.isFragile = isFragile;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(Trajectory trajectory) {
        this.trajectory = trajectory;
    }
    

}
