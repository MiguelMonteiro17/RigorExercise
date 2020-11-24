package com.rigor.servlets.model;

public class Financial {

	private float vehicleValue;
	
	private int financialDuration;
	
	private FinancialType financialType;
	
	private Client client;
	
	public Financial(float vehicleValue, int financialDuration, FinancialType financialType) {
		this(vehicleValue,financialDuration,financialType,null);
	}
	
	public Financial(float vehicleValue, int financialDuration,FinancialType financialType, Client client) {
		setVehicleValue(vehicleValue);
		setFinancialType(financialType);
		setFinancialDuration(financialDuration);
		setClient(client);
	}
	
	private boolean checkFinancialDuration(int financialDuration) {
		return !(financialDuration > this.financialType.getMaxDuration());
	}

	public float getVehicleValue() {
		return vehicleValue;
	}

	public void setVehicleValue(float vehicleValue) {
		this.vehicleValue = vehicleValue;
	}

	public int getFinancialDuration() {
		return financialDuration;
	}

	public void setFinancialDuration(int financialDuration) {
		if(checkFinancialDuration(financialDuration)) {
			this.financialDuration = financialDuration;
		}else {
			//TODO: throw exception because the financialDuration can't be bigger than the maxDuration supported on the financialType
		}
		
	}
	
	public float calculateFinancial() {
		float factor = this.financialType.getFactor()/100;
		int numberOfMonths = getMonthlyFundingDuration();
		return (this.vehicleValue*(1+factor))/numberOfMonths;
	}

	public FinancialType getFinancialType() {
		return financialType;
	}

	public void setFinancialType(FinancialType financialType) {
		this.financialType = financialType;
	}
	
	public int getMonthlyFundingDuration() {
		return financialDuration*12;
	}
	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + financialDuration;
		result = prime * result + ((financialType == null) ? 0 : financialType.hashCode());
		result = prime * result + Float.floatToIntBits(vehicleValue);
		result = prime * result + ((client == null)? 0 : financialType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Financial other = (Financial) obj;
		if (financialDuration != other.financialDuration)
			return false;
		if (financialType == null) {
			if (other.financialType != null)
				return false;
		} else if (!financialType.equals(other.financialType))
			return false;
		if(client == null) {
			if(other.client!= null)
				return false;
		}else if(!client.equals(other.client))
			return false;
		if (vehicleValue != other.vehicleValue)
			return false;
		return true;
	}
	
}
