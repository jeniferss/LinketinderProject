CREATE TABLE IF NOT EXISTS public."candidate" (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	birthDate DATE NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	description VARCHAR(255) NOT NULL,
	location_id INT NOT NULL,
	user_id INT NOT NULL UNIQUE,
	CONSTRAINT location_id FOREIGN KEY (location_id) REFERENCES public."location" (id) ON DELETE RESTRICT,
	CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public."user" (id) ON DELETE CASCADE
);
INSERT INTO public."candidate" VALUES
	(1, 'Candidato Um', '2001-08-16', '00000000000', 'Descrição Um', 1, 1),
	(2, 'Candidato Dois', '2001-08-17', '00000000001', 'Descrição Dois', 2, 2),
	(3, 'Candidato Três', '2001-08-18', '00000000002', 'Descrição Três', 3, 3),
	(4, 'Candidato Quatro', '2001-08-19', '00000000003', 'Descrição Quatro', 4, 4),
	(5, 'Candidato Cinco', '2001-08-20', '00000000004', 'Descrição Cinco', 5, 5)