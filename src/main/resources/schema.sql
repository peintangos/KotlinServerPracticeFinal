drop table kotlinserver2.User;
create table if not exists kotlinserver2.User (id int auto_increment,name varchar(100),pass varchar(100),is_deleted BOOLEAN,created_time date,Primary key(id));
--create table kotlinserver2.User (id int auto_increment,name varchar(100),pass varchar(100),Primary key(id));