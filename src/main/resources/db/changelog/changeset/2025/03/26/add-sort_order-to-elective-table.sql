--liquibase formated sql
--changeset Nikolay:13

ALTER TABLE public.elective ADD COLUMN sort_order integer;