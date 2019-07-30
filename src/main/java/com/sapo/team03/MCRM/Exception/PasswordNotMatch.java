package com.sapo.team03.MCRM.Exception;

public class PasswordNotMatch extends RuntimeException {
	public PasswordNotMatch() {
		super("Wrong password");
	}
}
