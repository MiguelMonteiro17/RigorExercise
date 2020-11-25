package com.rigor.dao;

import java.util.List;

import com.rigor.model.FinancialType;

public interface FinancialTypeDAO {
	
	List<FinancialType> getFinancialTypes();
	
	FinancialType getFinancialTypeByName(String financialTypeName);

}
