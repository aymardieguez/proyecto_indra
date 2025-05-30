use master 
go
create database proyectos_sostenibles_aymar
go
use proyectos_sostenibles_aymar
go
create table organizadores
(
	nombre varchar(30) not null primary key,
	email varchar(200) not null,
	telefono char(9) not null check (telefono like '6[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
)
create table ubicaciones
(
	id_ubicacion tinyint not null primary key,
	tipo varchar(20) not null check (tipo in ('presencial','telematico')),
	localidad varchar(100),
	direccion varchar(200),
	check(
	(tipo= 'telematico' and localidad is null and direccion is null)
	 or(tipo='presencial' and localidad is not null and direccion is not null)
)
)
create table categorias
(
	nombre varchar(100) not null primary key,
	descripcion varchar(200)not null
)
create table eventos
(
	codigo tinyint not null primary key,
	nombre varchar(30) not null ,
	fecha date not null,
	duracion time not null check (duracion > '00:00:00'),
	categoria varchar(100) not null references categorias(nombre)
	on update no action
	on delete cascade,
	ubicacion tinyint not null references ubicaciones(id_ubicacion)
	on update no action
	on delete cascade,
	organizador varchar(30) not null references organizadores(nombre)
	on update no action
	on delete cascade
)
create table usuarios
(
	email varchar(200) not null primary key ,
	nombre varchar(30)not null,
	contraseña varchar(15) not null
)
create table inscriben
(
	evento tinyint not null references eventos(codigo),
	usuario varchar(200) not null references usuarios(email)
	on update no action
	on delete cascade,
	primary key(evento, usuario)
)
go
