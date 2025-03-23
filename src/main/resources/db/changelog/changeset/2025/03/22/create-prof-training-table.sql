--liquibase formated sql
--changeset Nikolay:8

CREATE TABLE IF NOT EXISTS public.prof_training
(
    id uuid NOT NULL,
    lecturer_id uuid,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT prof_training_pkey PRIMARY KEY (id),
    CONSTRAINT fkiyr7e2voqfqpd34k8cde58ebn FOREIGN KEY (lecturer_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback drop table prof_training;