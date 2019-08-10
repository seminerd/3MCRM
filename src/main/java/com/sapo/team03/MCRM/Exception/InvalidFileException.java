package com.sapo.team03.MCRM.Exception;

public class InvalidFileException extends RuntimeException {
	public InvalidFileException() {
		super("Invalid file type, only *.xlsx accepted");
		}

}
