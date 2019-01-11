package org.letuslearn.cabs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class PreConditionFailedException extends BusinessException {


  public PreConditionFailedException(String errorMessage) {
    super(errorMessage);
  }

  public PreConditionFailedException(String errorCode, String errorMessage) {
    super(errorCode, errorMessage);
  }
}
