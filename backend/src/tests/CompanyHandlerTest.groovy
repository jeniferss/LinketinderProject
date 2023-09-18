package tests


import handlers.CompanyHandler
import model.Company
import validators.UserInput

class CompanyHandlerTest {

    final List<String> allowedSkills = ["Python", "Java", "Javascript", "Typescript"]

    private CompanyHandler companyHandler = new CompanyHandler()
    private UserInput validator = new UserInput()

    Map<Integer, Company> companies = [:]

    private List<Map<String, ?>> createInstanceMaps() {
        Map companyMap = [:]
        companyMap["id"] = 1
        companyMap["name"] = "Empresa Teste"
        companyMap["CNPJ"] = "00000000000000"
        companyMap["country"] = "Brasil"
        companyMap["description"] = "Descricao da Empresa Teste"
        companyMap["email"] = "empresateste@email.com"
        companyMap["state"] = "SP"
        companyMap["zipcode"] = "00000000"
        companyMap["skills"] = ["Python"]

        Map secondCompanyMap = [:]
        secondCompanyMap["id"] = 2
        secondCompanyMap["name"] = "Empresa Teste 02"
        secondCompanyMap["CNPJ"] = "00000000000"
        secondCompanyMap["country"] = "Brasil"
        secondCompanyMap["description"] = "Descricao da Empresa Teste 02"
        secondCompanyMap["email"] = "empresateste02@email.com"
        secondCompanyMap["state"] = "ES"
        secondCompanyMap["zipcode"] = "00000000"
        secondCompanyMap["skills"] = ["Java"]

        return [companyMap, secondCompanyMap]

    }

    private void testIsInstanceMapValidMethod() {
        String testStatus = "SUCESSO"

        println "Teste para Metodo 'isInstanceMapValid()'"
        println ""

        try {
            List<Map<String, ?>> companiesMap = createInstanceMaps()

            List<List<?>> arguments = [
                    [companiesMap[0], true],
                    [companiesMap[1], false]
            ]

            for (argument in arguments) {
                /* GIVEN */
                Map<String, ?> companyMap = argument[0] as Map
                println "Objeto: ${companyMap}"

                boolean expectedResult = argument[1]

                /* WHEN */
                boolean isInstanceMapValid = companyHandler.isInstanceMapValid(validator, companyMap)
                println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${isInstanceMapValid}"
                println ""

                /* THEN */
                assert isInstanceMapValid == expectedResult
            }

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"

        } finally {
            println "Status do Teste: ${testStatus}!"
        }

    }

    private void testCreateInstanceMethod() {
        String testStatus = "SUCESSO"

        println "Teste para Metodo 'createInstance()'"
        println ""

        try {
            List<Map<String, ?>> companiesMap = createInstanceMaps()

            List<List<?>> arguments = [
                    [companiesMap[0], true],
                    [companiesMap[1], false]
            ]

            for (argument in arguments) {
                /* GIVEN */
                Map<String, ?> companyMap = argument[0] as Map
                println "Objeto: ${companyMap}"

                boolean expectedValue = argument[1] as boolean

                /* WHEN */
                companyHandler.createInstance(validator, companyMap, companies, allowedSkills)
                boolean wasCompanyCreated = companies.get(companyMap.get("id"))
                println "Resultado Esperado: ${expectedValue} | Resultado Obtido: ${wasCompanyCreated}"
                println ""

                /* THEN */
                assert wasCompanyCreated == expectedValue
            }

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"

        } finally {
            println "Status do Teste: ${testStatus}!"
        }

    }

    void run() {
        println "-----------------------------"
        println "Teste para Classe 'Candidate Handler'"

        testIsInstanceMapValidMethod()
        println ""
        testCreateInstanceMethod()

        println "-----------------------------"

    }
}
