create database EasyBank;
drop table "person" ;
create table person (
    id serial primary key ,
    firstName varchar(50),
    lastNAme varchar(50),
    dateOfBirth date,
    phoneNumber varchar(10)
);
CREATE TABLE "client" (
    id int references person(id) primary key ,
    code varchar(100) primary key ,
    adress varchar(100)
);
create table "employe" (
    id int references person(id) primary key,
    registrationNumber varchar(100) primary key ,
    recrutmentDate date,
    email varchar(100)
);
create type "status" as enum ('active','inactive');
create table "account" (
  accountNumber varchar(100) primary key ,
  balance double precision ,
  creationDate date,
  client_code varchar(100) references client(code),
  status status
);
create table "currentAccount" (
  id int references account(accountNumber) primary key ,
  maxPrice double precision
);
create table "SavingAccount" (
    interestRate double precision,
    id int references account(accountNumber) primary key
);
create type "operationType" as enum ('payment','withdrawal');
create table "operation" (
    operationNumber serial primary key ,
    date date ,
    type "operationType",
    price double precision,
    accountNumber varchar(100) references account(accountNumber),
    registrationNumber varchar(100) references employe(registrationNumber)
);
create table "mission" (
    code varchar(100) primary key ,
    name varchar(100),
    description varchar(500)
);
create table "affectation" (
  startDate date,
  endDate date,
  mission_code varchar(100) references mission(code) primary key,
  emloye_registrationNumber varchar(100) references employe(registrationNumber) primary key
);