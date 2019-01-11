package org.letuslearn.cabs.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class CabDto {

  @JsonProperty("cab_id")
  @NotNull(message = "API_CAB_ID_NOT_NULL")
  private String id;

  @NotNull(message = "API_CAB_COST_NOT_NULL")
  @Min(value = 1, message = "API_CAB_COST_INVALID")
  private int cost;

  @NotNull(message = "API_CAB_CAPACITY_NOT_NULL")
  @Min(value = 1, message = "API_CAB_CAPACITY_INVALID")
  private int capacity;

}
