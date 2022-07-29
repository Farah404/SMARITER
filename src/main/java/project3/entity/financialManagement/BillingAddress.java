package project3.entity.financialManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BillingAddress {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String addressLine;
    
    private String city;
    
    private String region;
    
    private String country;
    
    private int postalCode;

    public BillingAddress() {
	super();
    }

    public BillingAddress(Long id, String addressLine, String city, String region, String country, int postalCode) {
	super();
	this.id = id;
	this.addressLine = addressLine;
	this.city = city;
	this.region = region;
	this.country = country;
	this.postalCode = postalCode;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

}
