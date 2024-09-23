package com.Customer.exception;

public class BookingNotFoundException extends RuntimeException {

    // Static field for serialization versioning
    private static final long serialVersionUID = 1L;

    // Constructor that accepts a message
    public BookingNotFoundException(String message) {
        super(message);
    }
}
