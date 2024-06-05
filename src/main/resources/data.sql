INSERT INTO PAIS (NOMBRE, STATUS)
VALUES
    ('Pais1', true),
    ('Pais2', true),
    ('Pais3', true),
    ('Pais4', true),
    ('Pais5', true),
    ('Pais6', true),
    ('Pais7', true),
    ('Pais8', true),
    ('Pais9', true),
    ('Pais10', true),
    ('Pais11', true),
    ('Pais12', true),
    ('Pais13', true),
    ('Pais14', true),
    ('Pais15', true),
    ('Pais16', true),
    ('Pais17', true),
    ('Pais18', true),
    ('Pais19', true),
    ('Pais20', true),
    ('Pais21', true),
    ('Pais22', true),
    ('Pais23', true),
    ('Pais24', true),
    ('Pais25', true);

INSERT INTO DEPARTAMENTO (ID_PAIS, NOMBRE, STATUS)
SELECT
    (SELECT ID_PAIS FROM PAIS ORDER BY random() LIMIT 1),
    'Departamento'||generate_series(1,25),
    true;


INSERT INTO CIUDAD (ID_DEPARTAMENTO, NOMBRE, STATUS)
SELECT
    D.ID_DEPARTAMENTO,
    'Ciudad'||generate_series(1,25),
    true
FROM
    DEPARTAMENTO D
ORDER BY
    random()
    LIMIT
    25;

INSERT INTO ZONA (ID_CIUDAD, NOMBRE, STATUS)
SELECT
    C.ID_CIUDAD,
    'Zona'||generate_series(1,25),
    true
FROM
    CIUDAD C
ORDER BY
    random()
    LIMIT
    25;


INSERT INTO TIPO_CITA (NOMBRE, STATUS)
VALUES
    ('Consulta General', true),
    ('Consulta Especializada', true),
    ('Control de Rutina', true),
    ('Examen Médico', true),
    ('Seguimiento de Tratamiento', true);