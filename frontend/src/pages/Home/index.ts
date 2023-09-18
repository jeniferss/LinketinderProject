import PageNavigator from "../../services/pageNavigator";

const homeScript = () => {
  const pageNavigator = new PageNavigator();

  const candidateButton = document.getElementById("candidate-btn");
  const companyButton = document.getElementById("company-btn");

  candidateButton.addEventListener("click", function () {
    pageNavigator.load(3);
  });
  companyButton.addEventListener("click", function () {
    pageNavigator.load(4);
  });
};

export default homeScript;
