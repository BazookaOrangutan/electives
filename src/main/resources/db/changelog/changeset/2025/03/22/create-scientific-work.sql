--liquibase formated sql
--changeset Nikolay:10

CREATE TABLE IF NOT EXISTS public.scientific_work
(
    id uuid NOT NULL,
    lecturer_id uuid,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT scientific_work_pkey PRIMARY KEY (id),
    CONSTRAINT fkdybx8saiou31887akbxpwtow5 FOREIGN KEY (lecturer_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


--rollback drop table scientific_work;