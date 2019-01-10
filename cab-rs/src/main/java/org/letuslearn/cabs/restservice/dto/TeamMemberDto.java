package org.letuslearn.cabs.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TeamMemberDto {

  @JsonProperty("team_member_id")
  @NotNull
  private String id;

  @NotNull
  private String gender;

  @NotNull
  @JsonProperty("drop_point")
  private String dropPoint;
}
