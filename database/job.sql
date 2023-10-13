CREATE TABLE IF NOT EXISTS public."job" (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	location_id INT NOT NULL,
	company_id INT NOT NULL,
	CONSTRAINT location_id FOREIGN KEY (location_id) REFERENCES public."location" (id) ON DELETE RESTRICT,
	CONSTRAINT company_id FOREIGN KEY (company_id) REFERENCES public."company" (id) ON DELETE CASCADE
);
INSERT INTO public."job" VALUES
	(1, 'Vaga Um', 'Descrição Vaga Um', 1, 1),
	(2, 'Vaga Dois', 'Descrição Vaga Dois', 2, 1),
	(3, 'Vaga Um', 'Descrição Vaga Um', 3, 2),
	(4, 'Vaga Dois', 'Descrição Vaga Dois', 4, 2),
	(5, 'Vaga Um', 'Descrição Vaga Um', 5, 3),
	(6, 'Vaga Dois', 'Descrição Vaga Dois', 1, 3),
	(7, 'Vaga Um', 'Descrição Vaga Um', 2, 4),
	(8, 'Vaga Dois', 'Descrição Vaga Dois', 3, 4),
	(9, 'Vaga Um', 'Descrição Vaga Um', 4, 5),
	(10, 'Vaga Dois', 'Descrição Vaga Dois', 5, 5)