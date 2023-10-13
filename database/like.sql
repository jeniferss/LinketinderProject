CREATE TABLE IF NOT EXISTS public."like" (
	id SERIAL PRIMARY KEY,
	candidate_id INT,
	company_id INT,
	job_id INT,
	CONSTRAINT no_repeat UNIQUE (candidate_id, company_id, job_id),
	CONSTRAINT company_id FOREIGN KEY (company_id) REFERENCES public."company" (id) ON DELETE CASCADE,
	CONSTRAINT candidate_id FOREIGN KEY (candidate_id) REFERENCES public."candidate" (id) ON DELETE CASCADE,
	CONSTRAINT job_id FOREIGN KEY (job_id) REFERENCES public."job" (id) ON DELETE CASCADE
);
INSERT INTO public."like" VALUES
	(1, 1, 1, 1),
	(2, 2, NULL, 3),
	(3, 4, 3, NULL)
