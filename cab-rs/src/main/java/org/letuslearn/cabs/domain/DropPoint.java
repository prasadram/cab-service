package org.letuslearn.cabs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Data
@AllArgsConstructor
@Table("drop_points")
public class DropPoint {

  @PrimaryKeyColumn(name = "source", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
  private String source;

  @PrimaryKeyColumn(name = "destination", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
  private String destination;

  @Column("distance")
  private int distance;
}
