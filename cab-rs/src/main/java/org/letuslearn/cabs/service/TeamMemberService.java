package org.letuslearn.cabs.service;

import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;

import java.util.List;

public interface TeamMemberService {
  void registerMember(TeamMemberDto teamMemberDto);

  List<TeamMember> getAllTeamMembers();
}
