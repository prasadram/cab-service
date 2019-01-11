package org.letuslearn.cabs.restservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TeamMemberDto {

  @JsonProperty("team_member_id")
  @NotNull(message = "API_TEAM_MEMBER_ID_NOT_NULL")
  private String id;

  @NotNull(message = "API_TEAM_MEMBER_GENDER_NOT_NULL")
  private String gender;

  @NotNull(message = "API_TEAM_MEMBER_DROP_POINT_NOT_NULL")
  @JsonProperty("drop_point")
  private String dropPoint;

}
