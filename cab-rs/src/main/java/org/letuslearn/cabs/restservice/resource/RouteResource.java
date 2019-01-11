package org.letuslearn.cabs.restservice.resource;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cab-rs/")
@Slf4j
public class RouteResource {

  @Autowired
  private RouteService routeService;

  @RequestMapping(value = "/drop_points", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity addDropPoints() {
    //logger
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @RequestMapping(value = "/route_plan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity getRoutePlan() {
    //logger
    return new ResponseEntity(HttpStatus.OK);
  }
}
