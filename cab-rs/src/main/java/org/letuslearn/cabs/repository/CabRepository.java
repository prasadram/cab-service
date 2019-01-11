package org.letuslearn.cabs.repository;

import org.letuslearn.cabs.domain.Cab;

import java.util.List;

public interface CabRepository {

  List<Cab> addCabs(List<Cab> cabList);
}
