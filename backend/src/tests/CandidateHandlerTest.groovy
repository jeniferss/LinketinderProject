package tests

import handlers.CandidateHandler
import model.Candidate
import validators.UserInput

class CandidateHandlerTest {

    private final List<String> allowedSkills = ["Python", "Java", "Javascript", "Typescript"]

    CandidateHandler candidateHandler = new CandidateHandler()
    UserInput validator = new UserInput()

    Map<Integer, Candidate> candidates = [:]

    private List<Map<String, ?>> createInstanceMaps() {
        Map candidateMap = [:]
        candidateMap["id"] = 1
        candidateMap["name"] = "Candidato Teste"
        candidateMap["CPF"] = "00000000000"
        candidateMap["age"] = 20
        candidateMap["description"] = "Descricao do Candidato Teste"
        candidateMap["email"] = "candidatoteste@email.com"
        candidateMap["state"] = "SP"
        candidateMap["zipcode"] = "00000000"
        candidateMap["skills"] = ["Python"]

        Map secondCandidateMap = [:]
        secondCandidateMap["id"] = 2
        secondCandidateMap["name"] = "Candidato Teste 02"
        secondCandidateMap["CPF"] = "000000000"
        secondCandidateMap["age"] = 22
        secondCandidateMap["description"] = "Descricao do Candidato Teste 02"
        secondCandidateMap["email"] = "candidatoteste02@email.com"
        secondCandidateMap["state"] = "SP"
        secondCandidateMap["zipcode"] = "00000000"
        secondCandidateMap["skills"] = ["Java"]

        return [candidateMap, secondCandidateMap]

    }

    private void testIsInstanceMapValidMethod() {
        String testStatus = "SUCESSO"

        println "Teste para Metodo 'isInstanceMapValid()'"
        println ""

        try {
            List<Map<String, ?>> candidatesMap = createInstanceMaps()

            List<List<?>> arguments = [
                    [candidatesMap[0], true],
                    [candidatesMap[1], false]
            ]

            for (List argument in arguments) {
                /* GIVEN */
                Map<String, ?> candidateMap = argument[0] as Map
                println "Objeto: ${candidateMap}"

                boolean expectedResult = argument[1] as boolean

                /* WHEN */
                boolean isInstanceMapValid = candidateHandler.isInstanceMapValid(validator, candidateMap)
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
            List<Map<String, ?>> candidatesMap = createInstanceMaps()

            List<List<?>> arguments = [
                    [candidatesMap[0], true],
                    [candidatesMap[1], false]
            ]

            for (List argument in arguments) {
                /* GIVEN */
                Map<String, ?> candidateMap = argument[0] as Map
                println "Objeto: ${candidateMap}"

                boolean expectedResult = argument[1] as boolean

                /* WHEN */
                candidateHandler.createInstance(validator, candidateMap, candidates, allowedSkills)
                boolean wasCandidateCreated = candidates.get(candidateMap.get("id"))
                println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${wasCandidateCreated}"
                println ""

                /* THEN */
                assert wasCandidateCreated == expectedResult

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
