import IJob from "../interfaces/iJob";
import COMPANIES from "./companies";

const JOBS: IJob[] = [];

for (let index = 0; index < 5; index++) {
  const job: IJob = {
    id: index + 1,
    name: `Vaga ${index}`,
    description: `Descrição da Vaga ${index}`,
    company: COMPANIES[index],
  };

  JOBS.push(job);
}

export default JOBS;
