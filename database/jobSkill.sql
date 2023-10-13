CREATE TABLE IF NOT EXISTS public."jobSkill" (
	id SERIAL PRIMARY KEY,
	job_id INT NOT NULL,
	skill_id INT NOT NULL,
	CONSTRAINT job_id FOREIGN KEY (job_id) REFERENCES public."job" (id) ON DELETE CASCADE,
	CONSTRAINT skill_id FOREIGN KEY (skill_id) REFERENCES public."skill" (id) ON DELETE CASCADE
);
INSERT INTO public."jobSkill" VALUES
	(1, 1, 1),
	(2, 2, 4),
	(3, 3, 3),
	(4, 4, 4),
	(5, 5, 2),
	(6, 6, 5),
	(7, 7, 1),
	(8, 8, 2),
	(9, 9, 1),
	(10, 10, 1)