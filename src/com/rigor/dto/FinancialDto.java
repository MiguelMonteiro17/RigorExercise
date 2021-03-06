package com.rigor.dto;

public class FinancialDto {

	private float vehicleValue;
	
	private String monthlyFunding;
	
	private int financialDuration;
	
	private int monthlyDuration;
	
	private FinancialTypeDto financialTypeDto;

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
