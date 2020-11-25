package com.rigor.dao.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.rigor.dao.FinancialDAO;
import com.rigor.model.Financial;

public class FinancialDAOImpl extends AbstractAccessFileDAO implements FinancialDAO{
	
	private static final String financialFile = "C:\\projects\\financial.json";
	
	private Gson gson;
	
	public FinancialDAOImpl() {
		this.gson = new Gson();
	}

	@Override
	public void saveFinancial(Financial financial) {
		//List<Financial> listFinancial = getListTypeFromFile(financialFile,Financial[].class);
		List<Financial> listFinancial = getFinancialListFromFile();
		listFinancial.add(financial);
		//saveListTypeOnJsonFile(financialFile, listFinancial);
		saveFinancialListOnJsonFile(listFinancial);
	}
	
	
	private List<Financial> getFinancialListFromFile(){	
		List<Financial> listFinancial = new ArrayList<>();
		try {
			Financial[] arrayFinancial = gson.fromJson(new FileReader(financialFile), Financial[].class);
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
