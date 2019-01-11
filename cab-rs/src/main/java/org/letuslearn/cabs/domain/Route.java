package org.letuslearn.cabs.domain;

import lombok.Data;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Data
@Table("routes")
public class Route {

  @PrimaryKeyColumn(name="cabId", type = PrimaryKeyType.PARTITIONED)
  private int cabId;

  @Column("team_members")
  private String teamMembers;

  @Column("route")
  private String route;

  @Column("route_cost")
  private int routeCost;

}
