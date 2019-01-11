CREATE KEYSPACE cab_service WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE team_members (
 id int,
 gender text,
 drop_point text,
 primary key (id)
 );

CREATE TABLE cabs(
 id int,
 cost int,
 capacity int
 primary key (id)
 );

CREATE TABLE drop_points(
 source text,
 destination text,
 distance int,
 primary key (source, destination)
 );
