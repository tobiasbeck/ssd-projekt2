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
  buyer_customer_id             bigint,
  project_leader_user_id        bigint,
  constraint pk_project primary key (project_id)
);

create table task (
  task_id                       bigint auto_increment not null,
  title                         varchar(255),
  description                   varchar(255),
  time                          integer,
  assigned_to_user_id           bigint,
  project_project_id            bigint,
  constraint pk_task primary key (task_id)
);

create table user (
  user_id                       bigint auto_increment not null,
  email                         varchar(255),
  password                      varchar(255),
  name                          varchar(255),
  position                      varchar(255),
  constraint pk_user primary key (user_id)
);

alter table project add constraint fk_project_buyer_customer_id foreign key (buyer_customer_id) references customer (customer_id) on delete restrict on update restrict;
create index ix_project_buyer_customer_id on project (buyer_customer_id);

alter table project add constraint fk_project_project_leader_user_id foreign key (project_leader_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_project_project_leader_user_id on project (project_leader_user_id);

alter table task add constraint fk_task_assigned_to_user_id foreign key (assigned_to_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_task_assigned_to_user_id on task (assigned_to_user_id);

alter table task add constraint fk_task_project_project_id foreign key (project_project_id) references project (project_id) on delete restrict on update restrict;
create index ix_task_project_project_id on task (project_project_id);


# --- !Downs

alter table project drop foreign key fk_project_buyer_customer_id;
drop index ix_project_buyer_customer_id on project;

alter table project drop foreign key fk_project_project_leader_user_id;
drop index ix_project_project_leader_user_id on project;

alter table task drop foreign key fk_task_assigned_to_user_id;
drop index ix_task_assigned_to_user_id on task;

alter table task drop foreign key fk_task_project_project_id;
drop index ix_task_project_project_id on task;

drop table if exists customer;

drop table if exists project;

drop table if exists task;

drop table if exists user;

