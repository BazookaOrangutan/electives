--liquibase formated sql
--changeset Nikolay:1

CREATE TABLE IF NOT EXISTS public.lecturer
(
    experience integer,
    specialty_experience integer,
    id uuid NOT NULL,
    academic_title character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    phone character varying(255) COLLATE pg_catalog."default",
    scientific_degree character varying(255) COLLATE pg_catalog."default",
    photo text COLLATE pg_catalog."default",
    CONSTRAINT lecturer_pkey PRIMARY KEY (id)
)

--rollback drop table lecturer;
