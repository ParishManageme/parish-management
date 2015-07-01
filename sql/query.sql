create database if not exists test;
use test;

create table parish(
	parish_id int PRIMARY KEY AUTO_INCREMENT,
	parish_name varchar(255) NOT NULL,
	parish_door_no varchar(10) NOT NULL,
	parish_street varchar(255) NOT NULL,
	parish_village varchar(255) NOT NULL,
	parish_taluk varchar(255),
	parish_district varchar(255) NOT NULL,
	parish_state varchar(255) NOT NULL,
	parish_country varchar(255) NOT NULL,
	parish_pincode int NOT NULL,
	is_active boolean NOT NULL,
	created_on timestamp NOT NULL
);

insert into parish (parish_name, parish_door_no, parish_street, parish_village, parish_district, parish_state, parish_country, parish_pincode, is_active, created_on)
values('coop', '666', 'wall street', 'broadway', 'manhattan', 'NY', 'america', 123456, true, now());

create table if not exists church_info(
	church_id int PRIMARY KEY AUTO_INCREMENT,
	church_name varchar(255) NOT NULL,
	church_door_no varchar(10) NOT NULL,
	church_street varchar(255) NOT NULL,
	church_village varchar(255) NOT NULL,
	church_taluk varchar(255),
	church_district varchar(255) NOT NULL,
	church_state varchar(255) NOT NULL,
	church_country varchar(255) NOT NULL,
	church_pincode int NOT NULL,
	church_diocese varchar(255) NOT NULL,
	church_telephone_no bigint NOT NULL,
	church_mobile_no bigint NOT NULL,
	church_email_id varchar(100) NOT NULL,
	is_active boolean NOT NULL,
	parish_id int NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL
);

create table if not exists church_add_info(		
	id int PRIMARY KEY AUTO_INCREMENT,	
	church_id int,
	church_info varchar(1024),
	CONSTRAINT fk_church FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);

create table user(
	user_id int PRIMARY KEY AUTO_INCREMENT,
	user_identifier varchar(250) NOT NULL UNIQUE,
	user_password varchar(250) NOT NULL,
	user_role varchar(10) NOT NULL,
	parish_id int NOT  NULL,
	church_id int,
	is_active boolean NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL,
	CONSTRAINT fk_parish_id FOREIGN KEY(parish_id) REFERENCES parish(parish_id)
);

insert into user (user_identifier, user_password, user_role, parish_id, is_active, created_on, created_by, last_modified_on, last_modified_by) values('padmin', 'padmin', 'A', 1, true, now(), 0, now(), 0),
	('parishadmin', 'parishadmin','PA', 1, true, now(), 1, now(), 1),
	('churchadmin', 'churchadmin','CA', 1, true, now(), 2, now(), 2),
	('churchuser', 'churchuser','CU', 1, true , now(), 3, now(), 3);

create table if not exists church_add_info(		
	id int PRIMARY KEY AUTO_INCREMENT,	
	church_id int,
	church_info varchar(1024),
	CONSTRAINT fk_church FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);


create table if not exists priest_info(
	priest_id int PRIMARY KEY AUTO_INCREMENT,
	priest_name varchar(255) NOT NULL,
	priest_dob date,
	priest_education varchar(200) NOT NULL,
	priest_specialization varchar(200) NOT NULL,
	priest_birth_place varchar(200) NOT NULL,
	priest_educated_university varchar(200) NOT NULL,
	priest_door_no varchar(10) NOT NULL,
	priest_street varchar(255) NOT NULL,
	priest_village varchar(255) NOT NULL,
	priest_taluk varchar(255),
	priest_district varchar(255) NOT NULL,
	priest_state varchar(255) NOT NULL,
	priest_country varchar(255) NOT NULL,
	priest_pincode int NOT NULL,	
	priest_telephone_no bigint,
	priest_mobile_no bigint NOT NULL,
	priest_email_id varchar(100),
	priest_diocese varchar(100) NOT NULL,
	priest_additional_position varchar(255),
	priest_image varchar(255),
	church_id int NOT NULL,
	is_active boolean,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL,
	CONSTRAINT fk_current_church FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);

create table if not exists priest_add_info(
	id int PRIMARY KEY AUTO_INCREMENT,	
	priest_id int NOT NULL,	
	priest_info varchar(1024),
	CONSTRAINT fk_priest FOREIGN KEY(priest_id) REFERENCES priest_info(priest_id)
);


create table if not exists church_events(
	event_id int PRIMARY KEY AUTO_INCREMENT,
	event_name varchar(300) NOT NULL,
	event_date_time timestamp,
	event_description varchar(300) NOT NULL,	
	event_details varchar(1024) NOT NULL,
	is_active boolean NOT NULL,
	church_id int NOT NULL,	
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL,
	CONSTRAINT fk_event FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);
