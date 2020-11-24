package com.rigor.servlets.model;

public class FinancialType {
	
	private String financialTypeName;
	
	private int maxDuration;
	
	private float factor;
	
	public FinancialType(String financialTypeName, int maxDuration, float factor) {
		setFinancialTypeName(financialTypeName);
		setMaxDuration(maxDuration);
		setFactor(factor);
		
	}	

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
		if(factor>= 0 && factor <=100) {
			this.factor = factor;
		}else {
			factor = 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(factor);
		result = prime * result + ((financialTypeName == null) ? 0 : financialTypeName.hashCode());
		result = prime * result + maxDuration;
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
		FinancialType other = (FinancialType) obj;
		if (Float.floatToIntBits(factor) != Float.floatToIntBits(other.factor))
			return false;
		if (financialTypeName == null) {
			if (other.financialTypeName != null)
				return false;
		} else if (!financialTypeName.equals(other.financialTypeName))
			return false;
		if (maxDuration != other.maxDuration)
			return false;
		return true;
	}

}
