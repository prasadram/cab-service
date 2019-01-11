package org.letuslearn.cabs.exceptions;

import org.junit.Before;
import org.junit.Test;
import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.omg.CORBA.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.List;

import static org.junit.Assert.*;

public class ResponseEntityAdviceTest {

  @Mock
  Environment environment;

  @InjectMocks
  ResponseEntityAdvice responseEntityAdvice;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldBeAbleToGet400StatusCodeForBadRequest() {
    TeamMemberDto teamMemberDto = new TeamMemberDto();
    BindException bindException = new BindException(teamMemberDto, "id");
    BadRequestException badRequestException = new BadRequestException(bindException);

    ResponseEntity responseEntity = responseEntityAdvice.handleBadRequest(badRequestException);
    assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
  }


}