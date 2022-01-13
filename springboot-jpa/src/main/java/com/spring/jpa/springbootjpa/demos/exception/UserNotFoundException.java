package com.spring.jpa.springbootjpa.demos.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {

    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
