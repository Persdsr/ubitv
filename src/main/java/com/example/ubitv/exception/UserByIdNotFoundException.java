package com.example.ubitv.exception;

public class UserByIdNotFoundException extends Exception{
    public UserByIdNotFoundException(String message) {
        super(message);
    }
}
