--liquibase formated sql
--changeset Nikolay:2

CREATE TABLE IF NOT EXISTS public.discipline
(
    id uuid NOT NULL,
    lecturer_id uuid,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT discipline_pkey PRIMARY KEY (id),
    CONSTRAINT fkfmossfg2ndmehwapuk18fgbma FOREIGN KEY (lecturer_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

--rollback drop table discipline;
