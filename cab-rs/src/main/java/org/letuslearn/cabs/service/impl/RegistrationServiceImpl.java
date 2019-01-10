package org.letuslearn.cabs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.repository.RegistrationRepository;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;
import org.letuslearn.cabs.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

  @Autowired
  private RegistrationRepository registrationRepository;

  @Override
  public void registerMember(TeamMemberDto teamMemberDto) {
    log.info("op=registerMember, status=OK, desc=register member");
      registrationRepository.addMember(toTeamMember(teamMemberDto));
  }

  private TeamMember toTeamMember(TeamMemberDto teamMemberDto) {
    TeamMember teamMember = new TeamMember();
    teamMember.setDropPoint(teamMemberDto.getDropPoint());
    teamMember.setGender(teamMemberDto.getGender());
    teamMember.setId(Integer.parseInt(teamMemberDto.getId()));
    return teamMember;
  }
}
