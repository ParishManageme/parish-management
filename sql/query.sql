create database if not exists test;
use test;
create table user(
	id int PRIMARY KEY AUTO_INCREMENT,
	identifier varchar(250) NOT NULL UNIQUE,
	password varchar(250) NOT NULL,
	type varchar(1) NOT NULL,
	belongs_to int
);
insert into user (identifier, password, type) values('admin', 'admin', 'admin');

create table if not exists address(
	id int PRIMARY KEY AUTO_INCREMENT,
	door_no varchar(10) NOT NULL,
	street	varchar(255) NOT NULL,
	town varchar(255) NOT NULL,
	taluk varchar(255) NOT NULL,
	district varchar(255) NOT NULL,
	state varchar(255) NOT NULL,
	country varchar(255) NOT NULL,
	pincode int NOT NULL
);

create table if not exists church(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	address_fk int NOT NULL,	
	diocese varchar(255) NOT NULL,
	landline_no bigint NOT NULL,
	mobile_no bigint NOT NULL,
	email_id varchar(100) NOT NULL,
	CONSTRAINT fk_address FOREIGN KEY(address_fk) REFERENCES address(id) 
);

create table if not exists church_add_info(
	id int PRIMARY KEY AUTO_INCREMENT,
	intro text,
	history text,
	church_fk int,
	CONSTRAINT fk_church FOREIGN KEY(church_fk) REFERENCES church(id)  
);

create table if not exists priest(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	dob date NOT NULL,
	education varchar(200) NOT NULL,
	specialization varchar(200) NOT NULL,
	birth_place varchar(200) NOT NULL,
	educated_university varchar(200) NOT NULL,
	landline_no bigint,
	mobile_no bigint NOT NULL,
	email_id varchar(100),
	diocese varchar(100) NOT NULL,
	additional_position varchar(255),
	current_church_fk int NOT NULL,
	CONSTRAINT fk_current_church FOREIGN KEY(current_church_fk) REFERENCES church(id)
);

