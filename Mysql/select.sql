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
    
-- lista de horario
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula, asg.id_horario
	FROM asignatura_grupo as asg, asignatura, profesor, aula
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id AND asg.id_aula = aula.id;
    
    -- lista de horario
SELECT asignatura.nombre, profesor.nombre as profesor, aula.nombre as aula,
dia_semana.nombre as dia, calendario.hora_inicio, calendario.hora_final
	FROM asignatura_grupo as asg, asignatura, profesor, aula, horario_detalle as h_d, calendario, dia_semana
	WHERE asg.id_asignatura = asignatura.id AND asg.id_profesor = profesor.id 
		AND asg.id_aula = aula.id AND asg.id_asignatura = 1 AND asg.id_horario = h_d.id_horario 
        AND h_d.id_calendario = calendario.id AND calendario.id_dia_semana = dia_semana.id;
    

