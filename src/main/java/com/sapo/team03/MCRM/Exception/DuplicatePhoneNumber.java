package com.sapo.team03.MCRM.Exception;

@SuppressWarnings("serial")
public class DuplicatePhoneNumber extends RuntimeException{
	public DuplicatePhoneNumber(String phoneNumber) {
		super("Duplicate phone number "+phoneNumber);
	}
}
