drop table if exists member;
drop table if exists friend_request;
drop table if exists offline_message;
drop table if exists member_friend;
create table member
(code bigint primary key auto_increment,
email_id char(100) unique,
username char(100) not null unique ,
contact_number char(15) unique ,
password char(100),
password_key char(100),
name char(25))engine=innodb;

create table friend_request
( from_member_code bigint not null,
to_member_code bigint not null,
date_of_request char(20) not null,
time_of_request char(20) not null)engine=innodb;

create table offline_message
(code bigint primary key auto_increment, 
from_name_code bigint not null,
to_name_code bigint not null,
sending_date char(20) not null,
sending_time char(20) not null,
message varchar(1000))engine=innodb;

create table member_friend
(member_code bigint  not null,
friend_member_code bigint not null,
constraint pk_member_friend primary key(member_code,friend_member_code))engine=innodb;