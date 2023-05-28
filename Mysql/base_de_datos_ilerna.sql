drop database IF EXISTS ilerna;
CREATE DATABASE IF NOT EXISTS ilerna;
USE ilerna; 

CREATE TABLE fp (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  descripcion VARCHAR(300) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE turno (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE asignatura (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  fp_id INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE profesor (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  correo VARCHAR(100) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  contrasena VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE aula (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE grupo (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  id_periodo INT NOT NULL,
  id_fp INT NOT NULL,
  id_turno INT NOT NULL,
  id_modalidad INT NOT NULL,
  PRIMARY KEY (id)
);

 CREATE TABLE periodo (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

 CREATE TABLE modalidad (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE expediente (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  id_grupo INT NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE dia_semana (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE calendario (
  id INT NOT NULL AUTO_INCREMENT,
  id_dia_semana INT NOT NULL,
  hora_inicio TIME NOT NULL,
  hora_final TIME NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE horario (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE horario_detalle (
  id INT NOT NULL AUTO_INCREMENT,
  id_horario INT NOT NULL,
  id_calendario INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE asignatura_grupo (
  id INT NOT NULL AUTO_INCREMENT,
  id_asignatura INT NOT NULL,
  id_profesor INT NOT NULL,
  id_aula INT NOT NULL,
  id_horario INT NOT NULL,
  id_grupo INT NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE alumno (
  id INT NOT NULL AUTO_INCREMENT,
  dni VARCHAR (15) ,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  correo VARCHAR(250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE alumno_grupo (
  id INT NOT NULL AUTO_INCREMENT,
  id_grupo INT NOT NULL,
  id_alumno INT NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE asistencia (
  id INT NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  id_alumno INT NOT NULL,
  id_horario_detalle INT NOT NULL,
  id_tipo_asistencia INT NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE tipo_asistencia (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR (50) NOT NULL,
  PRIMARY KEY (id)
);



