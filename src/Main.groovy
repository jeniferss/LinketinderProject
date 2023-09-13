import app.Linketinder
import handlers.*
import validators.UserInput

static void main(String[] args) {

    final List<String> allowedSkills = ["Python", "Java", "Javascript", "Typescript"]

    UserInput validator = new UserInput()
    CompanyHandler companyHandler = new CompanyHandler()
    CandidateHandler candidateHandler = new CandidateHandler()
    JobHandler jobHandler = new JobHandler()
    LikeHandler likeHandler = new LikeHandler()

    DataHandler dataHandler = new DataHandler()
    dataHandler.generateCompanyMockData(validator, companyHandler, allowedSkills)
    dataHandler.generateCandidateMockData(validator, candidateHandler, allowedSkills)
    dataHandler.generateJobMockData(validator, jobHandler, allowedSkills)

    def companies = dataHandler.getCompanies()
    def candidates = dataHandler.getCandidates()
    def jobs = dataHandler.getJobs()
    def likes = dataHandler.getLikes()

    Linketinder app = new Linketinder(
            allowedSkills, candidates, companies, jobs, likes,
            candidateHandler, companyHandler, jobHandler, likeHandler,
            validator
    )
    app.execute()

}