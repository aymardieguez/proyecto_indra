use master 
go
create database proyectos_sostenibles_aymar
go
use proyectos_sostenibles_aymar
go
create table organizadores(
nombre varchar(30)  not null primary key,
contacto varchar(100)
)
create table tipo_evento(
tipo varchar(100) not null primary key
)
create table eventos(
nombre varchar(30) not null primary key,
fecha date not null,
duracion smallint not null,
lugar varchar(100) not null,
tipo varchar(100) not null references tipo_evento(tipo),
organizador varchar(30) not null references organizadores(nombre)
	on update no action
	on delete cascade
)
create table usuarios(
correo_electronico varchar(200) not null primary key,
nombre varchar(30)not null,
contraseña varchar(30) not null
)
create table registran(
evento varchar(30) not null references eventos(nombre),
usuario varchar(200) not null references usuarios(correo_electronico)
	on update no action
	on delete cascade,
asistentes smallint not null,
primary key(evento, usuario)
)

