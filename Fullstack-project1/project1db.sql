create database project1db;

use project1db;


create table users (
id int primary key auto_increment,
email varchar(50) unique not null,
password varchar(128) not null);

create table accounts (
id int primary key auto_increment,
balance double check(balance>0),
transactiontype varchar(20) not null,
user_id  int, foreign key(user_id) references users(id));

create table transaction (
id int primary key auto_increment,
amount double check(amount>0),
date Date not null,
transactiontype varchar(20) not null,
account_id int, foreign key(account_id) references accounts(id));