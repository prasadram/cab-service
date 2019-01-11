package org.letuslearn.cabs.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TeamMemberRepositoryImpl implements TeamMemberRepository {
  @Autowired
  CassandraOperations cassandraOperations;

  @Override
  public TeamMember addMember(TeamMember teamMember) {
    TeamMember insertedTeamMember = cassandraOperations.insert(teamMember);
    log.info("op=addMember, status=OK, desc=register member");
    return insertedTeamMember;
  }
}
