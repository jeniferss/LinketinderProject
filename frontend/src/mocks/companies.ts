import { ICompany } from "../interfaces/iPerson";
import { COMBINATIONS } from "./skills";

const COMPANIES: ICompany[] = [];

function generateRandomIndex(from: number, to: number): number {
  let randNumber = Math.random();
  return Math.floor(randNumber * (to - from) + from);
}

for (let index = 0; index < 5; index++) {
  const randomIndex = generateRandomIndex(0, COMBINATIONS.length - 1);

  const company: ICompany = {
    id: index + 1,
    name: `Empresa ${index}`,
    description: `Descrição da Empresa ${index}`,
    cnpj: `${index}0000000000000`,
    country: "Brasil",
    email: `empresa${index}@email.com`,
    zipcode: `${index}0000000`,
    state: `E${index}`,
    skills: COMBINATIONS[randomIndex],
  };

  COMPANIES.push(company);
}

export default COMPANIES;
