package tests

class RunTest {
    static void main(String[] args) {
        CandidateTest candidateTest = new CandidateTest()
        candidateTest.run()

        CompanyTest companyTest = new CompanyTest()
        companyTest.run()

        CandidateHandlerTest candidateHandlerTest = new CandidateHandlerTest()
        candidateHandlerTest.run()

        CompanyHandlerTest companyHandlerTest = new CompanyHandlerTest()
        companyHandlerTest.run()

        UserInputTest userInputTest = new UserInputTest()
        userInputTest.run()

        DataHandlerTest dataHandlerTest = new DataHandlerTest()
        dataHandlerTest.run()

    }
}
