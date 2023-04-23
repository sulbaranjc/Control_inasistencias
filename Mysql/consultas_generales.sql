use ilerna;

SELECT * FROM curso;

select curso.id, fp.nombre, asignatura.nombre, profesor.nombre, profesor.apellido from curso, fp, asignatura, profesor
WHERE curso.fp_id = fp.id and
curso.asignatura_id = asignatura.id and
curso.profesor_id = profesor.id;

select * from curso_horario;

select a.id, asig.nombre, ds.nombre, a.hora_inicio, a.hora_fin   from curso_horario as a , curso as c, asignatura as asig, dia_semana as ds
where a.curso_id = c.id and
c.asignatura_id = asig.id and
a.dia_semana = ds.id;