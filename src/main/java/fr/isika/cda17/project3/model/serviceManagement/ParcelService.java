package fr.isika.cda17.project3.model.serviceManagement;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ParcelService extends Service{
    
    private int barCode;
    
    private double weightKilogrammes;
    
    private boolean atypicalVolume;
    
    private boolean fragile;
    
    @OneToOne
    private Vehicule vehicule;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Trajectory trajectory;

    public ParcelService() {
	super();
    }

    public ParcelService(int barCode, double weightKilogrammes, boolean isAtypicalVolume, boolean isFragile,
	    Vehicule vehicule, Trajectory trajectory) {
	super();
	this.barCode = barCode;
	this.weightKilogrammes = weightKilogrammes;
	this.atypicalVolume = isAtypicalVolume;
	this.fragile = isFragile;
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

	public boolean isAtypicalVolume() {
		return atypicalVolume;
	}

	public void setAtypicalVolume(boolean atypicalVolume) {
		this.atypicalVolume = atypicalVolume;
	}

	public boolean isFragile() {
		return fragile;
	}

	public void setFragile(boolean fragile) {
		this.fragile = fragile;
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
