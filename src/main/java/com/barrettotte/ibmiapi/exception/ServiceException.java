package com.barrettotte.ibmiapi.exception;

public class ServiceException extends Exception{

    private static final long serialVersionUID = 1L;

    public ServiceException() {
        super();
    }

    public ServiceException(final String message){
        super(message);
    }
}