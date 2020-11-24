package com.rigor.servlets.service;

import com.rigor.servlets.dao.FinancialDAO;
import com.rigor.servlets.dao.FinancialTypeDAO;
import com.rigor.servlets.dao.files.FinancialDAOImpl;
import com.rigor.servlets.dao.files.FinancialTypeDAOImpl;
import com.rigor.servlets.dto.FinancialDto;
import com.rigor.servlets.dto.FinancialTypeDto;
import com.rigor.servlets.model.Client;
import com.rigor.servlets.model.Financial;
import com.rigor.servlets.model.FinancialType;

public class FinancialServiceImpl implements FinancialService{
	
	private FinancialTypeDAO financialTypeDAO;
	
	private FinancialDAO financialDAO;
	
	public FinancialServiceImpl() {
		this.financialTypeDAO = new FinancialTypeDAOImpl();
		this.financialDAO = new FinancialDAOImpl();
	}

	@Override
	public FinancialDto calculateMonthlyFunding(float vehicleValue, int duration, String financialTypeName) {
		FinancialType financialType = this.financialTypeDAO.getFinancialTypeByName(financialTypeName);
		if(financialType != null) {
			Financial financial = new Financial(vehicleValue, duration, financialType);
			
			float monthlyFunding = financial.calculateFinancial();
			
			FinancialTypeDto financialTypeDto = this.createFinancialTypeDto(financialType);
			FinancialDto financialDto = new FinancialDto();
			financialDto.monthlyFunding = String.format("%.2f", monthlyFunding);
			financialDto.vehicleValue = vehicleValue;
			financialDto.monthlyDuration = financial.getMonthlyFundingDuration();
			financialDto.setFinancialTypeDto(financialTypeDto);
			return financialDto;
		}
		return null;
	}
	
	//TODO: return the respective DTO, maybe implement converts to convert DTO to model class
	@Override
	public void createFinancial(FinancialDto financialDto, String name, String contact) {
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
