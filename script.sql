-- mysql -h localhost -u root -p1234 //para conectar mysql desde consola root:nombreUsuario y 1234:contraseña
-- https://dev.mysql.com/downloads/connector/j/5.0.html

DROP DATABASE base;

CREATE DATABASE base;

USE base;

CREATE TABLE alumno (
    cod_alumno INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(200),
    carnet VARCHAR(200),
    facultad VARCHAR(200),
    correo VARCHAR(200),
    contraseña VARCHAR(200),
    numero INT,
    tipo_alumno_cod_tipo INT NOT NULL
)
    ;

CREATE TABLE asignacion_curso_alumno (
	curso_cod_curso INT NOT NULL,
	alumno_cod_alumno INT NOT NULL,
	CONSTRAINT asignacion_curso_alumno_pk PRIMARY KEY ( curso_cod_curso, alumno_cod_alumno )
);

CREATE TABLE curso (
	cod_curso INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(200)
);

CREATE TABLE documento (
	cod_documento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	documento VARCHAR(200),
	curso_cod_curso INT NOT NULL
);

CREATE TABLE estado_documento (
	documento_cod_documento INT NOT NULL,
	alumno_cod_alumno INT NOT NULL,
	estado INT NOT NULL
);

CREATE TABLE tipo_alumno (
	cod_tipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(200)
);

ALTER TABLE alumno
    ADD CONSTRAINT alumno_cod_tipo_fk FOREIGN KEY ( tipo_alumno_cod_tipo )
        REFERENCES tipo_alumno ( cod_tipo ) ON DELETE CASCADE
;

ALTER TABLE asignacion_curso_alumno
    ADD CONSTRAINT asignacion_curso_alumno_curso_fk FOREIGN KEY ( curso_cod_curso )
        REFERENCES curso ( cod_curso ) ON DELETE CASCADE
;

ALTER TABLE asignacion_curso_alumno
    ADD CONSTRAINT asignacion_curso_alumno_alumno_fk FOREIGN KEY ( alumno_cod_alumno )
        REFERENCES alumno ( cod_alumno ) ON DELETE CASCADE
;

ALTER TABLE estado_documento
    ADD CONSTRAINT estado_documento_alumno_fk FOREIGN KEY ( alumno_cod_alumno )
        REFERENCES alumno ( cod_alumno ) ON DELETE CASCADE
;

ALTER TABLE estado_documento
    ADD CONSTRAINT estado_documento_documento_fk FOREIGN KEY ( documento_cod_documento )
        REFERENCES documento ( cod_documento ) ON DELETE CASCADE
;
INSERT INTO tipo_alumno (nombre) 
	VALUES ('Estudiante'),('Auxiliar');

INSERT INTO curso (nombre)
	VALUES ('CU170'),('MM2021'),('CC2008'),
	('MM2028'),('FF2016'),('CU160'),
	('QQ2015'),('QQ2017'),('MM2020'),
	('CU120'),('CC2005'),('FF3030');

INSERT INTO alumno(carnet, contraseña, nombre, tipo_alumno_cod_tipo)
	VALUES ('1','1','Luffy Aux', 2),
	('2','1','Zoro Alumno', 1),
	('3','1','Nami Alumna', 1),
	('4','1','Shanks Aux',2);
