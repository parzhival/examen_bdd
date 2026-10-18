
create table socios(
	id_socio INT,
	nombres varchar(50) not null,
	apellidos varchar(50) not null,
	edad INT not null,
	fecha_registro varchar(10) not null,
	activo BOOLEAN not null,	

	constraint socios_pk primary key (id_socio)
)

--INGRESO DE DATOS

INSERT INTO socios VALUES(1, 'Carlos', 'Perez', 25, '2026-01-15', true);
INSERT INTO socios VALUES(2, 'Ana', 'Gomez', 15, '2026-02-05', true);
INSERT INTO socios VALUES(3, 'Luis', 'Ramirez', 32, '2026-02-15', false);
INSERT INTO socios VALUES(4, 'Sofia', 'Castro', 17, '2026-03-01', true);
INSERT INTO socios VALUES(5, 'Pedro', 'Morales', 40, '2026-04-10', false);

--PETICIONES 

SELECT nombres, apellidos, edad FROM socios WHERE activo = true AND edad > 18;
SELECT * FROM socios WHERE fecha_registro > '2026-02-01';
SELECT * FROM socios ORDER BY edad DESC;

-- MODIFICACION

ALTER TABLE socios ADD COLUMN email varchar(100);

UPDATE socios SET email = 'carlos.perez@gmail.com' WHERE id_socio = 1;

SELECT * FROM socios;


















