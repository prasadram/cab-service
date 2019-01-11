package org.letuslearn.cabs.exceptions;

public class BusinessException extends RuntimeException {

  private ErrorResponse errorResponse;
  private int statusCode;
  private String errorCode;
  private String errorMessage;

  public BusinessException(String errorMessage) {
    super(errorMessage);
  }

  public BusinessException(String errorCode, String errorMessage) {
    super(errorMessage);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public BusinessException(String errorCode, String errorMessage, ErrorResponse errorResponse) {
    super(errorMessage);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.errorResponse = errorResponse;
  }

  public BusinessException(String errorCode, String errorMessage, ErrorResponse errorResponse, int statusCode) {
    super(errorMessage);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.errorResponse = errorResponse;
    this.statusCode = statusCode;
  }

  public ErrorResponse getErrorResponse() {
    return errorResponse;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
