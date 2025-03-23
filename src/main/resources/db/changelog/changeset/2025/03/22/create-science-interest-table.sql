--liquibase formated sql
--changeset Nikolay:9

CREATE TABLE IF NOT EXISTS public.science_interest
(
    id uuid NOT NULL,
    lecturer_id uuid,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT science_interest_pkey PRIMARY KEY (id),
    CONSTRAINT fk1ucigdhn9wrkd15rol1brg97m FOREIGN KEY (lecturer_id)
        REFERENCES public.lecturer (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


--rollback drop table science_interest;