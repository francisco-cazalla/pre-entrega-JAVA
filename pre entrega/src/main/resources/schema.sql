CREATE TABLE cliente (
ID int autoincrement PRIMARY KEY,
NOMBRE  varchar (150) not null ,
apellido varchar(150) not null,
dni  int not null,
);


CREATE TABLE producto (
ID int autoincrement PRIMARY KEY,
nombre varchar(150) not null,
stock int not null,
precio int,
descripcion varchar(50)
);

CREATE TABLE venta (
ID int autoincrement PRIMARY KEY,
ventas int not null,
ganancias int not null,
producto varchar(150) not null,
descripcion varchar(50)
);