drop database IF EXISTS ilerna;
CREATE DATABASE IF NOT EXISTS ilerna;
USE ilerna; 

CREATE TABLE profesor (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  correo VARCHAR(100) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE fp (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  descripcion VARCHAR(500) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE dia_semana (
  id INT,
  nombre VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE asignatura (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  fp_id INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE curso (
  id INT NOT NULL AUTO_INCREMENT,
  fp_id INT NOT NULL,
  asignatura_id INT NOT NULL,
  turno VARCHAR(100) NOT NULL,
  profesor_id INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE curso_horario (
  id INT NOT NULL AUTO_INCREMENT,
  curso_id INT NOT NULL,
  dia_semana INT NOT NULL,
  hora_inicio TIME NOT NULL,
  hora_fin TIME NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE alumno (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  correo VARCHAR(250) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE alumno_horario (
  id INT NOT NULL AUTO_INCREMENT,
  alumno_id INT NOT NULL,
  curso_id INT NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE tipo_inasistencia (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE inasistencia (
  id INT NOT NULL AUTO_INCREMENT,
  alumno_id INT NOT NULL,
  curso_id INT NOT NULL,
  fecha DATE NOT NULL,
  tipo_inasistencia_id INT NOT NULL,
  observaciones VARCHAR(500),
  PRIMARY KEY (id)
);


