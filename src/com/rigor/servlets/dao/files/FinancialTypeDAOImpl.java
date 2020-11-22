package com.rigor.servlets.dao.files;

import java.util.ArrayList;
import java.util.List;

import com.rigor.servlets.dao.FinancialTypeDAO;
import com.rigor.servlets.model.FinancialType;

public class FinancialTypeDAOImpl implements FinancialTypeDAO{
	
	List<FinancialType> listFinancialType;
	
	public FinancialTypeDAOImpl() {
		this.listFinancialType = new ArrayList<>();
		FinancialType financialTypeInternal = new FinancialType("Interno", 4, 4);
		FinancialType financialTypeExternal = new FinancialType("Externo", 5, 6.5f);
		this.listFinancialType.add(financialTypeExternal);
		this.listFinancialType.add(financialTypeInternal);
	}

	@Override
	public List<FinancialType> getFinancialTypes() {
		return this.listFinancialType;
	}

	@Override
	public FinancialType getFinancialTypeByName(String financialTypeName) {
		if(financialTypeName!= null) {
			for(FinancialType f : listFinancialType) {
				if(f.getFinancialTypeName().equals(financialTypeName)) {
					return f;
				}
			}
		}
		return null;
	}

}
