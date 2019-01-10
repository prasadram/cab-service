package org.letuslearn.cabs.domain;

import lombok.Data;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Data
@Table("cabs")
public class Cab {

  @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
  private int id;

  @Column("cost")
  private int cost;

  @Column("capacity")
  private int capacity;
}
