package org.letuslearn.cabs.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
  private String errorCode;
  private String errorMessage;
  private String traceId;
}
