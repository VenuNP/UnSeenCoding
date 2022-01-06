package com.initial.start.bookmyshow.exception;

public class MovieNotFoundException extends  Exception {
    public MovieNotFoundException(){
    }

    public MovieNotFoundException(String message){
    super(message);
    }
}
