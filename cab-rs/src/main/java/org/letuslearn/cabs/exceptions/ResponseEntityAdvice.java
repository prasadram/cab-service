package org.letuslearn.cabs.exceptions;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ResponseEntityAdvice {

  @Autowired
  Environment environment;

  private static final String KEY_PREFIX ="cab.error.messages.";

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity handleBadRequest(BadRequestException bre) {
    List<ErrorResponse> errorResponseList = new ArrayList<>();
    if (null != bre.getErrors()) {
      List<FieldError> filedErrors = bre.getErrors().getFieldErrors();
      filedErrors.forEach(fieldError1 -> {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(fieldError1.getDefaultMessage());
        errorResponse.setErrorMessage(environment.getProperty(KEY_PREFIX + fieldError1.getDefaultMessage()));
        populateTraceId(errorResponse);
        errorResponseList.add(errorResponse);
      });
      return new ResponseEntity(errorResponseList, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(PreConditionFailedException.class)
  public ResponseEntity handlePreConditionFailedRequest(PreConditionFailedException pfe) {
    return new ResponseEntity(this.getErrorResponse(pfe.getErrorCode(), pfe.getErrorMessage()),
            HttpStatus.PRECONDITION_FAILED);
  }

  private List<ErrorResponse> getErrorResponse(String errorCode, String errorMessage) {
    ErrorResponse response = new ErrorResponse();
    response.setErrorCode(errorCode);
    response.setErrorMessage(errorMessage);
    populateTraceId(response);
    return Arrays.asList(response);
  }

  private void populateTraceId(ErrorResponse errorResponse) {
    errorResponse.setTraceId(MDC.get("X-B3-TraceId"));
  }
}
