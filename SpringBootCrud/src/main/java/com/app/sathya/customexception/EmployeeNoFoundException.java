package com.app.sathya.customexception;

public class EmployeeNoFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
public EmployeeNoFoundException()
{
	super();
}
public EmployeeNoFoundException(String msg) {

	super(msg);
}
}
