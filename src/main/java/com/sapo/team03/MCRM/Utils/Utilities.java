package com.sapo.team03.MCRM.Utils;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component("Utilities")
public class Utilities {
	public static void log(String log) {
		System.out.println("["+ LocalDate.now() + "]LOGGING ::: "+ log);
	}

}
