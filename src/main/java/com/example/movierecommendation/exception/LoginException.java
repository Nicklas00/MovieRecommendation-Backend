package com.example.movierecommendation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LoginException extends Exception {

  public LoginException(String msg) {
    super(msg);
  }
}
