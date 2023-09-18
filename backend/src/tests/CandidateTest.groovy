package tests

import model.Candidate

class CandidateTest {

    private Candidate candidate

    void run() {
        String testStatus = "SUCESSO"

        println "-----------------------------"
        println "Teste para Classe 'Candidate'"
        println ""

        try {
            /* GIVEN */
            candidate = new Candidate(
                    1,
                    "Candidato Teste",
                    "Descricao do Candidato Teste",
                    "candidatoteste@email.com",
                    "SP",
                    "00000000",
                    "00000000000",
                    20,
                    ["Java", "Python"]
            )

            println "Objeto: ${candidate}"
            println ""

            /* WHEN */
            int id = 1
            String name = "Candidato Teste"
            String description = "Descricao do Candidato Teste"
            String email = "candidatoteste@email.com"
            String state = "SP"
            String CPF = "00000000000"
            String zipcode = "00000000"
            int age = 20
            List<String> skills = ["Java", "Python"]

            /* THEN */
            assert candidate.getId() == id
            assert candidate.getName() == name
            assert candidate.getDescription() == description
            assert candidate.getEmail() == email
            assert candidate.getState() == state
            assert candidate.getZipcode() == zipcode
            assert candidate.getCPF() == CPF
            assert candidate.getAge() == age
            assert candidate.getSkills() == skills

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"
        }

        println "Status do Teste: ${testStatus}!"
        println "-----------------------------"
        println ""
    }
}
