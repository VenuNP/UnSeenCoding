create database springboot_jdbc_test;

use springboot_jdbc_test;

create table users(id INT(10) PRIMARY KEY auto_increment, name VARCHAR(25), city VARCHAR(25),
date_of_birth date,gender CHAR,married TINYINT(1),
created_at DATETIME, updated_at DATETIME );


create table users_audit(id INT(10) PRIMARY KEY auto_increment, name VARCHAR(25), city VARCHAR(25),
date_of_birth date,gender CHAR,married TINYINT(1),
created_at DATETIME, updated_at DATETIME,audit_user_id INT references users(id),
 updated_user_id INT references users(id)  );
