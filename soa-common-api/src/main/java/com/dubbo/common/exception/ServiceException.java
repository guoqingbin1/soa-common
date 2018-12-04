package com.dubbo.common.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException() {

	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable code, String message) {
		super(message, code);
	}
}
