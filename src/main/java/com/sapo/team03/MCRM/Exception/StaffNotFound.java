package com.sapo.team03.MCRM.Exception;

public class StaffNotFound extends RuntimeException{
	public StaffNotFound(String mess) {
		super(mess + " not found");
	}
}
