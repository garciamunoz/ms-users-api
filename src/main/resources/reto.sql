create database reto;
use reto;


create table tb_usuario(
	id Integer not null AUTO_INCREMENT,
    username varchar(200) not null,
    email varchar(200) not null,
    creationdate TIMESTAMP DEFAULT NOW(),
    modifieddate TIMESTAMP DEFAULT NOW(),
    lastlogin timestamp,
    token varchar(500) ,
    isactive boolean,
    pwd varchar(800) not null ,
     PRIMARY KEY (id)
);

-- table phone

create table tb_phone(
	id Integer not null AUTO_INCREMENT,
    idUser Integer not null,
	phonecountrycode varchar(200) not null,
    phonecitycode varchar(200) not null,
    phonenumber varchar(200) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (idUser)
        REFERENCES tb_usuario(id)
);


