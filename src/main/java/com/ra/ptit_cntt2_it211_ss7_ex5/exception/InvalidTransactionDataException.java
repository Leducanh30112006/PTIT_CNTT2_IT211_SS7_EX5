package com.ra.ptit_cntt2_it211_ss7_ex5.exception;

public class InvalidTransactionDataException extends RuntimeException {
    public InvalidTransactionDataException(String message) {
        super(message);
    }
}