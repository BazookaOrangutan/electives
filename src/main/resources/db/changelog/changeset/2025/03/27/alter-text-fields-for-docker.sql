--liquibase formated sql
--changeset Nikolay:14

ALTER TABLE public.education ALTER COLUMN description TYPE TEXT;
ALTER TABLE public.prof_experience ALTER COLUMN description TYPE TEXT;
ALTER TABLE public.prof_training ALTER COLUMN description TYPE TEXT;
ALTER TABLE public.scientific_work ALTER COLUMN description TYPE TEXT;
ALTER TABLE public.job_in_university ALTER COLUMN description TYPE TEXT;