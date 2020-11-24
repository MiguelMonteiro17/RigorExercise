package com.rigor.servlets.dao.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.rigor.servlets.dao.FinancialDAO;
import com.rigor.servlets.model.Financial;

public class FinancialDAOImpl implements FinancialDAO{
	
	private static final String financialFile = "C:\\projects\\financial.json";
	
	private Gson gson;
	
	public FinancialDAOImpl() {
		this.gson = new Gson();
	}

	@Override
	public void saveFinancial(Financial financial) {
		List<Financial> listFinancial = getFinancialListFromFile();
		listFinancial.add(financial);
		saveFinancialListOnJsonFile(listFinancial);
	}
	
	
	private List<Financial> getFinancialListFromFile(){	
		try {
			Financial[] arrayFinancial = gson.fromJson(new FileReader(financialFile), Financial[].class);
			return Arrays.asList(arrayFinancial);
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
		return new ArrayList<>();
	}
	
	private void saveFinancialListOnJsonFile(List<Financial> listFinancial) {	
		try{
			FileWriter writer; writer = new FileWriter(financialFile);
			gson.toJson(listFinancial,writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
