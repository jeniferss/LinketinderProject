package handlers

import model.Company
import validators.UserInput

class CompanyHandler extends InstanceHandler {

    @Override
    Map<String, ?> readUserInputAndCreateInstanceMap(Map<Integer, ?> companies, List<String> allowedSkills) {
        Map<String, ?> companyMap = [:]

        Integer id = generateInstanceId(companies)
        companyMap["id"] = id

        println 'Digite o nome: '
        String name = System.in.newReader().readLine()
        companyMap["name"] = name

        println 'Digite o CNPJ (ex. xxxxxxxxxxxxxx): '
        String CNPJ = System.in.newReader().readLine()
        companyMap["CNPJ"] = CNPJ

        println 'Digite a descricao: '
        String description = System.in.newReader().readLine()
        companyMap["description"] = description

        println 'Digite o email (ex. xxxx@xxx.com(.br)): '
        String email = System.in.newReader().readLine()
        companyMap["email"] = email

        println 'Digite o estado (exs. SP, RJ, ES): '
        String state = System.in.newReader().readLine()
        companyMap["state"] = state

        println 'Digite o CEP (ex. xxxxxxxx): '
        String zipcode = System.in.newReader().readLine()
        companyMap["zipcode"] = zipcode

        println 'Digite o pais (exs. Brasil, Argentina): '
        String country = System.in.newReader().readLine()
        companyMap["country"] = country

        List<String> skills = []
        allowedSkills.forEach { skill ->
            println "Precisa conhecer ${skill.toUpperCase()} ? [S] [N]"
            String hasSkill = System.in.newReader().readLine()
            if (hasSkill.toUpperCase() == "S") {
                skills.add(skill)
            }
        }
        companyMap["skills"] = skills

        return companyMap
    }

    @Override
    boolean isInstanceMapValid(UserInput validator, Map<String, ?> companyMap) {
        try {
            assert validator.isCNPJValid(companyMap.get("CNPJ") as String)
            assert validator.isEmailValid(companyMap.get("email") as String)

            return true
        } catch (AssertionError ignored) {

        } catch (Exception ignored) {
            println "Alguma informação preenchida está incorreta. Por favor, tente novamente."
        }

        return false
    }

    @Override
    void createInstance(UserInput validator, Map<String, ?> companyMap, Map<Integer, ?> companies, List<String> allowedSkills) {

        if (isInstanceMapValid(validator, companyMap)) {
            Company company = new Company(
                    companyMap.get("id") as Integer,
                    companyMap.get("name") as String,
                    companyMap.get("description") as String,
                    companyMap.get("email") as String,
                    companyMap.get("state") as String,
                    companyMap.get("zipcode") as String,
                    companyMap.get("CNPJ") as String,
                    companyMap.get("country") as String,
                    companyMap.get("skills") as List<String>
            )

            companies.put(company.getId(), company)

        }

    }

}
