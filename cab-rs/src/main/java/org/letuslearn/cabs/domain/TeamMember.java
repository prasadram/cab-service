package org.letuslearn.cabs.domain;

import lombok.Data;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Data
@Table("team_members")
public class TeamMember {

  @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
  private int id;

  @Column("gender")
  private String gender;

  @Column("drop_point")
  private String dropPoint;
}
