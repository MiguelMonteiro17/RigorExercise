package com.rigor.servlets.dao.files;

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

public abstract class AbstractAccessFileDAO {
	private Gson gson;
	
	protected <T,A> List<A> getListTypeFromFile(String fileName, Class<T> classType){	
		try {
			T arrayFinancial = gson.fromJson(new FileReader(fileName), classType);
			return  (List<A>) Arrays.asList(arrayFinancial);
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
	
	protected <T> void saveListTypeOnJsonFile(String fileName,List<T> listFinancial) {	
		try{
			FileWriter writer; writer = new FileWriter(fileName);
			gson.toJson(listFinancial,writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
