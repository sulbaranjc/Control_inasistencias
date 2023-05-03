-- todas las tablas
USE ilerna;
select * from turno;
select * from fp;
select * from asignatura;
select * from profesor;
select * from aula;
select * from modalidad;
select * from grupo;
select * from dia_semana;
select * from calendario;
select * from horario;
select * from asignatura_grupo;
select * from alumno;
select * from alumno_grupo;
select * from tipo_asistencia;
select * from asistencia;


-- lista de profesores 
select nombre,apellido from profesor;

-- lista de fp
select nombre from fp;

-- lista de turnos
select nombre from turno;


-- lista de grupo
SELECT grupo.id, grupo.nombre,grupo.periodo,fp.nombre as fp, turno.nombre as turno, modalidad.nombre as modalidad 
	FROM grupo, fp, turno, modalidad  
    WHERE grupo.id_fp = fp.id 
	  AND grupo.id_turno = turno.id 
      AND grupo.id_modalidad = modalidad.id;


-- lista de alumno por grupo
SELECT  alumno.nombre, alumno.apellido 
	FROM alumno_grupo, alumno 
	WHERE id_grupo = 1 AND alumno_grupo.id_alumno = alumno.id;

-- lista de asignatura fp
SELECT asignatura.nombre, fp.nombre as fp 
	FROM asignatura, fp 
	WHERE asignatura.fp_id = fp.id;
    
-- asignaturas de un profesor 
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula, asg.id_horario
	FROM asignatura_grupo as asg, asignatura, profesor, aula
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id AND asg.id_aula = aula.id
    ORDER BY profesor.nombre;
    
-- asignaturas de un profesor horario
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula, asg.id_horario
	FROM asignatura_grupo as asg, asignatura, profesor, aula
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id AND asg.id_aula = aula.id AND asg.id_profesor = 1
    ORDER BY profesor.nombre;    
    
    -- lista de horario por profesor
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula,
dia_semana.nombre as dia, calendario.hora_inicio, calendario.hora_final
	FROM asignatura_grupo as asg, asignatura, profesor, aula, horario_detalle as h_d, calendario, dia_semana
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id 
		AND asg.id_aula = aula.id AND asg.id_asignatura = 2 AND asg.id_horario = h_d.id_horario 
        AND h_d.id_calendario = calendario.id AND calendario.id_dia_semana = dia_semana.id
	ORDER BY dia_semana.id , calendario.hora_inicio;
    
-- lista de horario completo
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula,
dia_semana.nombre as dia, calendario.hora_inicio, calendario.hora_final
	FROM asignatura_grupo as asg, asignatura, profesor, aula, horario_detalle as h_d, calendario, dia_semana
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id 
		AND asg.id_aula = aula.id AND asg.id_horario = h_d.id_horario 
        AND h_d.id_calendario = calendario.id AND calendario.id_dia_semana = dia_semana.id
    ORDER BY dia_semana.id , calendario.hora_inicio;    
    
    
    
-- prueba
SELECT CONCAT(calendario.hora_inicio, '-', calendario.hora_final) AS horas,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'lunes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS lunes,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'martes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS martes,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'miércoles' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS miercoles,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'jueves' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS jueves,
    GROUP_CONCAT(DISTINCT CASE WHEN dia_semana.nombre = 'viernes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre, ' - ', aula.nombre) END) AS viernes
FROM asignatura_grupo as asg, asignatura, profesor, aula, horario_detalle as h_d, calendario, dia_semana
WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id 
    AND asg.id_aula = aula.id AND asg.id_horario = h_d.id_horario 
    AND h_d.id_calendario = calendario.id AND calendario.id_dia_semana = dia_semana.id
GROUP BY calendario.hora_inicio, calendario.hora_final;

-- otra forma
SELECT CONCAT(calendario.hora_inicio, ' - ', calendario.hora_final) AS horario,
  MAX(CASE WHEN dia_semana.nombre = 'lunes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS lunes,
  MAX(CASE WHEN dia_semana.nombre = 'martes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS martes,
  MAX(CASE WHEN dia_semana.nombre = 'miércoles' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS miércoles,
  MAX(CASE WHEN dia_semana.nombre = 'jueves' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS jueves,
  MAX(CASE WHEN dia_semana.nombre = 'viernes' THEN CONCAT(asignatura.nombre, ' - ', profesor.nombre) ELSE '' END) AS viernes
FROM asignatura_grupo AS asg
JOIN asignatura ON asg.id_asignatura = asignatura.id
JOIN profesor ON asg.id_profesor = profesor.id 
JOIN aula ON asg.id_aula = aula.id 
JOIN horario_detalle AS h_d ON asg.id_horario = h_d.id_horario 
JOIN calendario ON h_d.id_calendario = calendario.id 
JOIN dia_semana ON calendario.id_dia_semana = dia_semana.id
GROUP BY CONCAT(calendario.hora_inicio, ' - ', calendario.hora_final);


    