package org.letuslearn.cabs.repository;

import org.letuslearn.cabs.domain.TeamMember;

public interface RegistrationRepository {
  void addMember(TeamMember teamMember);
}
