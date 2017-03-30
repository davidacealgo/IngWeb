package com.udea.iw.exception;

import org.apache.log4j.Logger;

public class Exceptions extends Exception {

	public Exceptions() {
		// TODO Auto-generated constructor stub
	}

	public Exceptions(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Exceptions(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public Exceptions(String message, Throwable cause) {
		super(message, cause);
		log.error(message,cause);
		// TODO Auto-generated constructor stub
	}

	public Exceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	Logger log = Logger.getLogger(this.getClass());
	
}
