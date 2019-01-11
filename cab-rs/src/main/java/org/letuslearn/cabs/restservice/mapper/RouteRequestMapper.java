package org.letuslearn.cabs.restservice.mapper;

import org.letuslearn.cabs.domain.DropPoint;
import org.letuslearn.cabs.restservice.dto.DropPointsDto;

import java.util.ArrayList;
import java.util.List;

public final class RouteRequestMapper {

  public static List<DropPoint> toRoutes(DropPointsDto dropPointsDto) {
    List<DropPoint> dropPointList = new ArrayList<>();
    dropPointList.addAll(toRoutesByDistance("target_headquarter", dropPointsDto.getHeadQuarter(), 0));
    dropPointList.addAll(toRoutesByDistance("pointA", dropPointsDto.getPointA(), 1));
    dropPointList.addAll(toRoutesByDistance("pointB", dropPointsDto.getPointB(), 2));
    dropPointList.addAll(toRoutesByDistance("pointC", dropPointsDto.getPointC(), 3));
    dropPointList.addAll(toRoutesByDistance("pointD", dropPointsDto.getPointD(), 4));
    dropPointList.addAll(toRoutesByDistance("pointE", dropPointsDto.getPointE(), 5));

    return dropPointList;
  }

  public static List<DropPoint> toRoutesByDistance(String source, String distanceString, int index) {
    String[] split = distanceString.split(",");
    List<DropPoint> dropPointList = new ArrayList<>();
    DropPoint dropPoint;
    for (int i=0; i < 6; i++){
      if (index != i) {
        dropPoint = new DropPoint(source, getDestination(i), Integer.parseInt(split[i]));
        dropPointList.add(dropPoint);
      }
    }
    return dropPointList;
  }

  private static String getDestination(int index) {
    String destination;

    switch (index) {
      case 0:
        destination = "target_headquarter";
        break;
      case 1:
        destination = "pointA";
        break;
      case 2:
        destination = "pointB";
        break;
      case 3:
        destination = "pointC";
        break;
      case 4:
        destination = "pointD";
        break;
      case 5:
        destination = "pointE";
        break;
      default:
        destination = null;
        break;
    }
    return destination;
  }
}
