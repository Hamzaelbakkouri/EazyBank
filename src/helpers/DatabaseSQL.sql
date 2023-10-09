create database EasyBank;
drop table account;
create table person
(
    id          serial primary key,
    firstName   varchar(50),
    lastNAme    varchar(50),
    dateOfBirth date,
    phoneNumber varchar(10)
);
CREATE TABLE client
(
    id     int primary key references person (id) ON DELETE CASCADE,
    code   varchar(100) unique,
    adress varchar(100)
);
create table employe
(
    id                 int primary key references person (id) ON DELETE CASCADE,
    registrationNumber varchar(100) unique,
    recrutmentDate     date,
    email              varchar(100)
);
create type "status" as enum ('active','inactive');
create table account
(
    accountNumber varchar(100) primary key,
    balance       double precision,
    creationDate  date,
    client_code   varchar(100) references client (code),
    employee_code varchar(100) references employe (registrationNumber),
    status        status,
    agence_code   varchar(100) references agence (code)
);
drop table agence;
create table currentAccount
(
    id       varchar(100) primary key references account (accountNumber) ON DELETE CASCADE,
    maxPrice double precision
);
create table SavingAccount
(
    id           varchar(100) primary key references account (accountNumber) ON DELETE CASCADE,
    interestRate double precision
);
create type operationType as enum ('payment','withdrawal');
create table operation
(
    operationNumber serial primary key,
    date            date,
    price           double precision,
    employee_code   varchar(100) references employe (registrationNumber)
);
create table SimpleOperation
(
    type         operationType,
    account_code varchar(100) references account (accountNumber)
) inherits (operation);

create table Transfer
(
    account_code_from varchar(100) references account (accountNumber),
    account_code_to   varchar(100) references account (accountNumber)
) inherits (operation);
create table "mission"
(
    code        varchar(100) primary key,
    name        varchar(100),
    description varchar(500)
);
create table "affectation"
(
    startDate                 date,
    endDate                   date,
    mission_code              varchar(100) references mission (code),
    emloye_registrationNumber varchar(100) references employe (registrationNumber)
);

create table agence
(
    code        varchar(100) primary key,
    name        varchar(100),
    adresse     varchar(100),
    phonenumber varchar(100)
);

create table EmployeeAffectation
(
    agence_id     varchar(100) references agence (code),
    employee_code varchar(100) references employe (registrationNumber),
    creationDate  date
);
