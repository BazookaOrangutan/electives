--liquibase formated sql
--changeset Nikolay:6

CREATE TABLE IF NOT EXISTS public.job_title
(
    id uuid NOT NULL,
    lecturer_id uuid,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT job_title_pkey PRIMARY KEY (id),
    CONSTRAINT fkk607cdqhjhbslcasy2owvofim FOREIGN KEY (lecturer_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback drop table job_title;