package com.company.cache.exceptions;

public class StorageFullException extends RuntimeException{
    public StorageFullException(final String message){
        super(message);
    }
}
