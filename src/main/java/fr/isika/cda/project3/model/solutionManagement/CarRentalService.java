package fr.isika.cda.project3.model.solutionManagement;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda.project3.model.personManagement.Vehicule;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CarRentalService extends Service {
    
    private String keyPickUpAddress;
    
    private String keyDropOffAddress;
    
    @OneToOne
    private Vehicule vehicule;

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
    
    

}
