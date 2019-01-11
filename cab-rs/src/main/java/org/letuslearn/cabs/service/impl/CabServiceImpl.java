package org.letuslearn.cabs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.repository.CabRepository;
import org.letuslearn.cabs.restservice.dto.CabsDto;
import org.letuslearn.cabs.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.letuslearn.cabs.restservice.mapper.CabRequestMapper.toCabs;

@Service
@Slf4j
public class CabServiceImpl implements CabService {

  @Autowired
  private CabRepository cabRepository;

  @Override
  public void addCabs(CabsDto cabsDto) {
      cabRepository.addCabs(toCabs(cabsDto.getData()));
  }
}
