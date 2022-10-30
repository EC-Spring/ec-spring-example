package org.ec.example.hello.exception;

public class HelloNotFound extends RuntimeException {

    public HelloNotFound(String message) {
        super(message);
    }
}
