package org.letuslearn.cabs.restservice.resource;

import org.junit.Before;
import org.junit.Test;
import org.letuslearn.cabs.restservice.dto.HealthCheckDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;

public class HealthResourceTest {

  HealthResource healthResource;

  @Before
  public void setup() {
    healthResource = new HealthResource();
    ReflectionTestUtils.setField(healthResource, "projectName", "cab-service");
  }

  @Test
  public void shouldBeAbleToDoHealthCheck() {
    ResponseEntity healthResponse = healthResource.check();
    assertEquals(HttpStatus.OK, healthResponse.getStatusCode());
  }

  @Test
  public void shouldBeAbleToGetProjectName() {
    ResponseEntity<HealthCheckDto> healthResponse = healthResource.check();
    assertEquals(HttpStatus.OK, healthResponse.getStatusCode());
    assertEquals("OK", healthResponse.getBody().getCheck());
    assertEquals("cab-service", healthResponse.getBody().getProjectName());
  }

}