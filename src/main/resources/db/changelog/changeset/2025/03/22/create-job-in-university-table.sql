--liquibase formated sql
--changeset Nikolay:5

CREATE TABLE IF NOT EXISTS public.job_in_university
(
    id uuid NOT NULL,
    lecturer_id uuid,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT job_in_university_pkey PRIMARY KEY (id),
    CONSTRAINT fki40sxr2lmjcihv28n7o99kor FOREIGN KEY (lecturer_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback drop table job_in_university;