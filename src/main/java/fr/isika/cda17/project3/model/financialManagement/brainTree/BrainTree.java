package fr.isika.cda17.project3.model.financialManagement.brainTree;

public class BrainTree {
	
	private String chargeAmount;
	
	private String nonce;
	
	private String deviceData;
	
	
	public BrainTree(String chargeAmount, String nonce, String deviceData) {
		super();
		this.chargeAmount = chargeAmount;
		this.nonce = nonce;
		this.deviceData = deviceData;
	}

	public String getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(String chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getDeviceData() {
		return deviceData;
	}

	public void setDeviceData(String deviceData) {
		this.deviceData = deviceData;
	}
	
	
}
