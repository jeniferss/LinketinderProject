package tests


import validators.UserInput

class UserInputTest {

    private validator = new UserInput()

    private void testIsAgeValidMethod() {
        String testStatus = "SUCESSO"

        println "Teste para Metodo 'isAgeValidMethod()'"
        println ""

        try {
            List<List<?>> arguments = [
                    [22, true],
                    [101, false]
            ]

            for (List argument in arguments) {
                /* GIVEN */
                int age = argument[0] as Integer
                println "Idade fornecida: ${age}"

                boolean expectedResult = argument[1] as boolean

                /* WHEN */
                boolean isAgeValid = validator.isAgeValid(age)
                println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${isAgeValid}"
                println ""

                /* THEN */
                assert isAgeValid == expectedResult

            }

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"

        } finally {
            println "Status do Teste: ${testStatus}!"
        }

    }

    private void testIsCEPValidMethod() {
        String testStatus = "SUCESSO"

        println "Teste para Metodo 'isCEPValidMethod()'"
        println ""

        try {
            List<List<?>> arguments = [
                    ['00000000', true],
                    ['000', false],
                    ['000A0000', false]
            ]

            for (List argument in arguments) {
                /* GIVEN */
                String CEP = argument[0] as String
                println "CEP fornecido: ${CEP}"

                boolean expectedResult = argument[1] as boolean

                /* WHEN */
                boolean isCEPValid = validator.isCEPValid(CEP)
                println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${isCEPValid}"
                println ""

                /* THEN */
                assert isCEPValid == expectedResult

            }

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"

        } finally {
            println "Status do Teste: ${testStatus}!"
        }

    }

    private void testIsEmailValidMethod() {
        String testStatus = "SUCESSO"

        println "Teste para Metodo 'isEmailValidMethod()'"
        println ""

        try {
            List<List<?>> arguments = [
                    ['email@email.com.br', true],
                    ['email@email.com', true],
                    ['email.com', false],
                    ['email@email', false],
            ]

            for (List argument in arguments) {
                /* GIVEN */
                String email = argument[0] as String
                println "Email fornecido: ${email}"

                boolean expectedResult = argument[1] as boolean

                /* WHEN */
                boolean isEmailValid = validator.isEmailValid(email)
                println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${isEmailValid}"
                println ""

                /* THEN */
                assert isEmailValid == expectedResult

            }

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"

        } finally {
            println "Status do Teste: ${testStatus}!"
        }

    }

    private void testIsCPFValidMethod() {
        String testStatus = "SUCESSO"

        println "Teste para Metodo 'isCPFValidMethod()'"
        println ""

        try {
            List<List<?>> arguments = [
                    ['00000000000', true],
                    ['000', false],
                    ['000A0000000', false]
            ]

            for (List argument in arguments) {
                /* GIVEN */
                String CPF = argument[0] as String
                println "CPF fornecido: ${CPF}"

                boolean expectedResult = argument[1] as boolean

                /* WHEN */
                boolean isCPFValid = validator.isCPFValid(CPF)
                println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${isCPFValid}"
                println ""

                /* THEN */
                assert isCPFValid == expectedResult

            }

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"

        } finally {
            println "Status do Teste: ${testStatus}!"
        }

    }

    private void testIsCNPJValidMethod() {
        String testStatus = "SUCESSO"

        println "Teste para Metodo 'isCNPJValidMethod()'"
        println ""

        try {
            List<List<?>> arguments = [
                    ['00000000000000', true],
                    ['000', false],
                    ['000A0000000000', false]
            ]

            for (List argument in arguments) {
                /* GIVEN */
                String CNPJ = argument[0] as String
                println "CNPJ fornecido: ${CNPJ}"

                boolean expectedResult = argument[1] as boolean

                /* WHEN */
                boolean isCNPJValid = validator.isCNPJValid(CNPJ)
                println "Resultado Esperado: ${expectedResult} | Resultado Obtido: ${isCNPJValid}"
                println ""

                /* THEN */
                assert isCNPJValid == expectedResult

            }

        } catch (AssertionError ignored) {
            testStatus = "FALHOU"

        } finally {
            println "Status do Teste: ${testStatus}!"
        }

    }

    void run() {
        println "-----------------------------"
        println "Teste para Classe 'User Input'"

        testIsAgeValidMethod()
        println ""
        testIsEmailValidMethod()
        println ""
        testIsCEPValidMethod()
        println ""
        testIsCPFValidMethod()
        println ""
        testIsCNPJValidMethod()

        println "-----------------------------"

    }

}


