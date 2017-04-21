CREATE SCHEMA studsitedb;

CREATE TABLE studsitedb.users (
  pk_Userid int(11),
  
  UsrFirstName varchar(255),
  UsrLastName varchar(255),
  UsrFaculty varchar(255),
  UsrDateOfBirth date,
  
  PRIMARY KEY (pk_Userid)
);


CREATE TABLE studsitedb.forums (
	pk_forumID int(11),
	
	title varchar(500),
	creationDate date,
	shortDescription varchar(1000),
	
    PRIMARY KEY (pk_forumID)
);


CREATE TABLE studsitedb.threads (
  pk_threadID int(11),
  
  title varchar(500),
  shortDescription varchar(1000),
  creationDate date,
  
  Userid int(11),
  Forumid int(11),

  PRIMARY KEY (pk_threadID),
  FOREIGN KEY (Userid) REFERENCES studsitedb.users (pk_Userid),
  FOREIGN KEY (Forumid) REFERENCES studsitedb.forums (pk_forumID)
);

CREATE TABLE studsitedb.posts (
  pk_postID int(11),
  
  threadID int(11),
  userID int(11),
  
  title varchar(500),
  creationDate date,
  postBody varchar(3000),
  
  PRIMARY KEY (pk_postID),
  FOREIGN KEY (threadID) REFERENCES studsitedb.threads(pk_threadID),
  FOREIGN KEY (userID) REFERENCES studsitedb.users(pk_Userid)
);






