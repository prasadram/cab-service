package org.letuslearn.cabs.service;

import org.letuslearn.cabs.restservice.dto.TeamMemberDto;

public interface RegistrationService {
  void registerMember(TeamMemberDto teamMemberDto);
}
