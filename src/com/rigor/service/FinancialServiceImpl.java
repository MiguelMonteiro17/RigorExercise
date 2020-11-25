package com.rigor.service;

import com.rigor.dao.FinancialDAO;
import com.rigor.dao.FinancialTypeDAO;
import com.rigor.dao.files.FinancialDAOImpl;
import com.rigor.dao.files.FinancialTypeDAOImpl;
import com.rigor.dto.FinancialDto;
import com.rigor.dto.FinancialTypeDto;
import com.rigor.exeption.FinancialDurationException;
import com.rigor.exeption.VehicleValueException;
import com.rigor.model.Client;
import com.rigor.model.Financial;
import com.rigor.model.FinancialType;

public class FinancialServiceImpl implements FinancialService{
	
	private FinancialTypeDAO financialTypeDAO;
	
	private FinancialDAO financialDAO;
	
	public FinancialServiceImpl() {
		this.financialTypeDAO = new FinancialTypeDAOImpl();
		this.financialDAO = new FinancialDAOImpl();
	}

	@Override
	public FinancialDto calculateMonthlyFunding(float vehicleValue, int duration, String financialTypeName) throws VehicleValueException,FinancialDurationException {
		FinancialType financialType = this.financialTypeDAO.getFinancialTypeByName(financialTypeName);
		if(financialType != null) {
			Financial financial = new Financial(vehicleValue, duration, financialType);
			
			float monthlyFunding = financial.calculateFinancial();
			
			FinancialTypeDto financialTypeDto = this.createFinancialTypeDto(financialType);
			FinancialDto financialDto = new FinancialDto();
			financialDto.setMonthlyFunding(String.format("%.2f", monthlyFunding));
			financialDto.setVehicleValue(vehicleValue);
			financialDto.setMonthlyDuration(financial.getMonthlyFundingDuration());
			financialDto.setFinancialDuration(financial.getFinancialDuration());
			financialDto.setFinancialTypeDto(financialTypeDto);
			
			return financialDto;
		}
		return null;
	}
	
	@Override
	public void createFinancial(FinancialDto financialDto, String name, String contact) throws VehicleValueException,FinancialDurationException {
		Client client = new Client(name,contact);
		FinancialType financialType = this.financialTypeDAO.getFinancialTypeByName(financialDto.getFinancialTypeDto().getFinancialTypeName());
		Financial financial = new Financial(financialDto.getVehicleValue(),financialDto.getFinancialDuration(),financialType,client);
		financialDAO.saveFinancial(financial);
		
	}
	
	private FinancialTypeDto createFinancialTypeDto(FinancialType financialType) {
		FinancialTypeDto financialTypeDto = new FinancialTypeDto();
		financialTypeDto.setFactor(financialType.getFactor());
		financialTypeDto.setFinancialTypeName(financialType.getFinancialTypeName());
		financialTypeDto.setMaxDuration(financialType.getMaxDuration());
		return financialTypeDto;
	}

}
