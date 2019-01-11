package org.letuslearn.cabs.service;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.domain.DropPoint;
import org.letuslearn.cabs.repository.RouteRepository;
import org.letuslearn.cabs.restservice.dto.DropPointsDto;
import org.letuslearn.cabs.restservice.dto.RoutePlanDto;
import org.letuslearn.cabs.restservice.mapper.RouteRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RouteServiceImpl implements RouteService {

  @Autowired
  private RouteRepository routeRepository;

  @Override
  public void addDropPoints(DropPointsDto dropPointsDto) {
    // loggger
    List<DropPoint> dropPoints = RouteRequestMapper.toRoutes(dropPointsDto);

    // need to validate all scenarios
    // then persist in db

  }

  @Override
  public RoutePlanDto getRoutePlan() {
    return null;
  }
}
