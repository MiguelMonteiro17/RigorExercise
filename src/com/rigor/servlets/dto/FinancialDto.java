package com.rigor.servlets.dto;

public class FinancialDto {

	public float vehicleValue;
	
	public String monthlyFunding;
	
	public int financialDuration;
	
	public int monthlyDuration;
	
	public FinancialTypeDto financialTypeDto;

	public float getVehicleValue() {
		return vehicleValue;
	}

	public void setVehicleValue(float vehicleValue) {
		this.vehicleValue = vehicleValue;
	}

	public String getMonthlyFunding() {
		return monthlyFunding;
	}

	public void setMonthlyFunding(String monthlyFunding) {
		this.monthlyFunding = monthlyFunding;
	}

	public int getFinancialDuration() {
		return financialDuration;
	}

	public void setFinancialDuration(int financialDuration) {
		this.financialDuration = financialDuration;
	}

	public int getMonthlyDuration() {
		return monthlyDuration;
	}

	public void setMonthlyDuration(int monthlyDuration) {
		this.monthlyDuration = monthlyDuration;
	}

	public FinancialTypeDto getFinancialTypeDto() {
		return financialTypeDto;
	}

	public void setFinancialTypeDto(FinancialTypeDto financialTypeDto) {
		this.financialTypeDto = financialTypeDto;
	}
	
}
