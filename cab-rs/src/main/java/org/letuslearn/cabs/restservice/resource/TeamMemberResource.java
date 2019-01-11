package org.letuslearn.cabs.restservice.resource;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.exceptions.BadRequestException;
import org.letuslearn.cabs.restservice.dto.TeamMemberDto;
import org.letuslearn.cabs.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.letuslearn.cabs.constants.LogConstants.LOG_KO_PATTERN_REQUEST;
import static org.letuslearn.cabs.constants.LogConstants.LOG_OK_PATTERN_REQUEST;

@RestController
@RequestMapping("/v1/cab-rs/")
@Slf4j
public class TeamMemberResource {

  @Autowired
  private TeamMemberService teamMemberService;

  @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity registerTeamMember(@Valid @RequestBody TeamMemberDto teamMemberDto, BindingResult bindingResult) {

    if(bindingResult.hasErrors()) {
      log.error(LOG_KO_PATTERN_REQUEST, "register", teamMemberDto);
      throw new BadRequestException(bindingResult);
    }
    teamMemberService.registerMember(teamMemberDto);
    log.info(LOG_OK_PATTERN_REQUEST, "register", teamMemberDto);
    return new ResponseEntity(HttpStatus.CREATED);
  }

}
