package com.epicode.es3;

public class BancaException extends Exception{
	private String message;

    public BancaException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
