--liquibase formated sql
--changeset Nikolay:7

CREATE TABLE IF NOT EXISTS public.prof_experience
(
    id uuid NOT NULL,
    lecturer_id uuid,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT prof_experience_pkey PRIMARY KEY (id),
    CONSTRAINT fknywqqiapwahj4g9uc89n6r5i5 FOREIGN KEY (lecturer_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback drop table prof_experience;