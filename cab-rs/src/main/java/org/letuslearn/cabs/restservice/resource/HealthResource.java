package org.letuslearn.cabs.restservice.resource;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.restservice.dto.HealthCheckDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.letuslearn.cabs.constants.LogConstants.LOG_OK_PATTERN;

@RestController
@RequestMapping("/v1/cab-rs/")
@Slf4j
public class HealthResource {

  @Value("${project.name:Cab Service}")
  String projectName;

  @RequestMapping(value = "/check", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity check() {
    log.info(LOG_OK_PATTERN, "check", "checking application status");
    HealthCheckDto healthCheckDto =new HealthCheckDto();
    healthCheckDto.setProjectName(projectName);
    healthCheckDto.setCheck("OK");
    return new ResponseEntity(healthCheckDto, HttpStatus.OK);
  }

}
