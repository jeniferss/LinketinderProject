import CANDIDATES_BY_SKILL from "../../mocks/candidatesBySkills";
import PageNavigator from "../../services/pageNavigator";
import CANDIDATES from "../../mocks/candidates";
import { ICandidate, IPerson } from "../../interfaces/iPerson";
import COMPANIES from "../../mocks/companies";
import IJob from "../../interfaces/iJob";
import JOBS from "../../mocks/jobs";

var Plotly = require("plotly.js-dist-min");

const loadProfile = (person: IPerson) => {
  const name = document.getElementById("cname");
  name.innerHTML = person.name;

  const address = document.getElementById("caddress");
  address.innerText = person.zipcode + ", " + person.state;

  const description = document.getElementById("cdescription");
  description.innerText = person.description;

  const cardBody = document.getElementById("card-body");
  let content = "";

  for (let index = 0; index < person.skills.length; index++) {
    const skill = `
      <span class="badge bg-warning text-dark">${person.skills[index]}</span>
    `;
    content += skill;
  }

  cardBody.innerHTML += content;
};

const loadGraph = () => {
  const stats = document.getElementById("stats");
  stats.style.visibility = "visible";

  const xArray = [];
  const yArray = [];

  for (let skill in CANDIDATES_BY_SKILL) {
    yArray.push(CANDIDATES_BY_SKILL[skill]);
    xArray.push(skill);
  }

  const data = [
    {
      x: xArray,
      y: yArray,
      type: "bar",
      orientation: "v",
      marker: { color: "#f96126" },
    },
  ];

  const layout = { title: "Candidatos por Habilidades" };

  Plotly.newPlot(stats, data, layout, { displayModeBar: false });
};

const isJob = (obj: any): obj is IJob => {
  return obj.company !== undefined;
};

const loadList = (objectList: IJob[] | ICandidate[]) => {
  const tbody = document.getElementsByTagName("tbody")[0];

  objectList.forEach((element) => {
    let skills: string[];
    isJob(element)
      ? (skills = element.company.skills)
      : (skills = element.skills);

    const row = `
      <tr>
        <td>${element.description}</td>
        <td>${skills.join(", ")}</td>
      </tr>
    `;

    tbody.innerHTML += row;
  });
};

const mainCandidateScript = () => {
  const pageNavigator = new PageNavigator();

  const registerButton = document.getElementById("register-btn");
  registerButton.innerText = "Cadastrar Candidato";
  registerButton.addEventListener("click", () => {
    pageNavigator.load(1);
  });

  loadProfile(CANDIDATES[0]);
  loadList(JOBS);
};

const mainCompanyScript = () => {
  const pageNavigator = new PageNavigator();

  const registerButton = document.getElementById("register-btn");
  registerButton.innerText = "Cadastrar Empresa";
  registerButton.addEventListener("click", () => {
    pageNavigator.load(2);
  });

  loadProfile(COMPANIES[0]);
  loadGraph();
  loadList(CANDIDATES);
};

export { mainCandidateScript, mainCompanyScript };
