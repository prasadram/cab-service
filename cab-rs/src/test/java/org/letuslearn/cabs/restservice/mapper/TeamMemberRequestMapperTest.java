package org.letuslearn.cabs.restservice.mapper;

import org.junit.Test;
import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;

import static org.junit.Assert.*;

public class TeamMemberRequestMapperTest {

  @Test
  public void shouldBeAbleToCovertRequestDomain() {
    TeamMemberDto teamMemberDto = new TeamMemberDto();
    teamMemberDto.setGender("M");
    teamMemberDto.setId("4");
    teamMemberDto.setDropPoint("pointC");
    TeamMember teamMember = TeamMemberRequestMapper.toTeamMember(teamMemberDto);
    assertEquals(4,teamMember.getId());
    assertEquals("M",teamMember.getGender());
    assertEquals("pointC",teamMember.getDropPoint());
  }
}