import app.Linketinder
import handlers.CandidateHandler
import handlers.CompanyHandler
import handlers.DataHandler
import validators.UserInput

static void main(String[] args) {

    final List<String> allowedSkills = ["Python", "Java", "Javascript", "Typescript"]

    UserInput validator = new UserInput()
    CompanyHandler companyHandler = new CompanyHandler()
    CandidateHandler candidateHandler = new CandidateHandler()

    DataHandler dataHandler = new DataHandler()
    dataHandler.generateCompanyMockData(validator, companyHandler, allowedSkills)
    dataHandler.generateCandidateMockData(validator, candidateHandler, allowedSkills)

    def companies = dataHandler.getCompanies()
    def candidates = dataHandler.getCandidates()

    Linketinder app = new Linketinder(allowedSkills, candidates, companies, candidateHandler, companyHandler, validator)
    app.execute()

}