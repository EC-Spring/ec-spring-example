package org.ec.example.community.dto.hello.exception;

public class HelloNotFound extends RuntimeException {

    public HelloNotFound(String message) {
        super(message);
    }
}
