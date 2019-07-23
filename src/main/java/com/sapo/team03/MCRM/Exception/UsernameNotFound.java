package com.sapo.team03.MCRM.Exception;

public class UsernameNotFound extends RuntimeException{
	public UsernameNotFound(String username) {
		super("Username " + username + " not found");
	}
}