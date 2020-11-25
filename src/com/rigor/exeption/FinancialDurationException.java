package com.rigor.exeption;

public class FinancialDurationException extends Throwable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FinancialDurationException(String financialType,int maxDuration) {
		super("A duração do financiamento "+financialType+" tem de ser maior que 0 e menor que "+maxDuration);
	}
}
