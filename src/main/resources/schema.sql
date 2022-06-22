DROP TABLE IF EXISTS person;

CREATE TABLE person
(

    id LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    surname VARCHAR(40) NOT NULL,
    email VARCHAR (40) NOT NULL UNIQUE ,
    phone VARCHAR(20) NOT NULL ,
    birth_date DATE NOT NULL ,
    age INT NOT NULL ,
    username VARCHAR(40) NOT NULL ,
    password VARCHAR(300) NOT NULL

);
