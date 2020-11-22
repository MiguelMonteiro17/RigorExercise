package com.rigor.servlets.dao;

import java.util.List;

import com.rigor.servlets.model.FinancialType;

public interface FinancialTypeDAO {
	
	List<FinancialType> getFinancialTypes();
	
	FinancialType getFinancialTypeByName(String financialTypeName);

}
