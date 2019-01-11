package org.letuslearn.cabs.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DropPointsDto {

  @NotNull(message = "API_HEAD_QUARTER_DISTANCE_NOT_NULL")
  @JsonProperty("target_headquarter")
  private String headQuarter;

  @NotNull(message = "API_POINTA_DISTANCE_NOT_NULL")
  private String pointA;

  @NotNull(message = "API_POINTB_DISTANCE_NOT_NULL")
  private String pointB;

  @NotNull(message = "API_POINTC_DISTANCE_NOT_NULL")
  private String pointC;

  @NotNull(message = "API_POINTD_DISTANCE_NOT_NULL")
  private String pointD;

  @NotNull(message = "API_POINTE_DISTANCE_NOT_NULL")
  private String pointE;
}
