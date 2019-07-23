package com.sapo.team03.MCRM.Exception;

@SuppressWarnings("serial")
public class DuplicateEmail  extends RuntimeException{
	public DuplicateEmail (String email) {
		super("Duplicate email "+email+ " for new entry");
	}
}
