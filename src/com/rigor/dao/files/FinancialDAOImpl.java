package com.rigor.dao.files;

import java.util.ArrayList;
import java.util.List;

import com.rigor.dao.FinancialDAO;
import com.rigor.model.Financial;

public class FinancialDAOImpl extends AbstractAccessFileDAO implements FinancialDAO{
	
	private static final String financialFile = "C:\\projects\\financial.json";

	
	public FinancialDAOImpl() {
		super();
	}

	@Override
	public void saveFinancial(Financial financial) {
		Financial[] financialArray = getListTypeFromFile(financialFile,Financial[].class);
		List<Financial> listFinancial = new ArrayList<>();
		if(financialArray != null) {			
			for(Financial f: financialArray) {
				listFinancial.add(f);
			}
		}
		listFinancial.add(financial);
	}
}
