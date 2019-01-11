package org.letuslearn.cabs.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RouteDto {

  @JsonProperty("cab_id")
  private String cabId;

  @JsonProperty("team_member_ids")
  private String teamMembers;

  @JsonProperty("route")
  private String route;

  @JsonProperty("route_cost")
  private int routeCost;
}
