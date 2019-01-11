package org.letuslearn.cabs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends BusinessException {

  private Errors errors;

  public BadRequestException(String errorMessage) {
    super(errorMessage);
  }

  public BadRequestException(String errorCode, String errorMessage) {
    super(errorCode, errorMessage);
  }

  public BadRequestException(
          String errorCode, String errorMessage, ErrorResponse errorResponse) {
    super(errorCode, errorMessage, errorResponse);
  }

  public BadRequestException(
          String errorCode, String errorMessage, ErrorResponse errorResponse, int statusCode) {
    super(errorCode, errorMessage, errorResponse, statusCode);
  }

  public BadRequestException(Errors errors) {
    super("API_INVALID_EXCEPTION");
    this.errors = errors;
  }

  public Errors getErrors() {
    return this.errors;
  }

}
