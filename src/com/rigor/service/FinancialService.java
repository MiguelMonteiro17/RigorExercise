package com.rigor.service;

import com.rigor.dto.FinancialDto;
import com.rigor.exeption.FinancialDurationException;
import com.rigor.exeption.VehicleValueException;

public interface FinancialService {
	
	FinancialDto calculateMonthlyFunding(float vehicleValue, int duration, String financialTypeName) throws VehicleValueException,FinancialDurationException;
	
	public void createFinancial(FinancialDto financialDto, String name, String contact) throws VehicleValueException,FinancialDurationException;

}
