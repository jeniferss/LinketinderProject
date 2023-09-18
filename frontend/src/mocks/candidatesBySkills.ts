import { ICandidate } from "../interfaces/iPerson";
import CANDIDATES from "./candidates";

interface ICandidatesBySkill {
  [key: string]: number;
}

const CANDIDATES_BY_SKILL: ICandidatesBySkill = {};

for (let index = 0; index < CANDIDATES.length; index++) {
  const candidate: ICandidate = CANDIDATES[index];
  const skills = [...candidate.skills];

  for (let skillIndex = 0; skillIndex < skills.length; skillIndex++) {
    const skill = skills[skillIndex];

    skill in CANDIDATES_BY_SKILL &&
      (CANDIDATES_BY_SKILL[skill] = CANDIDATES_BY_SKILL[skill] + 1);
    !(skill in CANDIDATES_BY_SKILL) && (CANDIDATES_BY_SKILL[skill] = 1);
  }
}

export default CANDIDATES_BY_SKILL;
