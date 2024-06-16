-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-06-05 02:36:00.337

-- tables
-- Table: ADMIN
CREATE TABLE ADMIN (
                       ADMIN_ID serial  NOT NULL,
                       ID_PERSONA int  NOT NULL,
                       USERNAME varchar(80)  NOT NULL,
                       CORREO varchar(100)  NOT NULL,
                       PASSWORD varchar(100)  NOT NULL,
                       STATUS boolean  NOT NULL,
                       CONSTRAINT ADMIN_pk PRIMARY KEY (ADMIN_ID)
);

-- Table: ALERGIA
CREATE TABLE ALERGIA (
                         ID_ALERGIA serial  NOT NULL,
                         ID_PACIENTE int  NOT NULL,
                         TIPO_ALERGIA varchar(200)  NOT NULL,
                         CAUSA varchar(2000)  NOT NULL,
                         STATUS boolean  NOT NULL,
                         CONSTRAINT ALERGIA_pk PRIMARY KEY (ID_ALERGIA)
);

-- Table: ANTECEDENTES_PATOLOGICOS
CREATE TABLE ANTECEDENTES_PATOLOGICOS (
                                          ANTECEDENTES_PATOLOGICOS_ID serial  NOT NULL,
                                          ID_PACIENTE int  NOT NULL,
                                          ANTECEDENTE varchar(5000)  NOT NULL,
                                          STATUS boolean  NOT NULL,
                                          CONSTRAINT ANTECEDENTES_PATOLOGICOS_pk PRIMARY KEY (ANTECEDENTES_PATOLOGICOS_ID)
);

-- Table: ASISTENTE
CREATE TABLE ASISTENTE (
                           ID_ASISTENTE serial  NOT NULL,
                           ID_PERSONA int  NOT NULL,
                           USERNAME varchar(80)  NOT NULL,
                           CORREO varchar(100)  NOT NULL,
                           PASSWORD varchar(100)  NOT NULL,
                           STATUS boolean  NOT NULL,
                           CONSTRAINT ASISTENTE_pk PRIMARY KEY (ID_ASISTENTE)
);

-- Table: CITA
CREATE TABLE CITA (
                      ID_CITA serial  NOT NULL,
                      ID_TIPO_CITA int  NOT NULL,
                      ID_HORARIO int  NOT NULL,
                      ID_PACIENTE int  NOT NULL,
                      ID_ASISTENTE int  NOT NULL,
                      HORA time  NOT NULL,
                      FECHA date  NOT NULL,
                      RAZON varchar(500)  NOT NULL,
                      STATUS boolean  NOT NULL,
                      CONSTRAINT CITA_pk PRIMARY KEY (ID_CITA)
);

-- Table: CIUDAD
CREATE TABLE CIUDAD (
                        ID_CIUDAD serial  NOT NULL,
                        ID_DEPARTAMENTO int  NOT NULL,
                        NOMBRE varchar(100)  NOT NULL,
                        STATUS boolean  NOT NULL,
                        CONSTRAINT CIUDAD_pk PRIMARY KEY (ID_CIUDAD)
);

-- Table: DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
                              ID_DEPARTAMENTO serial  NOT NULL,
                              ID_PAIS int  NOT NULL,
                              NOMBRE varchar(100)  NOT NULL,
                              STATUS boolean  NOT NULL,
                              CONSTRAINT DEPARTAMENTO_pk PRIMARY KEY (ID_DEPARTAMENTO)
);

-- Table: DOCTOR
CREATE TABLE DOCTOR (
                        ID_DOCTOR serial  NOT NULL,
                        ID_PERSONA int  NOT NULL,
                        USERNAME varchar(80)  NOT NULL,
                        CORREO varchar(100)  NOT NULL,
                        PASSWORD varchar(100)  NOT NULL,
                        STATUS boolean  NOT NULL,
                        CONSTRAINT DOCTOR_pk PRIMARY KEY (ID_DOCTOR)
);

-- Table: HISTORIAL_CLINICO
CREATE TABLE HISTORIAL_CLINICO (
                                   HISTORIAL_CLINICO_ID serial  NOT NULL,
                                   ID_PACIENTE int  NOT NULL,
                                   FECHA timestamp  NOT NULL,
                                   OBSERVACIONES varchar(5000)  NOT NULL,
                                   STATUS boolean  NOT NULL,
                                   CONSTRAINT HISTORIAL_CLINICO_pk PRIMARY KEY (HISTORIAL_CLINICO_ID)
);

-- Table: HORARIO
CREATE TABLE HORARIO (
                         ID_HORARIO serial  NOT NULL,
                         DOCTOR_ID_DOCTOR int  NOT NULL,
                         DIAS varchar(50)  NOT NULL,
                         HORA_INICIO time  NOT NULL,
                         HORA_FINAL time  NOT NULL,
                         DISPONIBILIDAD boolean  NOT NULL,
                         STATUS boolean  NOT NULL,
                         CONSTRAINT HORARIO_pk PRIMARY KEY (ID_HORARIO)
);

-- Table: MULTIMEDIA_CLINICA
CREATE TABLE MULTIMEDIA_CLINICA (
                                    MULTIMEDIA_CLINICA_ID serial  NOT NULL,
                                    HISTORIAL_CLINICO_ID int  NOT NULL,
                                    MULTIMEDIA varchar(2000)  NOT NULL,
                                    STATUS boolean  NOT NULL,
                                    CONSTRAINT MULTIMEDIA_CLINICA_pk PRIMARY KEY (MULTIMEDIA_CLINICA_ID)
);

-- Table: PACIENTE
CREATE TABLE PACIENTE (
                          ID_PACIENTE serial  NOT NULL,
                          ID_ZONA int  NOT NULL,
                          ID_PERSONA int  NOT NULL,
                          CORREO varchar(80)  NOT NULL,
                          TIPO_SANGRE varchar(50)  NOT NULL,
                          STATUS boolean  NOT NULL,
                          CONSTRAINT PACIENTE_pk PRIMARY KEY (ID_PACIENTE)
);

-- Table: PAIS
CREATE TABLE PAIS (
                      ID_PAIS serial  NOT NULL,
                      NOMBRE varchar(100)  NOT NULL,
                      STATUS boolean  NOT NULL,
                      CONSTRAINT PAIS_pk PRIMARY KEY (ID_PAIS)
);

-- Table: PERSONA
CREATE TABLE PERSONA (
                         ID_PERSONA serial  NOT NULL,
                         NOMBRE varchar(80)  NOT NULL,
                         APELLIDO_P varchar(50)  NOT NULL,
                         APELLIDO_M varchar(50)  NOT NULL,
                         FECHA_NACIMIENTO date  NOT NULL,
                         GENERO varchar(50)  NOT NULL,
                         TELEFONO varchar(50)  NOT NULL,
                         CI varchar(50)  NOT NULL,
                         STATUS boolean  NOT NULL,
                         CONSTRAINT PERSONA_pk PRIMARY KEY (ID_PERSONA)
);

-- Table: PERSONA_CONTACTO
CREATE TABLE PERSONA_CONTACTO (
                                  ID_PERSONA_CONTACTO serial  NOT NULL,
                                  ID_PACIENTE int  NOT NULL,
                                  NOMBRE varchar(200)  NOT NULL,
                                  TELEFONO varchar(50)  NOT NULL,
                                  RELACION varchar(80)  NOT NULL,
                                  STATUS boolean  NOT NULL,
                                  CONSTRAINT PERSONA_CONTACTO_pk PRIMARY KEY (ID_PERSONA_CONTACTO)
);

-- Table: TIPO_CITA
CREATE TABLE TIPO_CITA (
                           ID_TIPO_CITA serial  NOT NULL,
                           NOMBRE varchar(100)  NOT NULL,
                           STATUS boolean  NOT NULL,
                           CONSTRAINT TIPO_CITA_pk PRIMARY KEY (ID_TIPO_CITA)
);

-- Table: TRATAMIENTO
CREATE TABLE TRATAMIENTO (
                             TRATAMIENTO_ID serial  NOT NULL,
                             CONTENIDO varchar(5000)  NOT NULL,
                             STATUS boolean  NOT NULL,
                             HISTORIAL_CLINICO_HISTORIAL_CLINICO_ID int  NOT NULL,
                             CONSTRAINT TRATAMIENTO_pk PRIMARY KEY (TRATAMIENTO_ID)
);

-- Table: ZONA
CREATE TABLE ZONA (
                      ID_ZONA serial  NOT NULL,
                      ID_CIUDAD int  NOT NULL,
                      NOMBRE varchar(100)  NOT NULL,
                      STATUS boolean  NOT NULL,
                      CONSTRAINT ZONA_pk PRIMARY KEY (ID_ZONA)
);

-- foreign keys
-- Reference: ADMIN_PERSONA (table: ADMIN)
ALTER TABLE ADMIN ADD CONSTRAINT ADMIN_PERSONA
    FOREIGN KEY (ID_PERSONA)
        REFERENCES PERSONA (ID_PERSONA)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: ALERGIA_PACIENTE (table: ALERGIA)
ALTER TABLE ALERGIA ADD CONSTRAINT ALERGIA_PACIENTE
    FOREIGN KEY (ID_PACIENTE)
        REFERENCES PACIENTE (ID_PACIENTE)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: ANTECEDENTES_PATOLOGICOS_PACIENTE (table: ANTECEDENTES_PATOLOGICOS)
ALTER TABLE ANTECEDENTES_PATOLOGICOS ADD CONSTRAINT ANTECEDENTES_PATOLOGICOS_PACIENTE
    FOREIGN KEY (ID_PACIENTE)
        REFERENCES PACIENTE (ID_PACIENTE)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: ASISTENTE_PERSONA (table: ASISTENTE)
ALTER TABLE ASISTENTE ADD CONSTRAINT ASISTENTE_PERSONA
    FOREIGN KEY (ID_PERSONA)
        REFERENCES PERSONA (ID_PERSONA)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: CITAS_ASISTENTE (table: CITA)
ALTER TABLE CITA ADD CONSTRAINT CITAS_ASISTENTE
    FOREIGN KEY (ID_ASISTENTE)
        REFERENCES ASISTENTE (ID_ASISTENTE)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: CITAS_HORARIO (table: CITA)
ALTER TABLE CITA ADD CONSTRAINT CITAS_HORARIO
    FOREIGN KEY (ID_HORARIO)
        REFERENCES HORARIO (ID_HORARIO)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: CITAS_PACIENTE (table: CITA)
ALTER TABLE CITA ADD CONSTRAINT CITAS_PACIENTE
    FOREIGN KEY (ID_PACIENTE)
        REFERENCES PACIENTE (ID_PACIENTE)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: CITA_TIPO_CITA (table: CITA)
ALTER TABLE CITA ADD CONSTRAINT CITA_TIPO_CITA
    FOREIGN KEY (ID_TIPO_CITA)
        REFERENCES TIPO_CITA (ID_TIPO_CITA)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: CIUDAD_DEPARTAMENTO (table: CIUDAD)
ALTER TABLE CIUDAD ADD CONSTRAINT CIUDAD_DEPARTAMENTO
    FOREIGN KEY (ID_DEPARTAMENTO)
        REFERENCES DEPARTAMENTO (ID_DEPARTAMENTO)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: DEPARTAMENTO_PAIS (table: DEPARTAMENTO)
ALTER TABLE DEPARTAMENTO ADD CONSTRAINT DEPARTAMENTO_PAIS
    FOREIGN KEY (ID_PAIS)
        REFERENCES PAIS (ID_PAIS)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: DOCTOR_PERSONA (table: DOCTOR)
ALTER TABLE DOCTOR ADD CONSTRAINT DOCTOR_PERSONA
    FOREIGN KEY (ID_PERSONA)
        REFERENCES PERSONA (ID_PERSONA)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: FOTO_CLINICA_HISTORIAL_CLINICO (table: MULTIMEDIA_CLINICA)
ALTER TABLE MULTIMEDIA_CLINICA ADD CONSTRAINT FOTO_CLINICA_HISTORIAL_CLINICO
    FOREIGN KEY (HISTORIAL_CLINICO_ID)
        REFERENCES HISTORIAL_CLINICO (HISTORIAL_CLINICO_ID)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: HISTORIAL_CLINICO_PACIENTE (table: HISTORIAL_CLINICO)
ALTER TABLE HISTORIAL_CLINICO ADD CONSTRAINT HISTORIAL_CLINICO_PACIENTE
    FOREIGN KEY (ID_PACIENTE)
        REFERENCES PACIENTE (ID_PACIENTE)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: HORARIO_DOCTOR (table: HORARIO)
ALTER TABLE HORARIO ADD CONSTRAINT HORARIO_DOCTOR
    FOREIGN KEY (DOCTOR_ID_DOCTOR)
        REFERENCES DOCTOR (ID_DOCTOR)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: PACIENTE_PERSONA (table: PACIENTE)
ALTER TABLE PACIENTE ADD CONSTRAINT PACIENTE_PERSONA
    FOREIGN KEY (ID_PERSONA)
        REFERENCES PERSONA (ID_PERSONA)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: PACIENTE_ZONA (table: PACIENTE)
ALTER TABLE PACIENTE ADD CONSTRAINT PACIENTE_ZONA
    FOREIGN KEY (ID_ZONA)
        REFERENCES ZONA (ID_ZONA)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: PERSONA_CONTACTO_PACIENTE (table: PERSONA_CONTACTO)
ALTER TABLE PERSONA_CONTACTO ADD CONSTRAINT PERSONA_CONTACTO_PACIENTE
    FOREIGN KEY (ID_PACIENTE)
        REFERENCES PACIENTE (ID_PACIENTE)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: TRATAMIENTO_HISTORIAL_CLINICO (table: TRATAMIENTO)
ALTER TABLE TRATAMIENTO ADD CONSTRAINT TRATAMIENTO_HISTORIAL_CLINICO
    FOREIGN KEY (HISTORIAL_CLINICO_HISTORIAL_CLINICO_ID)
        REFERENCES HISTORIAL_CLINICO (HISTORIAL_CLINICO_ID)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: ZONA_CIUDAD (table: ZONA)
ALTER TABLE ZONA ADD CONSTRAINT ZONA_CIUDAD
    FOREIGN KEY (ID_CIUDAD)
        REFERENCES CIUDAD (ID_CIUDAD)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

