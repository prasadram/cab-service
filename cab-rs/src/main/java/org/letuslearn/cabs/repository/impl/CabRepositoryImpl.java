package org.letuslearn.cabs.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.letuslearn.cabs.domain.Cab;
import org.letuslearn.cabs.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class CabRepositoryImpl implements CabRepository {
  @Autowired
  CassandraOperations cassandraOperations;

  @Override
  public List<Cab> addCabs(List<Cab> cabList) {
    List<Cab> resultList = new ArrayList<>();
    log.info("op=addCabs, status=OK, desc=adding cabs");
    cabList.forEach(cab -> resultList.add(cassandraOperations.insert(cab)));
    return resultList;
  }
}
