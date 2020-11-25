package com.rigor.servlets.dao.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.rigor.servlets.dao.FinancialTypeDAO;
import com.rigor.servlets.model.Financial;
import com.rigor.servlets.model.FinancialType;

public class FinancialTypeDAOImpl implements FinancialTypeDAO{
	
	private static final String financialTypeFile = "C:\\projects\\financialType.json";
	
	private Gson gson;
	
	public FinancialTypeDAOImpl() {
		this.gson = new Gson();
	}

	@Override
	public List<FinancialType> getFinancialTypes() {
		return this.getFinancialListFromFile();
	}

	@Override
	public FinancialType getFinancialTypeByName(String financialTypeName) {
		if(financialTypeName!= null) {
			for(FinancialType f : getFinancialListFromFile()) {
				if(f.getFinancialTypeName().equals(financialTypeName)) {
					return f;
				}
			}
		}
		return null;
	}
	
	private List<FinancialType> getFinancialListFromFile(){	
		List<FinancialType> listFinancial = new ArrayList<>();
		try {
			FinancialType[] arrayFinancial = gson.fromJson(new FileReader(financialTypeFile), FinancialType[].class);
			int arraySize = arrayFinancial.length;
			for(int i = 0; i<arraySize; i++) {
				listFinancial.add(arrayFinancial[i]);
			}
		} catch (JsonSyntaxException e) {
			//TODO: log error
			e.printStackTrace();
		} catch (JsonIOException e) {
			//TODO:log error;
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listFinancial;
	}

}
