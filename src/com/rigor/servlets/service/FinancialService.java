package com.rigor.servlets.service;

import com.rigor.servlets.dto.FinancialDto;

public interface FinancialService {
	
	FinancialDto calculateMonthlyFunding(float vehicleValue, int duration, String financialTypeName);
	
	public void createFinancial(FinancialDto financialDto, String name, String contact);

}
