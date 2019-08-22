package com.sapo.team03.MCRM.Exception;

public class MissInforException extends NullPointerException{
	public MissInforException() {
		super("Some fields are missing,refill and upload again.");
	}

}
