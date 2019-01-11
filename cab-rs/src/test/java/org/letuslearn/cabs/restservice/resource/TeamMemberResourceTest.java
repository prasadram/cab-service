package org.letuslearn.cabs.restservice.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.letuslearn.cabs.exceptions.ResponseEntityAdvice;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;
import org.letuslearn.cabs.service.TeamMemberService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class TeamMemberResourceTest {

  private MockMvc mockMvc;

  @InjectMocks
  TeamMemberResource teamMemberResource;

  @Mock
  TeamMemberService teamMemberService;

  @InjectMocks
  ResponseEntityAdvice responseEntityAdvice;

  @Mock
  Environment environment;

  private static final String ADD_MEMBER_URL = "/v1/cab-rs/register";

  private ObjectMapper objectMapper = new ObjectMapper();

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(teamMemberResource)
            .setControllerAdvice(responseEntityAdvice)
            .build();
  }

  @Test
  public void shouldBeAbleToRegisterMember() throws Exception {
    TeamMemberDto teamMemberDto = new TeamMemberDto();
    teamMemberDto.setDropPoint("Pointa");
    teamMemberDto.setGender("M");
    teamMemberDto.setId("2");
    doNothing().when(teamMemberService).registerMember(any());
    mockMvc.perform(post(ADD_MEMBER_URL)
            .content(objectMapper.writeValueAsString(teamMemberDto))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
  }

  @Test
  public void shouldBeAbleToGetBadRequestWhenIdIsNullDuringRegisterMember() throws Exception {
    TeamMemberDto teamMemberDto = new TeamMemberDto();
    teamMemberDto.setDropPoint("Pointa");
    teamMemberDto.setGender("M");

    doNothing().when(teamMemberService).registerMember(any());
    mockMvc.perform(post(ADD_MEMBER_URL)
            .content(objectMapper.writeValueAsString(teamMemberDto))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
  }

  @Test
  public void shouldBeAbleToGetBadRequestWhenGenderIsNullDuringRegisterMember() throws Exception {
    TeamMemberDto teamMemberDto = new TeamMemberDto();
    teamMemberDto.setDropPoint("Pointa");
    teamMemberDto.setId("3");

    doNothing().when(teamMemberService).registerMember(any());
    mockMvc.perform(post(ADD_MEMBER_URL)
            .content(objectMapper.writeValueAsString(teamMemberDto))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
  }

  @Test
  public void shouldBeAbleToGetBadRequestWhenDropPointsIsNullDuringRegisterMember() throws Exception {
    TeamMemberDto teamMemberDto = new TeamMemberDto();
    teamMemberDto.setGender("G");
    teamMemberDto.setId("3");

    doNothing().when(teamMemberService).registerMember(any());
    mockMvc.perform(post(ADD_MEMBER_URL)
            .content(objectMapper.writeValueAsString(teamMemberDto))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
  }
}