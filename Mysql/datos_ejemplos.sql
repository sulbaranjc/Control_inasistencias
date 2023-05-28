USE ilerna;

INSERT INTO  ilerna.fp (nombre, descripcion) 
VALUES 
	 ('DAW', 'Desarrollo web'),
     ('DAM', 'Desarrollo multiplataforma');
     
INSERT INTO  ilerna.turno (nombre) 
VALUES 
	 ('Mañana'),
     ('Tarde');

INSERT INTO ilerna.asignatura (nombre, fp_id) 
VALUES 
	('Programacion I', '1'),
    ('Lenguaje de marca ', '1'),
    ('FOL', '1'),
    ('Sistemas informaticos', '1'),
    ('Base de datos', '1'),
    ('Entornos de desarrollo', '1');
    
INSERT INTO ilerna.profesor (nombre, apellido, correo, telefono,contrasena)
VALUES
  ('Frank', 'Soltero', 'juan.perez@ejemplo.com', '555-1234','contrasena123'),
  ('Victor', 'Rodriguez', 'maria.gonzalez@ejemplo.com', '555-5678','contrasena123'),
  ('Cristina', 'Hernández', 'pedro.hernandez@ejemplo.com', '555-9012','contrasena123'),
  ('Laura', 'Martínez', 'laura.martinez@ejemplo.com', '555-3456','contrasena123'),
  ('Santiago', 'Gómez', 'santiago.gomez@ejemplo.com', '555-7890','contrasena123');

INSERT INTO  ilerna.aula (nombre) 
VALUES 
	 ('4.1'),
     ('4.2');
     
INSERT INTO ilerna.modalidad (nombre)
VALUES
('Presencial'),
('Online');

INSERT INTO ilerna.dia_semana (id, nombre)
VALUES
  (1, 'lunes'),
  (2, 'Martes'),
  (3, 'Miercoles'),
  (4, 'jueves'),
  (5, 'viernes'),
  (6, 'sabado'),
  (7, 'domingo');
  
INSERT INTO ilerna.calendario (id_dia_semana, hora_inicio, hora_final)
VALUES
  (1, '08:30:00', '09:25:00'),
  (1, '09:25:00', '10:20:00'),
  (1, '10:20:00', '11:15:00'),
  (1, '11:15:00', '11:45:00'),
  (1, '11:45:00', '12:40:00'),
  (1, '12:40:00', '13:35:00'),
  (1, '13:35:00', '14:20:00'),
  (2, '08:30:00', '09:25:00'),
  (2, '09:25:00', '10:20:00'),
  (2, '10:20:00', '11:15:00'),
  (2, '11:15:00', '11:45:00'),
  (2, '11:45:00', '12:40:00'),
  (2, '12:40:00', '13:35:00'),
  (2, '13:35:00', '14:20:00'),
  (3, '08:30:00', '09:25:00'),
  (3, '09:25:00', '10:20:00'),
  (3, '10:20:00', '11:15:00'),
  (3, '11:15:00', '11:45:00'),
  (3, '11:45:00', '12:40:00'),
  (3, '12:40:00', '13:35:00'),
  (3, '13:35:00', '14:20:00'),
  (4, '08:30:00', '09:25:00'),
  (4, '09:25:00', '10:20:00'),
  (4, '10:20:00', '11:15:00'),
  (4, '11:15:00', '11:45:00'),
  (4, '11:45:00', '12:40:00'),
  (4, '12:40:00', '13:35:00'),
  (4, '13:35:00', '14:20:00'),
  (5, '08:30:00', '09:25:00'),
  (5, '09:25:00', '10:20:00'),
  (5, '10:20:00', '11:15:00'),
  (5, '11:15:00', '11:45:00'),
  (5, '11:45:00', '12:40:00'),
  (5, '12:40:00', '13:35:00'),
  (5, '13:35:00', '14:20:00');
  
  
INSERT INTO  ilerna.horario (nombre) 
VALUES 
	 ('P1'),
     ('P2'),
	 ('P3'),
     ('P4'),
	 ('P5'),
     ('P6');
     
INSERT INTO  ilerna.horario_detalle (id_horario, id_calendario) 
VALUES 
	 (1, 1),
     (1, 2),
	 (1, 15),
     (1, 16),
	 (1, 17),
     (1, 24),
	 (2, 3),
     (2, 5),
	 (2, 22),
     (2, 23),
	 (3, 6),
     (3, 7),
     (3, 8),
     (3, 9),
     (3, 29),
     (3, 30),
     (3, 31),
     (3, 33),
     (4, 10),
     (4, 12),
     (4, 13),
     (4, 19),
     (4, 20),
     (4, 21),
     (5, 14),
     (5, 34),
     (5, 35),
     (6, 26),
     (6, 27),
     (6, 28);

INSERT INTO ilerna.grupo (nombre,id_periodo,id_fp,id_turno,id_modalidad )
VALUES
  ("A", 1, 1, 1, 1),
  ("A", 1, 2, 1, 1);

INSERT INTO ilerna.periodo (nombre)
VALUES
  ("2022 - 2023");



INSERT INTO ilerna.asignatura_grupo (id_asignatura, id_profesor, id_aula, id_horario, id_grupo)
VALUES
  (4, 2, 1, 1, 1),
  (2, 2, 1, 2, 1),
  (1, 1, 1, 3, 1),
  (5, 2, 1, 4, 1),
  (6, 1, 1, 5, 1),
  (3, 3, 1, 6, 1);
  
  
  
INSERT INTO ilerna.alumno (dni, nombre, apellido, correo)
VALUES
  ('xxxx','Ana', 'López', 'ana.lopez@ejemplo.com'),
  ('xxxx','Carlos', 'Sánchez', 'carlos.sanchez@ejemplo.com'),
  ('xxxx','Lucía', 'García', 'lucia.garcia@ejemplo.com'),
  ('xxxx','Diego', 'Ramírez', 'diego.ramirez@ejemplo.com'),
  ('xxxx','Marcela', 'Torres', 'marcela.torres@ejemplo.com');

INSERT INTO ilerna.alumno_grupo (id_grupo, id_alumno)
VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (1, 4),
  (1, 5);
   
   
INSERT INTO  ilerna.tipo_asistencia (nombre) 
VALUES 
	 ('Justificada'),
     ('Injustificada'),
     ('Retraso');
     

INSERT INTO ilerna.asistencia (fecha, id_alumno, id_horario_detalle, id_tipo_asistencia)
VALUES
  ('2023-04-28',1, 25,1);
  

     
     

    

