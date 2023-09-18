import PersonFormHandler from "../../services/formHandler";

import { ALLOWED_SKILLS } from "../../mocks/skills";

import COMPANIES from "../../mocks/companies";
import CANDIDATES from "../../mocks/candidates";

interface IDocument {
  label: string;
  placeholder: string;
}

const loadSkills = (): void => {
  let options = "<option selected value=''></option>";

  ALLOWED_SKILLS.forEach((skill) => {
    const option = `<option value=${skill.toLowerCase()}>${skill}</option>`;
    options += option;
  });

  const skillsInput = document.getElementById("skills");
  skillsInput.innerHTML = options;
};

const loadCandidateAge = (): void => {
  const ageInput = document.getElementById("age-container");
  ageInput.style.visibility = "visible";
};

const loadCompanyCountry = () => {
  const countryInput = document.getElementById("country-container");
  countryInput.style.visibility = "visible";
};

const loadDocument = ({ label, placeholder }: IDocument) => {
  const documentInput = document.getElementById("document");
  documentInput.setAttribute("placeholder", placeholder);

  const documentLabel = document.getElementById("document-label");
  documentLabel.innerHTML = label;
};

const candidateRegistrationScript = () => {
  loadSkills();

  loadCandidateAge();
  loadDocument({ label: "CPF", placeholder: "00000000000" });

  const personFormHandler = new PersonFormHandler("candidate", CANDIDATES);
  personFormHandler.addFormListener();
};

const companyRegistrationScript = () => {
  loadSkills();

  loadCompanyCountry();
  loadDocument({ label: "CNPJ", placeholder: "00000000000000" });

  const personFormHandler = new PersonFormHandler("company", COMPANIES);
  personFormHandler.addFormListener();
};

export { candidateRegistrationScript, companyRegistrationScript };
