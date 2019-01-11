package org.letuslearn.cabs.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RoutePlanDto {

  @JsonProperty("total_cost")
  private String totalCost;

  @JsonProperty("routes")
  private List<RouteDto> routeDtoList;
}
