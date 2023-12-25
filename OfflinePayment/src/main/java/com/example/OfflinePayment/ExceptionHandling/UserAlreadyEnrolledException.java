package com.example.OfflinePayment.ExceptionHandling;

public class UserAlreadyEnrolledException extends RuntimeException {
    public UserAlreadyEnrolledException(String message) {super(message);}
}