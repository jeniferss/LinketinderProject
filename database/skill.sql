CREATE TABLE IF NOT EXISTS public."skill" (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL
);
INSERT INTO public."skill" VALUES (1, 'Python'), (2, 'Java'), (3, 'Javascipt'), (4, 'Groovy'), (5, 'Kotlin')