package org.letuslearn.cabs.service.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.exceptions.PreConditionFailedException;
import org.letuslearn.cabs.repository.TeamMemberRepository;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;
import org.letuslearn.cabs.restservice.mapper.TeamMemberRequestMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;

public class TeamMemberServiceImplTest {

  @InjectMocks
  TeamMemberServiceImpl registrationService;

  @Mock
  TeamMemberRepository teamMemberRepository;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldBeAbleToRegisterMember() {
    TeamMemberDto teamMemberDto = new TeamMemberDto();
    teamMemberDto.setDropPoint("pointC");
    teamMemberDto.setId("2");
    teamMemberDto.setGender("M");
    TeamMember teamMember = TeamMemberRequestMapper.toTeamMember(teamMemberDto);
    Mockito.when(teamMemberRepository.addMember(any())).thenReturn(
            teamMember);
    registrationService.registerMember(teamMemberDto);
    Mockito.verify(teamMemberRepository, Mockito.times(1)).addMember(teamMember);
  }

  @Test
  public void shouldBeAbleToGetExceptionForInvalidGenderDuringRegisterMember() {
    thrown.expect(PreConditionFailedException.class);
    thrown.expect(hasProperty("errorCode", is("API_TEAM_MEMBER_GENDER_NOT_VALID")));
    thrown.expect(hasProperty("errorMessage", is("Please enter a valid Gender")));
    TeamMemberDto teamMemberDto = new TeamMemberDto();
    teamMemberDto.setDropPoint("pointC");
    teamMemberDto.setId("2");
    teamMemberDto.setGender("Hello");
    TeamMember teamMember = TeamMemberRequestMapper.toTeamMember(teamMemberDto);
    Mockito.when(teamMemberRepository.addMember(any())).thenReturn(
            teamMember);
    registrationService.registerMember(teamMemberDto);
  }

}