import AlertHandler from "./alertHandler";

import { ICandidate, ICompany, IPerson } from "../interfaces/iPerson";

const initialValue: IPerson = {
  id: null,
  name: null,
  description: null,
  email: null,
  zipcode: null,
  state: null,
  skills: [],
};

const candidateInitialValue: ICandidate = {
  ...initialValue,
  cpf: null,
  age: null,
};

const companyInitialValue: ICompany = {
  ...initialValue,
  cnpj: null,
  country: null,
};

class PersonFormHandler {
  newPerson: ICandidate | ICompany;
  personType: string;
  personList: ICandidate[] | ICompany[];

  constructor(personType: string, personList: ICandidate[] | ICompany[]) {
    this.personType = personType;
    this.personList = personList;

    this.setInitialValue();
  }

  setInitialValue() {
    this.personType === "candidate"
      ? (this.newPerson = { ...candidateInitialValue })
      : (this.newPerson = { ...companyInitialValue });
  }

  clearInputs() {
    const inputs = document.getElementsByClassName("form-control");
    Array.from(inputs).forEach((element: any) => {
      element.value = null;
    });
  }

  generateID(): number {
    return this.personList.length === 0
      ? 1
      : Math.max(...this.personList.map((person) => person.id)) + 1;
  }

  isFormValid(person: ICandidate | ICompany): boolean {
      const hasNull = Object.values(person).some((property) => property === null);

      const emailExpression: RegExp =
        /^[a-z\.\_\-]+[\.\_\-a-z0-9]+@[a-z]+(\.[a-z]{1,3}){1,2}$/;
      const isEmailValid = emailExpression.test(person.email);

      const stateExpression: RegExp = /[A-Z]{2}/i;
      const isStateValid =
        this.personType === "candidate"
          ? true
          : stateExpression.test(person.state);

      const zipcodeExpression: RegExp = /(?!(\d)\1)\d{8}/;
      const isZipcodeValid = zipcodeExpression.test(person.zipcode);

      const documentExpression: RegExp =
        this.personType === "candidate" ? /(?!(\d)\1)\d{11}/ : /(?!(\d)\1)\d{14}/;
      const isDocumentValid = documentExpression.test(
        this.personType === "candidate"
          ? (person as ICandidate).cpf
          : (person as ICompany).cnpj
      );

      const nameExpression: RegExp = /[A-Z]+[a-z]+/;
      const isNameValid = nameExpression.test(person.name);

      return (
        !hasNull &&
        isNameValid &&
        isDocumentValid &&
        isEmailValid &&
        isZipcodeValid &&
        isStateValid
      );
  }

  addFormListener() {
    const alertHandler = new AlertHandler();

    const nameInput = document.getElementById("name");
    nameInput.addEventListener("keyup", (event: KeyboardEvent) => {
      this.newPerson.name = (event.target as HTMLInputElement).value;
    });

    const emailInput = document.getElementById("email");
    emailInput.addEventListener("keyup", (event: KeyboardEvent) => {
      this.newPerson.email = (event.target as HTMLInputElement).value;
    });

    const descriptionInput = document.getElementById("description");
    descriptionInput.addEventListener("keyup", (event: KeyboardEvent) => {
      this.newPerson.description = (event.target as HTMLInputElement).value;
    });

    const zipcodeInput = document.getElementById("zipcode");
    zipcodeInput.addEventListener("keyup", (event: KeyboardEvent) => {
      this.newPerson.zipcode = (event.target as HTMLInputElement).value;
    });

    const stateInput = document.getElementById("state");
    stateInput.addEventListener("keyup", (event: KeyboardEvent) => {
      this.newPerson.state = (event.target as HTMLInputElement).value;
    });

    const documentInput = document.getElementById("document");
    documentInput.addEventListener("keyup", (event: KeyboardEvent) => {
      this.personType === "candidate"
        ? ((this.newPerson as ICandidate).cpf = (
            event.target as HTMLInputElement
          ).value)
        : ((this.newPerson as ICompany).cnpj = (
            event.target as HTMLInputElement
          ).value);
    });

    const skillsSelector = document.getElementById("skills");
    skillsSelector.addEventListener("change", (event: any) => {
      this.newPerson.skills = [...this.newPerson.skills, event.target.value];
    });

    if (this.personType === "candidate") {
      const ageInput = document.getElementById("age");
      ageInput.addEventListener("keyup", (event: any) => {
        (this.newPerson as ICandidate).age = Number.parseInt(
          event.target.value
        );
      });
    } else {
      const countryInput = document.getElementById("country");
      countryInput.addEventListener("keyup", (event: any) => {
        (this.newPerson as ICompany).country = (
          event.target as HTMLInputElement
        ).value;
      });
    }

    const registerButton = document.getElementById("register-btn");
    registerButton.addEventListener("click", () => {
      this.newPerson.id = this.generateID();

      const isValid = this.isFormValid(this.newPerson);

      if (!isValid) {
        alertHandler.show({
          type: "danger",
          message: `Falha ao criar ${
            this.personType === "candidate" ? "Candidato" : "Empresa"
          }, preencha o formulário novamente.`,
        });
      } else {
        this.personType === "candidate"
          ? (this.personList as ICandidate[]).push(this.newPerson as ICandidate)
          : (this.personList as ICompany[]).push(this.newPerson as ICompany);

        alertHandler.show({
          type: "success",
          message: `Cadastro de ${
            this.personType === "candidade" ? "Candidato" : "Empresa"
          } feito com sucesso!`,
        });
      }

      this.setInitialValue();
      this.clearInputs();
    });
  }
}

export default PersonFormHandler;
