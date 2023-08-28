package tests

import handlers.CandidateHandler
import handlers.CompanyHandler
import handlers.DataHandler
import validators.UserInput

class DataHandlerTest {

    private final List<String> allowedSkills = ["Python", "Java", "Javascript", "Typescript"]

    private DataHandler dataHandler = new DataHandler()
    private CandidateHandler candidateHandler = new CandidateHandler()
    private CompanyHandler companyHandler = new CompanyHandler()
    private UserInput validator = new UserInput()

    def run() {
        String testStatus = "SUCESSO"

        println "-----------------------------"
        println "Teste para Classe 'Data Handler'"

        try {
            println "Teste para Metodo 'generateCandidateMockData' e 'getCandidates()'"
            println ""

            /* GIVEN */
            dataHandler.generateCandidateMockData(validator, candidateHandler, allowedSkills)
            println "Objeto: ${dataHandler.getCandidates()}"

            int expectedResult = 5

            /* WHEN */
            int numberOfCandidates = dataHandler.getCandidates().size()
            println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${numberOfCandidates}"
            println ""

            /* THEN */
            assert numberOfCandidates == expectedResult

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"
        }

        println "Status do Teste: ${testStatus}!"
        println ""

        try {
            println "Teste para Metodo 'generateCompanyMockData' e 'getCandidates()'"
            println ""

            /* GIVEN */
            dataHandler.generateCompanyMockData(validator, companyHandler, allowedSkills)
            println "Objeto: ${dataHandler.getCompanies()}"

            int expectedResult = 5

            /* WHEN */
            int numberOfCompanies = dataHandler.getCompanies().size()
            println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${numberOfCompanies}"
            println ""

            /* THEN */
            assert numberOfCompanies == expectedResult

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"
        }

        println "Status do Teste: ${testStatus}!"
        println "-----------------------------"

    }
}
