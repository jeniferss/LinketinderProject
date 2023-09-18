package tests


import model.Company

class CompanyTest {

    private Company company

    void run() {
        String testStatus = "SUCESSO"

        println "-----------------------------"
        println "Teste para Classe 'Company'"
        println ""

        try {
            /* GIVEN */
            company = new Company(
                    1,
                    "Empresa Teste",
                    "Descricao da Empresa Teste",
                    "empresateste@email.com",
                    "SP",
                    "00000000",
                    "00000000000000",
                    "Brasil",
                    ["Javascript"]
            )

            println "Objeto: ${company}"
            println ""

            /* WHEN */
            int id = 1
            String name = "Empresa Teste"
            String description = "Descricao da Empresa Teste"
            String email = "empresateste@email.com"
            String state = "SP"
            String CNPJ = "00000000000000"
            String zipcode = "00000000"
            String country = "Brasil"
            List<String> skills = ["Javascript"]

            /* THEN */
            assert company.getId() == id
            assert company.getName() == name
            assert company.getDescription() == description
            assert company.getEmail() == email
            assert company.getState() == state
            assert company.getZipcode() == zipcode
            assert company.getCNPJ() == CNPJ
            assert company.getCountry() == country
            assert company.getSkills() == skills

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"
        }

        println "Status do Teste: ${testStatus}!"
        println "-----------------------------"
        println ""
    }
}
