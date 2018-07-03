package de.fbeutel.todolistsbackend.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.fbeutel.todolistsbackend.exception.NotAuthorizedException;
import de.fbeutel.todolistsbackend.exception.NotFoundException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public void handleNotFound() {
  }

  @ExceptionHandler(NotAuthorizedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public void handleNotAuthorized() {
  }
}
