package com.rigor.dao.files;

import java.util.ArrayList;
import java.util.List;

import com.rigor.dao.FinancialTypeDAO;
import com.rigor.model.FinancialType;

public class FinancialTypeDAOImpl extends AbstractAccessFileDAO implements FinancialTypeDAO{
	
	private static final String financialTypeFile = "C:\\rigor\\financialType.json";
	
	public FinancialTypeDAOImpl() {
		super();
	}

	@Override
	public List<FinancialType> getFinancialTypes() {
		List<FinancialType> listFinancialType = new ArrayList<>();
		FinancialType[] financialTypeArray= super.getListTypeFromFile(financialTypeFile, FinancialType[].class);
		if(financialTypeArray != null) {
			for(FinancialType ft : financialTypeArray) {
				listFinancialType.add(ft);
			}
		}
		return listFinancialType;
	}

	@Override
	public FinancialType getFinancialTypeByName(String financialTypeName) {
		if(financialTypeName!= null) {
			for(FinancialType f : super.getListTypeFromFile(financialTypeFile, FinancialType[].class)) {
				if(f.getFinancialTypeName().equals(financialTypeName)) {
					return f;
				}
			}
		}
		return null;
	}

}
