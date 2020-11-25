package com.rigor.exeption;

public class VehicleValueException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleValueException() {
		super("O valor do veículo tem de ser superior a 0");
	}
}
