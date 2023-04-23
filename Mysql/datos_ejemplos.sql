use ilerna;
INSERT INTO profesor (nombre, apellido, correo, telefono)
VALUES
  ('Juan', 'Pérez', 'juan.perez@ejemplo.com', '555-1234'),
  ('María', 'González', 'maria.gonzalez@ejemplo.com', '555-5678'),
  ('Pedro', 'Hernández', 'pedro.hernandez@ejemplo.com', '555-9012'),
  ('Laura', 'Martínez', 'laura.martinez@ejemplo.com', '555-3456'),
  ('Santiago', 'Gómez', 'santiago.gomez@ejemplo.com', '555-7890');


INSERT INTO alumno (nombre, apellido, correo)
VALUES
  ('Ana', 'López', 'ana.lopez@ejemplo.com'),
  ('Carlos', 'Sánchez', 'carlos.sanchez@ejemplo.com'),
  ('Lucía', 'García', 'lucia.garcia@ejemplo.com'),
  ('Diego', 'Ramírez', 'diego.ramirez@ejemplo.com'),
  ('Marcela', 'Torres', 'marcela.torres@ejemplo.com');

INSERT INTO dia_semana (id, nombre)
VALUES
  (1, 'lunes'),
  (2, 'Martes'),
  (3, 'Miercoles'),
  (4, 'jueves'),
  (5, 'viernes'),
  (6, 'sabado'),
  (7, 'domingo');
   
   
INSERT INTO `ilerna`.`fp` (`nombre`, `descripcion`) VALUES ('daw', 'desarrollo web');
INSERT INTO `ilerna`.`fp` (`nombre`, `descripcion`) VALUES ('dam', 'desarrollo multiplataforma');

INSERT INTO `ilerna`.`asignatura` (`nombre`, `fp_id`) VALUES ('programacion I', '1');
INSERT INTO `ilerna`.`asignatura` (`nombre`, `fp_id`) VALUES ('lenguaje de marca ', '1');
INSERT INTO `ilerna`.`asignatura` (`nombre`, `fp_id`) VALUES ('fol', '1');
INSERT INTO `ilerna`.`asignatura` (`nombre`, `fp_id`) VALUES ('sistemas informaticos', '1');
INSERT INTO `ilerna`.`asignatura` (`nombre`, `fp_id`) VALUES ('base de datos', '1');
INSERT INTO `ilerna`.`asignatura` (`nombre`, `fp_id`) VALUES ('entornos de desarrollo', '1');



INSERT INTO `ilerna`.`curso` (`fp_id`, `asignatura_id`, `turno`, `profesor_id`) VALUES ('1', '1', 'diurno', '1');
INSERT INTO `ilerna`.`curso` (`fp_id`, `asignatura_id`, `turno`, `profesor_id`) VALUES ('1', '2', 'diurno', '2');
INSERT INTO `ilerna`.`curso` (`fp_id`, `asignatura_id`, `turno`, `profesor_id`) VALUES ('1', '3', 'diurno', '3');
INSERT INTO `ilerna`.`curso` (`fp_id`, `asignatura_id`, `turno`, `profesor_id`) VALUES ('1', '4', 'diurno', '4');
INSERT INTO `ilerna`.`curso` (`fp_id`, `asignatura_id`, `turno`, `profesor_id`) VALUES ('1', '5', 'diurno', '5');


INSERT INTO curso_horario (curso_id, dia_semana, hora_inicio, hora_fin)
VALUES (4, 1, '08:30:00', '10:20:00');
INSERT INTO curso_horario (curso_id, dia_semana, hora_inicio, hora_fin)
VALUES (2, 1, '10:20:00', '12:40:00');
INSERT INTO curso_horario (curso_id, dia_semana, hora_inicio, hora_fin)
VALUES (1, 1, '12:40:00', '14:20:00');
INSERT INTO curso_horario (curso_id, dia_semana, hora_inicio, hora_fin)
VALUES (1, 2, '08:30:00', '10:20:00');
INSERT INTO curso_horario (curso_id, dia_semana, hora_inicio, hora_fin)
VALUES (5, 2, '10:20:00', '11:15:00');
INSERT INTO curso_horario (curso_id, dia_semana, hora_inicio, hora_fin)
VALUES (5, 2, '11:45:00', '13:35:00');
INSERT INTO curso_horario (curso_id, dia_semana, hora_inicio, hora_fin)
VALUES (6, 2, '13:35:00', '14:20:00');


