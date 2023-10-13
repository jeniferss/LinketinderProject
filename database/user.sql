CREATE TABLE IF NOT EXISTS public."user" (
	id SERIAL PRIMARY KEY,
	email VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);
INSERT INTO public."user" VALUES
	(1, 'usuarioum@email.com', 'senhaum'),
	(2, 'usuariodois@email.com', 'senhadois'),
	(3, 'usuariotres@email.com', 'senhatres'),
	(4, 'usuarioquatro@email.com', 'senhaquatro'),
	(5, 'usuariocinco@email.com', 'senhacinco'),
    (6, 'usuarioseis@email.com', 'senhaseis'),
    (7, 'usuariosete@email.com', 'senhasete'),
    (8, 'usuariooito@email.com', 'senhaoito'),
    (9, 'usuarionove@email.com', 'senhanove'),
    (10, 'usuariodez@email.com', 'senhadez')