CREATE SCHEMA studsitedb;

CREATE TABLE users (
  pk_Userid int(11) primary key,
  UsrFirstName varchar(255),
  UsrSurName varchar(255),
  UsrFaculty varchar(255),
  UsrDateOfBirth date,
  PRIMARY KEY (pk_Userid)
);

CREATE TABLE threads (
  pk_threadID int(11) primary key,
  Userid int(11),
  title varchar(500),
  creationDate date,
  PRIMARY KEY (pk_threadID),
  FOREIGN KEY (Userid) REFERENCES studsitedb.users (pk_Userid)
);

CREATE TABLE posts (
  pk_threadID int(11) primary key,
  threadID int(11),
  title varchar(500),
  creationDate date,
  postBody varchar(3000),
  PRIMARY KEY (pk_threadID),
  FOREIGN KEY (threadID) REFERENCES studsitedb.threads(pk_threadID)
);


