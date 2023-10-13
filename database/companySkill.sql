CREATE TABLE IF NOT EXISTS public."companySkill" (
	id SERIAL PRIMARY KEY,
	company_id INT NOT NULL,
	skill_id INT NOT NULL,
	CONSTRAINT company_id FOREIGN KEY (company_id) REFERENCES public."company" (id) ON DELETE CASCADE,
	CONSTRAINT skill_id FOREIGN KEY (skill_id) REFERENCES public."skill" (id) ON DELETE CASCADE
);
INSERT INTO public."companySkill" VALUES
	(1, 1, 1),
	(2, 1, 4),
	(3, 2, 3),
	(4, 3, 4),
	(5, 3, 2),
	(6, 4, 5),
	(7, 5, 1)