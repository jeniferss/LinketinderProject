import { ICandidate } from "../interfaces/iPerson";
import { COMBINATIONS } from "./skills";

const CANDIDATES: ICandidate[] = [];

function generateRandomIndex(from: number, to: number): number {
  let randNumber = Math.random();
  return Math.floor(randNumber * (to - from) + from);
}

for (let index = 0; index < 5; index++) {
  const randomIndex = generateRandomIndex(0, COMBINATIONS.length - 1);

  const candidate: ICandidate = {
    id: index + 1,
    name: `Candidato ${index}`,
    description: `Descrição do Candidato ${index}`,
    cpf: `${index}0000000000`,
    age: Number.parseInt(`2${index}`),
    email: `candidato${index}@email.com`,
    zipcode: `${index}0000000`,
    state: `E${index}`,
    skills: COMBINATIONS[randomIndex],
  };

  CANDIDATES.push(candidate);
}

export default CANDIDATES;
