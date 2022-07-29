package project3.entity.financialManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BankDetails {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String bankName;
    
    private String swift;
    
    private String iban;
    
    public BankDetails() {
	super();
    }

    public BankDetails(Long id, String bankName, String swift, String iban) {
	super();
	this.id = id;
	this.bankName = bankName;
	this.swift = swift;
	this.iban = iban;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Long getId() {
        return id;
    }

}
