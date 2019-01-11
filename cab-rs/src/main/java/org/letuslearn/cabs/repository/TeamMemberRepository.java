package org.letuslearn.cabs.repository;

import org.letuslearn.cabs.domain.TeamMember;

public interface TeamMemberRepository {
  TeamMember addMember(TeamMember teamMember);
}
