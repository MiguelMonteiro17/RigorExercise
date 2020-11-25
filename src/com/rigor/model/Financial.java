package com.rigor.model;

import com.rigor.exeption.FinancialDurationException;
import com.rigor.exeption.VehicleValueException;

public class Financial {

	private float vehicleValue;
	
	private int financialDuration;
	
	private FinancialType financialType;
	
	private Client client;
	
	public Financial(float vehicleValue, int financialDuration, FinancialType financialType) throws VehicleValueException, FinancialDurationException {
		this(vehicleValue,financialDuration,financialType,null);
	}
	
	public Financial(float vehicleValue, int financialDuration,FinancialType financialType, Client client) throws VehicleValueException, FinancialDurationException {
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

	public void setVehicleValue(float vehicleValue) throws VehicleValueException {
		if(vehicleValue>0) {
			this.vehicleValue = vehicleValue;
		}else {
			throw new VehicleValueException();
		}
		
	}

	public int getFinancialDuration() {
		return financialDuration;
	}

	public void setFinancialDuration(int financialDuration) throws FinancialDurationException {
		if(financialDuration>0 && checkFinancialDuration(financialDuration)) {
			this.financialDuration = financialDuration;
		}else {
			throw new FinancialDurationException(this.financialType.getFinancialTypeName(), this.financialType.getMaxDuration());
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
