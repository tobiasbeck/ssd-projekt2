# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  customer_id                   bigint auto_increment not null,
  firstname                     varchar(255),
  lastname                      varchar(255),
  company                       varchar(255),
  address                       varchar(255),
  email                         varchar(255),
  phone                         varchar(255),
  constraint pk_customer primary key (customer_id)
);

create table project (
  project_id                    bigint auto_increment not null,
  name                          varchar(255),
  description                   varchar(255),
  buyer_id                      bigint,
  project_leader_user_id        bigint,
  constraint pk_project primary key (project_id)
);

create table user (
  user_id                       bigint auto_increment not null,
  email                         varchar(255),
  password                      varchar(255),
  name                          varchar(255),
  position                      varchar(255),
  constraint pk_user primary key (user_id)
);

alter table project add constraint fk_project_buyer_id foreign key (buyer_id) references customer (id) on delete restrict on update restrict;
create index ix_project_buyer_id on project (buyer_id);

alter table project add constraint fk_project_project_leader_user_id foreign key (project_leader_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_project_project_leader_user_id on project (project_leader_user_id);


# --- !Downs

alter table project drop foreign key fk_project_buyer_id;
drop index ix_project_buyer_id on project;

alter table project drop foreign key fk_project_project_leader_user_id;
drop index ix_project_project_leader_user_id on project;

drop table if exists customer;

drop table if exists project;

drop table if exists user;

