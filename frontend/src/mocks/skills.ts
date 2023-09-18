const ALLOWED_SKILLS: string[] = ["Python", "Java", "Javascript", "Typescript"];

function combineSkills() {
  let combined: string[][] = [];
  let temp: string[] = [];
  const maxCombinations = Math.pow(2, ALLOWED_SKILLS.length);

  for (
    let combinationNumber = 0;
    combinationNumber < maxCombinations;
    combinationNumber++
  ) {
    temp = [];
    for (var index = 0; index < ALLOWED_SKILLS.length; index++) {
      combinationNumber & Math.pow(2, index) &&
        temp.push(ALLOWED_SKILLS[index]);
    }
    temp.length > 0 && combined.push(temp);
  }

  combined.sort(
    (firstArray: string[], secondArray: string[]) =>
      firstArray.length - secondArray.length
  );
  return combined;
}

const COMBINATIONS = combineSkills();
export { ALLOWED_SKILLS, COMBINATIONS };
