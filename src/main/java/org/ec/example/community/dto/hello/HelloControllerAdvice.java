package org.ec.example.community.dto.hello;

import org.ec.example.community.dto.hello.exception.HelloNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {HelloController.class})
public class HelloControllerAdvice {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> illegalArgumentException(IllegalArgumentException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({HelloNotFound.class})
    public ResponseEntity<String> helloNotFoundException(HelloNotFound exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
