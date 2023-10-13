CREATE TABLE IF NOT EXISTS public."location" (
	id SERIAL PRIMARY KEY,
	country VARCHAR(255) NOT NULL,
	state VARCHAR(2) NOT NULL,
	city VARCHAR(255) NOT NULL,
	zipcode VARCHAR(8) NOT NULL
);
INSERT INTO public."location" VALUES
	(1, 'Brasil', 'SP', 'Diadema', '09910000'),
	(2, 'Brasil', 'SP', 'São Bernardo do Campo', '09840900'),
	(3, 'Brasil', 'SP', 'Santo André', '09240970'),
	(4, 'Brasil', 'SP', 'São Caetano do Sul', '09520900'),
	(5, 'Brasil', 'SP', 'Mauá', '09371905')
