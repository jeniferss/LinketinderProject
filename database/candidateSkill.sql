CREATE TABLE IF NOT EXISTS public."candidateSkill" (
	id SERIAL PRIMARY KEY,
	candidate_id INT NOT NULL,
	skill_id INT NOT NULL,
	CONSTRAINT candidate_id FOREIGN KEY (candidate_id) REFERENCES public."candidate" (id) ON DELETE CASCADE,
	CONSTRAINT skill_id FOREIGN KEY (skill_id) REFERENCES public."skill" (id) ON DELETE CASCADE
);
INSERT INTO public."candidateSkill" VALUES
	(1, 1, 1),
	(2, 1, 4),
	(3, 2, 3),
	(4, 3, 4),
	(5, 3, 2),
	(6, 4, 5),
	(7, 5, 1)

