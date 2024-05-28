-- Active: 1700601815243@@127.0.0.1@3306@colegio
-- DML Data Manipulation Language
use colegio;
INSERT INTO cursos (titulo, profesor, dia, turno) VALUES
('Matemáticas', 'Juan Pérez', 'LUNES', 'MAÑANA'),
('Historia', 'María Gómez', 'MARTES', 'TARDE'),
('Inglés', 'Carlos Rodríguez', 'MIÉRCOLES', 'MAÑANA'),
('Ciencias', 'Ana López', 'JUEVES', 'TARDE'),
('Literatura', 'Pedro Martínez', 'VIERNES', 'MAÑANA'),
('Física', 'Laura Fernández', 'LUNES', 'TARDE'),
('Química', 'Raúl Ramírez', 'MIÉRCOLES', 'TARDE'),
('Biología', 'Sofía Castro', 'JUEVES', 'MAÑANA'),
('Geografía', 'Luisa Sánchez', 'VIERNES', 'TARDE'),
('Arte', 'David Herrera', 'LUNES', 'NOCHE');

INSERT INTO alumnos (nombre, apellido, edad, idCurso) VALUES
('Juan', 'González', 18, 1),
('María', 'López', 17, 2),
('Carlos', 'Hernández', 16, 3),
('Ana', 'Torres', 18, 4),
('Pedro', 'García', 17, 5),
('Laura', 'Luna', 16, 6),
('Raúl', 'Vargas', 18, 7),
('Sofía', 'Guzmán', 17, 8),
('Luisa', 'Martínez', 16, 9),
('David', 'Soto', 18, 10);