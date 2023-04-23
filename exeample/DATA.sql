drop database myjavaappl;
create database myjavaappl;
use myjavaappl;
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(80),
    apellido VARCHAR(80),
    correo VARCHAR(80),
    telefono VARCHAR(80),
    direccion VARCHAR(80)
);