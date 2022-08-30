package fr.isika.cda17.project3.model.serviceManagement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda17.project3.model.personManagement.assets.Vehicule;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CarRentalService extends Service {
    
    private String keyPickUpAddress;
    
    private String keyDropOffAddress;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicule vehicule;
    
    @ManyToMany
    private List<CarRentalService>carRentalServiceList =new ArrayList<CarRentalService>();

    
    public CarRentalService() {
	super();
    }

    public CarRentalService(String keyPickUpAddress, String keyDropOffAddress, Vehicule vehicule) {
	super();
	this.keyPickUpAddress = keyPickUpAddress;
	this.keyDropOffAddress = keyDropOffAddress;
	this.vehicule = vehicule;
    }

    public String getKeyPickUpAddress() {
        return keyPickUpAddress;
    }

    public void setKeyPickUpAddress(String keyPickUpAddress) {
        this.keyPickUpAddress = keyPickUpAddress;
    }

    public String getKeyDropOffAddress() {
        return keyDropOffAddress;
    }

    public void setKeyDropOffAddress(String keyDropOffAddress) {
        this.keyDropOffAddress = keyDropOffAddress;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

	public List<CarRentalService> getCarRentalServiceList() {
		return carRentalServiceList;
	}

	public void setCarRentalServiceList(List<CarRentalService> carRentalServiceList) {
		this.carRentalServiceList = carRentalServiceList;
	}
    
    

}
