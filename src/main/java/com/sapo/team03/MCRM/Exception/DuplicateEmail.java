package com.sapo.team03.MCRM.Exception;

public class DuplicateEmail  extends RuntimeException{
	public DuplicateEmail (String email) {
		super("Duplicate email "+email+ " for new entry");
	}
}
