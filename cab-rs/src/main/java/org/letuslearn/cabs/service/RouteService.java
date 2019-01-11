package org.letuslearn.cabs.service;

import org.letuslearn.cabs.restservice.dto.DropPointsDto;
import org.letuslearn.cabs.restservice.dto.RoutePlanDto;

public interface RouteService {

  void addDropPoints(DropPointsDto dropPointsDto);

  RoutePlanDto getRoutePlan();
}
