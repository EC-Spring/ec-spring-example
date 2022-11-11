package org.ec.example.community;

import org.ec.example.community.exception.CommunityNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommunityControllerAdvice {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> illegalArgumentException(IllegalArgumentException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CommunityNotFound.class})
    public ResponseEntity<String> helloNotFoundException(CommunityNotFound exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
