/* Creación de base de datos Tienda */
create database store;
use store;

/* Tabla categoría */
create table categoria(
       idcategoria integer primary key auto_increment,
       nombre varchar(50) not null unique,
       descripcion varchar(256) null,
       activo boolean default(true)
);

/* Tabla artículo */
create table articulo(
       idarticulo integer primary key auto_increment,
       idcategoria integer not null,
       codigo varchar(50) null,
       nombre varchar(100) not null unique,
       precio_venta float(11,2) not null,
       stock integer not null,
       descripcion varchar(256) null,
       url_path varchar(512) null,
       activo boolean default(true),
       FOREIGN KEY (idcategoria) REFERENCES categoria(idcategoria)
);

/* Tabla persona */
create table persona(
       idpersona integer primary key auto_increment,
       tipo_persona varchar(20) not null,
       nombre varchar(100) not null,
       direccion varchar(70) null,
       telefono varchar(20) null,
       email varchar(50) null
);

/* Tabla rol */
create table rol(
       idrol integer primary key auto_increment,
       nombre varchar(30) not null,
       descripcion varchar(100) null,
       activo boolean default(true)
);

/* Tabla usuario */
create table usuario(
       idusuario integer primary key auto_increment,
       idrol integer not null,
       nombre varchar(100) not null,
       telefono varchar(20) null,
       email varchar(50) not null,
       password varchar(256) not null,
       activo boolean default(true),
       FOREIGN KEY (idrol) REFERENCES rol (idrol)
);

/* Tabla transaccion */
create table transaccion (
       idtransaccion integer primary key auto_increment,
       idpersona integer not null,
       idusuario integer not null,
       tipo_transaccion varchar(20) not null,-- compra o venta,
       serie_comprobante varchar(7) null,
       num_comprobante varchar (10) not null,
       fecha datetime not null,
       impuesto float (4,2) not null,
       total float (11,2) not null,
       FOREIGN KEY (idpersona) REFERENCES persona (idpersona),
       FOREIGN KEY (idusuario) REFERENCES usuario (idusuario)
);

/* Tabla detalle */
create table detalle (
       iddetalle integer primary key auto_increment,
       idtransaccion integer not null,
       idarticulo integer not null,
       cantidad integer not null,
       monto_total float(11,2) not null,
       FOREIGN KEY (idtransaccion) REFERENCES transaccion (idtransaccion) ON DELETE CASCADE,
       FOREIGN KEY (idarticulo) REFERENCES articulo (idarticulo)
);



/* POBLAR BASE DE DATOS */
/* Categoria */
insert into categoria (nombre, descripcion) values ('Electronica', null);
insert into categoria (nombre, descripcion) values ('Automotriz', null);
insert into categoria (nombre, descripcion) values ('Video Juegos', null);
insert into categoria (nombre, descripcion) values ('Calzado', null);
insert into categoria (nombre, descripcion) values ('Cocina', null);
insert into categoria (nombre, descripcion) values ('Cuidado Personal', null);
insert into categoria (nombre, descripcion) values ('Linea Blanca', null);
insert into categoria (nombre, descripcion) values ('Musica', null);
insert into categoria (nombre, descripcion) values ('Exteriores', null);
insert into categoria (nombre, descripcion) values ('Herramientas', null);

/* Artículos */
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (1, '1765227224', 'Audifonos Hyper X', 'HyperX Cloud Stinger Audifonos para gaming', 591.51, 260);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (2, '2143167334', 'Neumaticos Continental', '205/55r16 Continental Premium Contact', 1164.36, 324);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (3, '7332362856', 'Cyberpunk 2077', 'Juego para PC', 587.58, 622);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (4, '5035866432', 'Zapatos Flexi', 'Color negro 23-29cm', 633.32, 688);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (5, '3813098028', 'Sartenes Vasconia', 'Juego de sartenes de teflon', 436.59, 831);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (6, '2257346165', 'Shampoo Sedal', 'Bote de 750 ml', 92.38, 616);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (7, '9409210852', 'Refrigerador Samsung', '11 pies cúbicos Twin Cooling Plus', 2779.77, 941);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (8, '0063020807', 'Bateria Musical Acustica', '5 piezas Tambor Bombo Toms Platillos', 1491.9, 339);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (9, '1923097008', 'Banca Hampton Bay', 'Fabricada en acero, sus dimensiones son 86.5 x 127 x 63.5 cm', 1290.62, 782);
insert into articulo (idcategoria, codigo, nombre, descripcion, precio_venta, stock) values (10, '0886286786', 'Taladro Black and Decker', 'Con bateria de ion de litio recargable de 12V para uso inalambrico',  1360.4, 612);

/* Roles */
insert into rol (nombre, descripcion) values ('Administrador', 'Acceso a todo el sistema');
insert into rol (nombre, descripcion) values ('Gerente', 'Acceso a creacion y modificacion de todos las entidades en el sistema');
insert into rol (nombre, descripcion) values ('Empleado', 'Acceso suficiente para cumplir la tarea de ventas');
