package com.hello.exception;

public class DBException extends Exception {

    public DBException(Throwable throwable) {
        super(throwable);
    }
}