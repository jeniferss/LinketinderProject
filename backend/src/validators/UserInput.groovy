package validators

class UserInput {

    boolean isAgeValid(Integer age) {
        try {
            assert age >= 18 && age <= 100
            return true
        } catch (AssertionError ignored) {
            println "A idade informada não é válida."
            return false
        }

    }

    boolean isEmailValid(String email) {
        try {
            assert email.contains("@")
            assert email.endsWith(".com") || email.endsWith(".com.br")
            return true
        } catch (AssertionError ignored) {
            println "O email informado não é válido."
            return false
        }
    }

    boolean isCEPValid(String CEP) {
        try {
            assert CEP.length() == 8
            assert CEP.isNumber()
            return true
        } catch (AssertionError ignored) {
            println "O CEP informado não é válido."
            return false
        }

    }

    boolean isCPFValid(String CPF) {
        try {
            assert CPF.length() == 11
            assert CPF.isNumber()
            return true
        } catch (AssertionError ignored) {
            println "O CPF informado não é válido."
            return false
        }

    }

    boolean isCNPJValid(String CNPJ) {
        try {
            assert CNPJ.length() == 14
            assert CNPJ.isNumber()
            return true
        } catch (AssertionError ignored) {
            println "O CNPJ informado não é válido."
            return false
        }

    }
}
