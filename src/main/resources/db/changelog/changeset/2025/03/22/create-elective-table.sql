--liquibase formated sql
--changeset Nikolay:4

CREATE TABLE IF NOT EXISTS public.elective
(
    author_id uuid,
    id uuid NOT NULL,
    description character varying(3000) COLLATE pg_catalog."default",
    control_type character varying(255) COLLATE pg_catalog."default",
    format character varying(255) COLLATE pg_catalog."default",
    intensity character varying(255) COLLATE pg_catalog."default",
    place character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT elective_pkey PRIMARY KEY (id),
    CONSTRAINT fkbujtfnr4dsic7tasspijlpike FOREIGN KEY (author_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback drop table elective;