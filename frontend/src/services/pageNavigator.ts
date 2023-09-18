import home from "../pages/Home/index.html";
import homeScript from "../pages/Home";

import candidateRegistration from "../pages/Registration/index.html";
import {
  candidateRegistrationScript,
  companyRegistrationScript,
} from "../pages/Registration";

import mainPage from "../pages/Main/index.html";
import { mainCandidateScript, mainCompanyScript } from "../pages/Main";
import CANDIDATES_BY_SKILL from "../mocks/candidatesBySkills";

interface IPage {
  content: string;
  title: string;
  script: () => void;
}

interface IPages {
  [key: number]: IPage;
}

class PageNavigator {
  PAGES: IPages = {
    0: {
      content: home,
      title: "Home",
      script: homeScript,
    },
    1: {
      content: candidateRegistration,
      title: "Registro de Candidato",
      script: candidateRegistrationScript,
    },
    2: {
      content: candidateRegistration,
      title: "Registro de Empresa",
      script: companyRegistrationScript,
    },
    3: {
      content: mainPage,
      title: "Principal",
      script: mainCandidateScript,
    },
    4: {
      content: mainPage,
      title: "Principal",
      script: mainCompanyScript,
    },
  };

  load(selectedPage: number = 0) {
    const pageConfig: IPage = this.PAGES[selectedPage];

    const pageTitle = document.getElementById("page-title");
    pageTitle!.innerHTML = pageConfig.title;

    const content = document.getElementById("content");
    content!.innerHTML = pageConfig.content;

    pageConfig.script();
  }
}

export default PageNavigator;
