package com.rigor.dao.files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public abstract class AbstractAccessFileDAO {
	private Gson gson;
	
	public AbstractAccessFileDAO() {
		gson = new Gson();
	}
	
	protected <T> T getListTypeFromFile(String fileName, Class<T> classType){	
		try {
			return gson.fromJson(new FileReader(fileName), classType);
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
		return null;
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
