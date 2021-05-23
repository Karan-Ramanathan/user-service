package com.example.user.exception;

import com.example.user.model.UserError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHelper {

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<UserError> resourceNotFound(ResourceNotFoundException ex) {
    UserError error = new UserError();
    error.setCode("404");
    error.setMessage(ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ResourceAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public  ResponseEntity<UserError> resourceNotFound(ResourceAlreadyExistsException ex) {
    UserError error = new UserError();
    error.setCode("409");
    error.setMessage(ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
  }
}
