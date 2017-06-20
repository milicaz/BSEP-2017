drop table if exists USER;
drop table if exists BED;
drop table if exists CHAIR;
drop table if exists SHELF;
drop table if exists PROFILE;
drop table if exists BASKET_LIST_BEDS;
drop table if exists BASKET_LIST_CHAIRS;
drop table if exists BASKET_LIST_SHIFTS;
drop table if exists BASKET_LIST;
drop table if exists ORDERED_BED;
drop table if exists ORDERED_CHAIR;
drop table if exists ORDERED_SHELF;



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


create table ORDERED_BED
(
	ORDERED_BED_ID						bigint													not null AUTO_INCREMENT,
   	QUANTITY							INT	            										not null,
   	BED									bigint													not null,
   	BED_STATUS							enum('ORDERED', 'PREPARED')								not null,
    primary key (ORDERED_BED_ID),
   	FOREIGN KEY (BED) REFERENCES BED(BED_ID) ON DELETE CASCADE ON UPDATE CASCADE

);

create table ORDERED_CHAIR
(
	ORDERED_CHAIR_ID						bigint													not null AUTO_INCREMENT,
   	QUANTITY								INT	            										not null,
   	CHAIR									bigint													not null,
   	CHAIR_STATUS							enum('ORDERED', 'PREPARED')								not null,
    primary key (ORDERED_CHAIR_ID),
   	FOREIGN KEY (CHAIR) REFERENCES CHAIR(CHAIR_ID) ON DELETE CASCADE ON UPDATE CASCADE

);

create table ORDERED_SHELF
(
	ORDERED_SHELF_ID						bigint													not null AUTO_INCREMENT,
   	QUANTITY								INT	            										not null,
   	SHELF									bigint													not null,
   	SHELF_STATUS							enum('ORDERED', 'PREPARED')								not null,
    primary key (ORDERED_SHELF_ID),
   	FOREIGN KEY (SHELF) REFERENCES SHELF(SHELF_ID) ON DELETE CASCADE ON UPDATE CASCADE

);

create table BASKET_LIST
(
	BASKET_ID						bigint							not null AUTO_INCREMENT,
   	USER							varchar(50)						,
   	BEDS							bigint							,
   	CHAIRS							bigint							,
   	SHELFS							bigint							,
    primary key (BASKET_ID),
   	FOREIGN KEY (USER) REFERENCES USER(EMAIL) ON DELETE CASCADE ON UPDATE CASCADE,
   	FOREIGN KEY (BEDS) REFERENCES ORDERED_BED(ORDERED_BED_ID) ON DELETE CASCADE ON UPDATE CASCADE,
   	FOREIGN KEY (CHAIRS) REFERENCES ORDERED_CHAIR(ORDERED_CHAIR_ID) ON DELETE CASCADE ON UPDATE CASCADE,
   	FOREIGN KEY (SHELFS) REFERENCES ORDERED_SHELF(ORDERED_SHELF_ID) ON DELETE CASCADE ON UPDATE CASCADE

);

create table BASKET_LIST_BEDS
(
	BASKET_LIST_BEDS_ID				bigint							not null AUTO_INCREMENT,
	BASKET_BASKET_ID				bigint							not null,
	BEDS_ORDERED_BED_ID				bigint							not null,
	primary key (BASKET_LIST_BEDS_ID),
	FOREIGN KEY (BASKET_BASKET_ID) REFERENCES BASKET_LIST(BASKET_ID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (BEDS_ORDERED_BED_ID) REFERENCES ORDERED_BED(ORDERED_BED_ID) ON DELETE CASCADE ON UPDATE CASCADE
);

create table BASKET_LIST_CHAIRS
(
	BASKET_LIST_CHAIRS_ID			bigint							not null AUTO_INCREMENT,
	BASKET_BASKET_ID				bigint							not null,
	CHAIRS_ORDERED_CHAIR_ID			bigint							not null,
	primary key (BASKET_LIST_CHAIRS_ID),
	FOREIGN KEY (BASKET_BASKET_ID) REFERENCES BASKET_LIST(BASKET_ID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (CHAIRS_ORDERED_CHAIR_ID) REFERENCES ORDERED_CHAIR(ORDERED_CHAIR_ID) ON DELETE CASCADE ON UPDATE CASCADE
);

create table BASKET_LIST_SHELFS
(
	BASKET_LIST_SHELFS_ID			bigint							not null AUTO_INCREMENT,
	BASKET_BASKET_ID				bigint							not null,
	SHELFS_ORDERED_SHELF_ID			bigint							not null,
	primary key (BASKET_LIST_SHELFS_ID),
	FOREIGN KEY (BASKET_BASKET_ID) REFERENCES BASKET_LIST(BASKET_ID) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (SHELFS_ORDERED_SHELF_ID) REFERENCES ORDERED_SHELF(ORDERED_SHELF_ID) ON DELETE CASCADE ON UPDATE CASCADE
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

