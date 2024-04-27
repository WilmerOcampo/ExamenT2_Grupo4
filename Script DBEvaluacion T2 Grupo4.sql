-- CREATE DATABASE BDEvaluacion DEFAULT CHARACTER SET utf8mb4;
USE BDEvaluacion;

CREATE TABLE usuario (
	idusuario INT auto_increment NOT NULL,
	nomusuario varchar(100) NULL,
	email varchar(200) NULL,
	password varchar(300) NULL,
	nombres varchar(100) NULL,
	apellidos varchar(100) NULL,
	activo BOOL NULL,
	CONSTRAINT users_pk PRIMARY KEY (idusuario)
);
CREATE TABLE rol (
	idrol INT auto_increment NOT NULL,
	nomrol varchar(300) NULL,
	CONSTRAINT roles_pk PRIMARY KEY (idrol)
);
CREATE TABLE usuario_rol (
	idusuario INT NOT NULL,
	idrol INT NOT NULL,
	CONSTRAINT user_role_pk PRIMARY KEY (idusuario, idrol),
	CONSTRAINT user_role_FK FOREIGN KEY (idusuario) REFERENCES BDEvaluacion.usuario(idusuario),
	CONSTRAINT user_role_FK_1 FOREIGN KEY (idrol) REFERENCES BDEvaluacion.rol(idrol)
);
CREATE TABLE Medico
(
 IdMedico 		INT NOT NULL AUTO_INCREMENT,
 NomMedico		VARCHAR(50) NOT NULL,
 ApeMedico 		VARCHAR(50) NOT NULL,
 FechNacMedico	DATE NOT NULL,
 PRIMARY KEY (IdMedico)
);
CREATE TABLE Especialidad
(
 IdEspecialidad 		INT NOT NULL AUTO_INCREMENT,
 Titulo 			VARCHAR(250) NOT NULL,
 Funcion 			VARCHAR(250) NOT NULL,
 FechGraduacion	DATE NOT NULL,
 IdMedico 			INT NOT NULL,
 PRIMARY KEY (IdEspecialidad),
 FOREIGN KEY (IdMedico) REFERENCES Medico(IdMedico)
 );
 
 INSERT INTO Medico (NomMedico, ApeMedico, FechNacMedico) VALUES 
('Sabrina', 'Carpenter', '1986-03-23'),
('Lionel', 'Messi', '1992-11-09'),
('Abel', 'Tesfaye', '1999-12-25');
INSERT INTO Especialidad (Titulo, Funcion, FechGraduacion, IdMedico) VALUES 
('Cardiología', 'Tratamiento de enfermedades del corazón', '2020-06-30', 1),
('Psicologo', 'Atención psicomotriz a los jovenes', '2022-07-25', 2),
('Pediatría', 'Atención médica a niños', '2024-03-10', 3);

INSERT INTO rol (nomrol) VALUES 
('ADMIN'),
('USER');

SELECT * FROM rol;
SELECT * FROM Especialidad;
SELECT * FROM Medico;