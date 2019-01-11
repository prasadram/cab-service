package org.letuslearn.cabs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.exceptions.PreConditionFailedException;
import org.letuslearn.cabs.repository.TeamMemberRepository;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;
import org.letuslearn.cabs.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.letuslearn.cabs.restservice.mapper.TeamMemberRequestMapper.toTeamMember;


@Service
@Slf4j
public class TeamMemberServiceImpl implements TeamMemberService {

  @Autowired
  private TeamMemberRepository teamMemberRepository;

  @Override
  public void registerMember(TeamMemberDto teamMemberDto) {
    log.info("op=registerMember, status=OK, desc=register member");

    TeamMember teamMember = toTeamMember(teamMemberDto);
    if(!isValidMember(teamMember)) {
      throw new PreConditionFailedException("API_TEAM_MEMBER_GENDER_NOT_VALID", "Please enter a valid Gender");
    }
    TeamMember registeredTeamMember = teamMemberRepository.addMember(teamMember);
  }

  @Override
  public List<TeamMember> getAllTeamMembers() {
    return teamMemberRepository.getAllTeamMembers();
  }

  private boolean isValidMember(TeamMember teamMember) {

    if ("M".equals(teamMember.getGender()) || "F".equals(teamMember.getGender())) {
      return true;
    }
    return false;
  }

}
