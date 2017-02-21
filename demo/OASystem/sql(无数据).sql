--------------------------------------------------------------drop table
DROP TABLE card;
DROP TABLE cardtype;

DROP TABLE distributecar;
DROP TABLE car;

DROP TABLE manager;
DROP TABLE employee;
DROP TABLE department;
DROP TABLE job;

DROP TABLE notice;

DROP TABLE inventory;
DROP TABLE inventorytype;

DROP TABLE expatriaterecord;
DROP TABLE expatriate;
DROP TABLE cooperatecompany;

----------------------------------------------------------------create table

-- ??
CREATE TABLE department(
      department_id NUMBER(6) PRIMARY KEY,
      department_name VARCHAR2(30),
      department_desc VARCHAR2(200),
      department_tel VARCHAR2(20)
);

-- ??
CREATE TABLE job(
      job_id NUMBER(6) PRIMARY KEY, 
      job_name VARCHAR2(30),
      job_desc VARCHAR2(200)
);

-- ??
CREATE TABLE employee(
     employee_id NUMBER(6) PRIMARY KEY,
     employee_name VARCHAR2(30),
     sex VARCHAR2(2),
     birth DATE,
     passwd VARCHAR2(16),
     job_id INT  REFERENCES job(job_id),
     department_id INT  REFERENCES department(department_id)
);

-- ???
CREATE TABLE manager (
    employee_id NUMBER(6) REFERENCES employee (employee_id)
);

-- ????
CREATE TABLE cardtype(
   cardtype_id NUMBER(6) PRIMARY KEY,
   cardtype_name VARCHAR2(20),
   employee_id INT,
   FOREIGN KEY(employee_id) REFERENCES employee(employee_id) 
);

-- ??
CREATE TABLE CARD(
   CARD_ID NUMBER(6)  primary key,
   CARD_NAME varchar2(20),
   PHONE varchar2(20),
   ADDRESS varchar2(50),
   CARD_QQ varchar2(15),
   EMAIL Varchar2(30),
   COMPANY varchar2(50),
   IDENTITY varchar2(100),
   CARDTYPE_ID NUMBER(6),
   FOREIGN KEY(cardtype_id) REFERENCES cardtype(cardtype_id)   
);


-- ??
CREATE TABLE car(
   car_id  NUMBER(6) PRIMARY KEY,
   car_type VARCHAR2(20),
   car_tag VARCHAR2(10),
   car_pic Blob
);

-- ????
CREATE TABLE distributecar(
   distributecar_id  NUMBER(6) PRIMARY KEY,
   route VARCHAR2(30),
   start_date DATE,
   end_date DATE,
   state VARCHAR2(10),
   employee_id NUMBER(6)REFERENCES employee(employee_id),
   car_id NUMBER(6)REFERENCES car(car_id)
 );
 
-- ??
CREATE TABLE notice
(
   notice_id NUMBER(6) PRIMARY KEY,
   title VARCHAR(20),
   content VARCHAR2(1000),
   notice_time DATE
);

-- ????
CREATE TABLE inventorytype(
       inventorytype_id NUMBER(6) PRIMARY KEY,
       inventorytype_name VARCHAR2(20)
);

-- ??
CREATE TABLE inventory(
       inventory_id  NUMBER(6) PRIMARY KEY,
       inventory_name VARCHAR2(20),
       num INT,
       price FLOAT,
       inventorytype_id NUMBER(6),
       FOREIGN KEY(inventorytype_id) REFERENCES  inventorytype(inventorytype_id) 
);

-- ????
CREATE TABLE expatriate(
       expatriate_id NUMBER(6) PRIMARY KEY,
       expatriate_name VARCHAR2(20),
       expatriate_skill VARCHAR2(50),
       expatriate_salary FLOAT,
	expatriate_state VARCHAR2(10)
);

-- ????
CREATE TABLE cooperatecompany(
       cooperatecompany_id NUMBER(6)  PRIMARY KEY,
       cooperatecompany_name VARCHAR(50),
       cooperatecompany_person VARCHAR(20),
       cooperatecompany_address VARCHAR2(20),
       cooperatecompany_tel VARCHAR2(20)
);

-- ????
CREATE TABLE expatriaterecord(
       expatriaterecord_id NUMBER(6) PRIMARY KEY,
       expatriate_id NUMBER(6) REFERENCES expatriate(expatriate_id),
       cooperatecompany_id NUMBER(6) REFERENCES cooperatecompany(cooperatecompany_id)
      
);


--------------------------------------------------------------drop sequence

drop sequence dept_seq;
drop sequence job_seq;
drop sequence emp_seq;
drop sequence cardtype_seq;
drop sequence card_seq;
drop sequence car_seq;

drop sequence distributecar_seq;

drop sequence notice_seq;
drop sequence inventorytype_seq;
drop sequence inventory_seq;
drop sequence expatriate_seq;
drop sequence cooperatecompany_seq;
drop sequence expatriaterecord_seq;

-----------------------------------------------------------------???

--?????
create sequence dept_seq;
create sequence job_seq;
create sequence emp_seq;
create sequence cardtype_seq;
create sequence card_seq;
create sequence notice_seq;
create sequence inventorytype_seq;
create sequence inventory_seq;
create sequence expatriate_seq;
create sequence cooperatecompany_seq;
create sequence expatriaterecord_seq;
create sequence car_seq;

create sequence distributecar_seq;

commit