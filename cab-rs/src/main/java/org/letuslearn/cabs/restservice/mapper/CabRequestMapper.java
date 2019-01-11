package org.letuslearn.cabs.restservice.mapper;

import org.letuslearn.cabs.domain.Cab;
import org.letuslearn.cabs.restservice.dto.CabDto;

import java.util.List;
import java.util.stream.Collectors;

public final class CabRequestMapper {

  public static Cab toCab(CabDto cabDto) {
    Cab cab = new Cab();
    cab.setCapacity(cabDto.getCapacity());
    cab.setCost(cabDto.getCost());
    cab.setId(Integer.parseInt(cabDto.getId()));
    return cab;
  }

  public static List<Cab> toCabs(List<CabDto> cabList) {
    return cabList.stream().map(CabRequestMapper::toCab).collect(Collectors.toList());
  }
}
