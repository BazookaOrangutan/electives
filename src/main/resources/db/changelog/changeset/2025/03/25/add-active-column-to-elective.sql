--liquibase formated sql
--changeset Nikolay:11

ALTER TABLE public.elective ADD COLUMN active boolean DEFAULT TRUE;
