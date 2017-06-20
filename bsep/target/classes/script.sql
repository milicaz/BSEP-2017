drop table if exists USER;
drop table if exists BED;
drop table if exists CHAIR;
drop table if exists SHELF;
drop table if exists PROFILE;


create table USER
(
   EMAIL                   		varchar(50)                   	not null,
   PASSWORD                		varchar(50)	                   	not null,
   NAME                  		varchar(50)            			not null,
   SURNAME						varchar(50)            			not null,
   ROLE 						enum('ADMIN','BUYER', 'USER')          			not null,
   primary key (EMAIL)
);

create table BED
(
	BED_ID						bigint							PRIMARY KEY AUTO_INCREMENT,
	NAME						varchar(50)						not null,
	DESCRIPTION					varchar(100)					not null,
	PRICE						decimal							not null
);

create table CHAIR
(
	CHAIR_ID					bigint							PRIMARY KEY AUTO_INCREMENT,
	NAME						varchar(50)						not null,
	DESCRIPTION					varchar(100)					not null,
	PRICE						decimal							not null
);

create table SHELF
(
	SHELF_ID					bigint							PRIMARY KEY AUTO_INCREMENT,
	NAME						varchar(50)						not null,
	DESCRIPTION					varchar(100)					not null,
	PRICE						decimal							not null
);

create table PROFILE
(
	PROFILE_ID							bigint							not null AUTO_INCREMENT,
   	EMAIL								varchar(50)						not null,
   	PASSWORD							varchar(50)						not null,
   	NAME								varchar(50)						not null,
   	SURNAME								varchar(50)						not null,	
    primary key (PROFILE_ID)
);

insert into bsep2017.user values ('email','pass','name','surname','ADMIN');
insert into bsep2017.user values ('email1','pass1','name1','surname1','BUYER');
insert into bsep2017.user values ('email2','pass2','name2','surname2','USER');

insert into bsep2017.bed values ('1', 'bed1', 'description', '100');
insert into bsep2017.bed values ('2', 'bed2', 'description', '200');
insert into bsep2017.bed values ('3', 'bed3', 'description', '300');

insert into bsep2017.chair values ('1', 'chair1', 'description', '100');
insert into bsep2017.chair values ('2', 'chair2', 'description', '200');
insert into bsep2017.chair values ('3', 'chair3', 'description', '300');

insert into bsep2017.shelf values ('1', 'shelf1', 'description', '100');
insert into bsep2017.shelf values ('2', 'shelf2', 'description', '200');
insert into bsep2017.shelf values ('3', 'shelf3', 'description', '300');

