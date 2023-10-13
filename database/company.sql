CREATE TABLE IF NOT EXISTS public."company" (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	cnpj VARCHAR(14) NOT NULL UNIQUE,
	description VARCHAR(255) NOT NULL,
	location_id INT NOT NULL,
	user_id INT NOT NULL UNIQUE,
	CONSTRAINT location_id FOREIGN KEY (location_id) REFERENCES public."location" (id) ON DELETE RESTRICT,
	CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public."user" (id) ON DELETE CASCADE
);
INSERT INTO public."company" VALUES
	(1, 'Empresa Um', '00000000000000', 'Descrição Um', 1, 6),
	(2, 'Empresa Dois', '00000000000001', 'Descrição Dois', 2, 7),
	(3, 'Empresa Três', '00000000000002', 'Descrição Três', 3, 8),
	(4, 'Empresa Quatro', '00000000000003', 'Descrição Quatro', 4, 9),
	(5, 'Empresa Cinco', '00000000000004', 'Descrição Cinco', 5, 10)