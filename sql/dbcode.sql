use master 
go
create database proyectos_sostenibles_aymar
go
use proyectos_sostenibles_aymar
go
--codigo de la creacion de la base de datos
create table organizadores(
nombre varchar(30)  not null primary key,
correo_electronico varchar(200) not null
)
create table telefonos(
	telefono char(9) not null primary key,
	organizador varchar(30) not null references organizadores(nombre)
		on update no action
		on delete cascade
)
create table ubicaciones(
nombre varchar(100) not null primary key
)
create table eventos(
nombre varchar(30) not null primary key,
fecha date not null,
duracion smallint not null check (duracion > 0),
categoria varchar(100) not null,
asistentes smallint default 0,
ubicacion varchar(100) not null references ubicaciones(nombre),
organizador varchar(30) not null references organizadores(nombre)
	on update no action
	on delete cascade
)
create table usuarios(
correo_electronico varchar(200) not null primary key ,
nombre varchar(30)not null,
contraseña varchar(30) not null
)
create table inscriben(
evento varchar(30) not null references eventos(nombre),
usuario varchar(200) not null references usuarios(correo_electronico)
	on update no action
	on delete cascade,
primary key(evento, usuario)
)
go

--creacion de un desencadenador que cada vez que un usuario se desinscriba de un evento, 
--se modifique la columna "asistentes" en "eventos" y se le reste uno
create or alter trigger act_eliminacion_usuario
on inscriben
after delete
as
begin
	update eventos
	set asistentes=asistentes-1
	from eventos e
		inner join deleted d on e.nombre=d.evento
end;
--creacion de un desencadenador que cada vez que un usuario se inscriba en un evento, 
--se modifique la columna "asistentes" en "eventos" y se le sume uno 
create or alter trigger act_añadir_usuario
on inscriben
after INSERT
AS
BEGIN
	update eventos
	set asistentes=asistentes+1
	from eventos e
		inner join inserted i on i.evento=e.nombre
END;