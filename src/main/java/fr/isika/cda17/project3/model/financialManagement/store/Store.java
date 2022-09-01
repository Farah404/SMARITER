package fr.isika.cda17.project3.model.financialManagement.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    private String batchOneName;
    private int batchOneQuantity;
    private double batchOnePrice;

    private String batchTwoName;
    private int batchTwoQuantity;
    private double batchTwoPrice;

    private String batchThreeName;
    private int batchThreeQuantity;
    private double batchThreePrice;

    private String MonthlySubscriptionName;
    private int MonthlySubscriptionQuantity;
    private double MonthlySubscriptionPrice;

    private String TrimestrialSubscriptionName;
    private int TrimestrialSubscriptionQuantity;
    private double TrimestrialSubscriptionPrice;

    private String SemestrialSubscriptionName;
    private int SemestrialSubscriptionQuantity;
    private double SemestrialSubscriptionPrice;

    public Store() {
	super();
    }

    public Store(Long id, String batchOneName, int batchOneQuantity, double batchOnePrice, String batchTwoName,
	    int batchTwoQuantity, double batchTwoPrice, String batchThreeName, int batchThreeQuantity,
	    double batchThreePrice, String monthlySubscriptionName, int monthlySubscriptionQuantity,
	    double monthlySubscriptionPrice, String trimestrialSubscriptionName, int trimestrialSubscriptionQuantity,
	    double trimestrialSubscriptionPrice, String semestrialSubscriptionName, int semestrialSubscriptionQuantity,
	    double semestrialSubscriptionPrice) {
	super();
	this.id = id;
	this.batchOneName = batchOneName;
	this.batchOneQuantity = batchOneQuantity;
	this.batchOnePrice = batchOnePrice;
	this.batchTwoName = batchTwoName;
	this.batchTwoQuantity = batchTwoQuantity;
	this.batchTwoPrice = batchTwoPrice;
	this.batchThreeName = batchThreeName;
	this.batchThreeQuantity = batchThreeQuantity;
	this.batchThreePrice = batchThreePrice;
	MonthlySubscriptionName = monthlySubscriptionName;
	MonthlySubscriptionQuantity = monthlySubscriptionQuantity;
	MonthlySubscriptionPrice = monthlySubscriptionPrice;
	TrimestrialSubscriptionName = trimestrialSubscriptionName;
	TrimestrialSubscriptionQuantity = trimestrialSubscriptionQuantity;
	TrimestrialSubscriptionPrice = trimestrialSubscriptionPrice;
	SemestrialSubscriptionName = semestrialSubscriptionName;
	SemestrialSubscriptionQuantity = semestrialSubscriptionQuantity;
	SemestrialSubscriptionPrice = semestrialSubscriptionPrice;
    }

    public String getBatchOneName() {
	return batchOneName;
    }

    public void setBatchOneName(String batchOneName) {
	this.batchOneName = batchOneName;
    }

    public int getBatchOneQuantity() {
	return batchOneQuantity;
    }

    public void setBatchOneQuantity(int batchOneQuantity) {
	this.batchOneQuantity = batchOneQuantity;
    }

    public double getBatchOnePrice() {
	return batchOnePrice;
    }

    public void setBatchOnePrice(double batchOnePrice) {
	this.batchOnePrice = batchOnePrice;
    }

    public String getBatchTwoName() {
	return batchTwoName;
    }

    public void setBatchTwoName(String batchTwoName) {
	this.batchTwoName = batchTwoName;
    }

    public int getBatchTwoQuantity() {
	return batchTwoQuantity;
    }

    public void setBatchTwoQuantity(int batchTwoQuantity) {
	this.batchTwoQuantity = batchTwoQuantity;
    }

    public double getBatchTwoPrice() {
	return batchTwoPrice;
    }

    public void setBatchTwoPrice(double batchTwoPrice) {
	this.batchTwoPrice = batchTwoPrice;
    }

    public String getBatchThreeName() {
	return batchThreeName;
    }

    public void setBatchThreeName(String batchThreeName) {
	this.batchThreeName = batchThreeName;
    }

    public int getBatchThreeQuantity() {
	return batchThreeQuantity;
    }

    public void setBatchThreeQuantity(int batchThreeQuantity) {
	this.batchThreeQuantity = batchThreeQuantity;
    }

    public double getBatchThreePrice() {
	return batchThreePrice;
    }

    public void setBatchThreePrice(double batchThreePrice) {
	this.batchThreePrice = batchThreePrice;
    }

    public String getMonthlySubscriptionName() {
	return MonthlySubscriptionName;
    }

    public void setMonthlySubscriptionName(String monthlySubscriptionName) {
	MonthlySubscriptionName = monthlySubscriptionName;
    }

    public int getMonthlySubscriptionQuantity() {
	return MonthlySubscriptionQuantity;
    }

    public void setMonthlySubscriptionQuantity(int monthlySubscriptionQuantity) {
	MonthlySubscriptionQuantity = monthlySubscriptionQuantity;
    }

    public double getMonthlySubscriptionPrice() {
	return MonthlySubscriptionPrice;
    }

    public void setMonthlySubscriptionPrice(double monthlySubscriptionPrice) {
	MonthlySubscriptionPrice = monthlySubscriptionPrice;
    }

    public String getTrimestrialSubscriptionName() {
	return TrimestrialSubscriptionName;
    }

    public void setTrimestrialSubscriptionName(String trimestrialSubscriptionName) {
	TrimestrialSubscriptionName = trimestrialSubscriptionName;
    }

    public int getTrimestrialSubscriptionQuantity() {
	return TrimestrialSubscriptionQuantity;
    }

    public void setTrimestrialSubscriptionQuantity(int trimestrialSubscriptionQuantity) {
	TrimestrialSubscriptionQuantity = trimestrialSubscriptionQuantity;
    }

    public double getTrimestrialSubscriptionPrice() {
	return TrimestrialSubscriptionPrice;
    }

    public void setTrimestrialSubscriptionPrice(double trimestrialSubscriptionPrice) {
	TrimestrialSubscriptionPrice = trimestrialSubscriptionPrice;
    }

    public String getSemestrialSubscriptionName() {
	return SemestrialSubscriptionName;
    }

    public void setSemestrialSubscriptionName(String semestrialSubscriptionName) {
	SemestrialSubscriptionName = semestrialSubscriptionName;
    }

    public int getSemestrialSubscriptionQuantity() {
	return SemestrialSubscriptionQuantity;
    }

    public void setSemestrialSubscriptionQuantity(int semestrialSubscriptionQuantity) {
	SemestrialSubscriptionQuantity = semestrialSubscriptionQuantity;
    }

    public double getSemestrialSubscriptionPrice() {
	return SemestrialSubscriptionPrice;
    }

    public void setSemestrialSubscriptionPrice(double semestrialSubscriptionPrice) {
	SemestrialSubscriptionPrice = semestrialSubscriptionPrice;
    }

    public Long getId() {
	return id;
    }

}
