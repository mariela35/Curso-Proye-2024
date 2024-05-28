-- Active: 1700601815243@@127.0.0.1@3306@colegio
-- Consultas de prueba
-- 10 consultas de prueba en SQL para la base de datos colegio:

use colegio;
-- 1 Obtener todos los cursos:

SELECT * FROM cursos;

-- 2 Obtener todos los alumnos:

SELECT * FROM alumnos;

-- 3 Obtener el título y el profesor de todos los cursos que se imparten en la mañana:

SELECT titulo, profesor FROM cursos WHERE turno = 'MAÑANA';

-- 4 Obtener los nombres y apellidos de los alumnos que tienen más de 17 años:

SELECT nombre, apellido FROM alumnos WHERE edad > 17;

-- 5 Obtener los títulos de los cursos impartidos los martes:

SELECT titulo FROM cursos WHERE dia = 'MARTES';

-- 6 Obtener los nombres y apellidos de los alumnos que están inscritos en el curso de Matemáticas:

SELECT nombre, apellido FROM alumnos WHERE idCurso = (SELECT id FROM cursos WHERE titulo = 'Matemáticas');

-- 7 Obtener el nombre del profesor del curso en el que está inscrito el alumno con el ID 3:

SELECT profesor FROM cursos WHERE id = (SELECT idCurso FROM alumnos WHERE id = 3);

-- 8 Obtener la cantidad total de alumnos inscritos en cada curso:
SELECT c.titulo, COUNT(a.id) AS cantidad_alumnos
FROM cursos c
LEFT JOIN alumnos a ON c.id = a.idCurso
GROUP BY c.id;

-- 9 Obtener el curso con la menor cantidad de alumnos inscritos:
SELECT c.titulo, COUNT(a.id) AS cantidad_alumnos
FROM cursos c
LEFT JOIN alumnos a ON c.id = a.idCurso
GROUP BY c.id
ORDER BY cantidad_alumnos ASC
LIMIT 1;

-- 10 Obtener los nombres y apellidos de los alumnos que están inscritos en cursos de la tarde y tienen más de 16 años:

SELECT nombre, apellido
FROM alumnos
WHERE idCurso IN (SELECT id FROM cursos WHERE turno = 'TARDE') AND edad > 16;

select version();