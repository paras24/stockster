drop database if exists globalsoldb;
create database if not exists globalsoldb;
show databases;
use globalsoldb;
drop table if exists services;
create table if not exists services(
id int(10) unsigned auto_increment not null,
title varchar(60) not null,
description varchar(300) not null,
details LONGTEXT not null,
date_modified timestamp default current_timestamp on update current_timestamp,
primary key (id)
);

desc services;

