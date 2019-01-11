package org.letuslearn.cabs.repository;

import org.letuslearn.cabs.domain.TeamMember;

import java.util.List;

public interface TeamMemberRepository {
  TeamMember addMember(TeamMember teamMember);

  List<TeamMember> getAllTeamMembers();
}
