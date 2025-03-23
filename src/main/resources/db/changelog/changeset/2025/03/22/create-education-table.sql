--liquibase formated sql
--changeset Nikolay:3

CREATE TABLE IF NOT EXISTS public.education
(
    id uuid NOT NULL,
    lecturer_id uuid,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT education_pkey PRIMARY KEY (id),
    CONSTRAINT fklrafnw2acpggf695hm5idad51 FOREIGN KEY (lecturer_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback drop table education;