package org.letuslearn.cabs.restservice.mapper;

import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;

public final class TeamMemberRequestMapper {

  public static TeamMember toTeamMember(TeamMemberDto teamMemberDto) {
    TeamMember teamMember = new TeamMember();
    teamMember.setDropPoint(teamMemberDto.getDropPoint());
    teamMember.setGender(teamMemberDto.getGender());
    teamMember.setId(Integer.parseInt(teamMemberDto.getId()));
    return teamMember;
  }
}
