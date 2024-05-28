-- Active: 1700601815243@@127.0.0.1@3306@colegio
-- DDL Data Definition Language

-- Extensión MySQL Weijan Chen

drop database if exists colegio;
create database colegio;
use colegio;

create table cursos(
	id int auto_increment primary key,
    titulo varchar(25) not null check(length(titulo)>=3),
    profesor varchar(25) not null check(length(profesor)>=3),
    dia enum('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES'),
	turno enum('MAÑANA','TARDE','NOCHE')
);

create table alumnos(
	id int auto_increment primary key,
    nombre varchar(25) not null check(length(nombre)>=3),
    apellido varchar(25) not null  check(length(apellido)>=3),
    edad int check (edad>=18 and edad<=120),
    idCurso int not null
);

alter table alumnos 
	add constraint FK_Alumnos_IdCurso
    foreign key(idCurso)
    references cursos(id);
