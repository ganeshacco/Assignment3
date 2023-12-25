package com.example.OfflinePayment.ExceptionHandling;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {super(message);}
}
