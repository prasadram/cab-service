package org.letuslearn.cabs.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.domain.Cab;
import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.exceptions.PreConditionFailedException;
import org.letuslearn.cabs.repository.CabRepository;
import org.letuslearn.cabs.repository.TeamMemberRepository;
import org.letuslearn.cabs.restservice.dto.CabsDto;
import org.letuslearn.cabs.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.letuslearn.cabs.restservice.mapper.CabRequestMapper.toCabs;

@Service
@Slf4j
public class CabServiceImpl implements CabService {

  @Autowired
  private CabRepository cabRepository;

  @Autowired
  private TeamMemberRepository teamMemberRepository;

  @Override
  public void addCabs(CabsDto cabsDto) {
    List<Cab> cabs = toCabs(cabsDto.getData());
    if (!validateCabs(cabs)) {
      // we can add feature like how many more cabs are required
      throw new PreConditionFailedException("API_NOT_ENOUGH_CABS", "Please provide enough cabs for team members");
    }
    cabRepository.addCabs(cabs);
  }

  private boolean validateCabs(List<Cab> cabs) {
    List<TeamMember> allTeamMembers = teamMemberRepository.getAllTeamMembers();
    int sum = cabs.stream().mapToInt(cab -> cab.getCapacity()).sum();
    if (sum < allTeamMembers.size()) {
      return false;
    }
    return true;
  }
}
