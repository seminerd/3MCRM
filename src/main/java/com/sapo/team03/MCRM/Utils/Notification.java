package com.sapo.team03.MCRM.Utils;

import java.time.LocalTime;

public class Notification {
	String content;
	LocalTime timestamp;
	public Notification(String content) {
		this.timestamp = LocalTime.now();
		this.content = content;
	}
	

}
