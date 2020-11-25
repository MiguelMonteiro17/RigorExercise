package com.rigor.dto;

public class FinancialTypeDto {

	private String financialTypeName;
	
	private int maxDuration;
	
	private float factor;

	public String getFinancialTypeName() {
		return financialTypeName;
	}

	public void setFinancialTypeName(String financialTypeName) {
		this.financialTypeName = financialTypeName;
	}

	public int getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(int maxDuration) {
		this.maxDuration = maxDuration;
	}

	public float getFactor() {
		return factor;
	}

	public void setFactor(float factor) {
		this.factor = factor;
	}
	
	
}
