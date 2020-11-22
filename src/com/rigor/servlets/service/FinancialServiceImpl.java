package com.rigor.servlets.service;

import com.rigor.servlets.dao.FinancialTypeDAO;
import com.rigor.servlets.dao.files.FinancialTypeDAOImpl;
import com.rigor.servlets.model.Financial;
import com.rigor.servlets.model.FinancialType;

public class FinancialServiceImpl implements FinancialService{
	
	private FinancialTypeDAO financialTypeDAO;
	
	public FinancialServiceImpl() {
		this.financialTypeDAO = new FinancialTypeDAOImpl();
	}

	@Override
	public float calculateMonthlyFunding(float vehicleValue, int duration, String financialTypeName) {
		FinancialType financialType = this.financialTypeDAO.getFinancialTypeByName(financialTypeName);
		if(financialType != null) {
			Financial financial = new Financial(vehicleValue, duration, financialType);
			return financial.calculateFinancial();
		}
		return 0;
	}

}
