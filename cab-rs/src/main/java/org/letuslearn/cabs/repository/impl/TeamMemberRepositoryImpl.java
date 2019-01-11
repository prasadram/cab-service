package org.letuslearn.cabs.repository.impl;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.domain.TeamMember;
import org.letuslearn.cabs.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

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

  @Override
  public List<TeamMember> getAllTeamMembers() {
    Select teamMembersSelectStatement = QueryBuilder.select().all().from("team_members");
    List<TeamMember> teamMemberList = cassandraOperations.select(teamMembersSelectStatement.getQueryString(), TeamMember.class);
    return teamMemberList;
  }
}
