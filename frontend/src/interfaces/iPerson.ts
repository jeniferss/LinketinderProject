interface IPerson {
  id: number;
  name: string;
  description: string;
  email: string;
  zipcode: string;
  state: string;
  skills: string[];
}

interface ICandidate extends IPerson {
  cpf: string;
  age: number;
}

interface ICompany extends IPerson {
  country: string;
  cnpj: string;
}

export { IPerson, ICandidate, ICompany };
