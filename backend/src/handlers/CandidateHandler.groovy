package handlers

import model.Candidate
import validators.UserInput

class CandidateHandler extends InstanceHandler {

    @Override
    Map<String, ?> readUserInputAndCreateInstanceMap(Map<Integer, ?> candidates, List<String> allowedSkills) {
        Map<String, ?> candidateMap = [:]

        Integer id = generateInstanceId(candidates)
        candidateMap["id"] = id

        println 'Digite o nome: '
        String name = System.in.newReader().readLine()
        candidateMap["name"] = name

        println 'Digite o CPF (ex. xxxxxxxxxxx): '
        String CPF = System.in.newReader().readLine()
        candidateMap["CPF"] = CPF

        println 'Digite a idade: '
        String age = System.in.newReader().readLine()
        candidateMap["age"] = Integer.parseInt(age)

        println 'Digite a descricao: '
        String description = System.in.newReader().readLine()
        candidateMap["description"] = description

        println 'Digite o email (ex. xxxx@xxx.com(.br)): '
        String email = System.in.newReader().readLine()
        candidateMap["email"] = email

        println 'Digite o estado (exs. SP, RJ, ES): '
        String state = System.in.newReader().readLine()
        candidateMap["state"] = state

        println 'Digite o CEP (ex. xxxxxxxx): '
        String zipcode = System.in.newReader().readLine()
        candidateMap["zipcode"] = zipcode

        List<String> skills = []
        allowedSkills.forEach { skill ->
            println "Conhece ${skill.toUpperCase()} ? [S] [N]"
            String hasSkill = System.in.newReader().readLine()
            if (hasSkill.toUpperCase() == "S") {
                skills.add(skill)
            }
        }
        candidateMap["skills"] = skills

        return candidateMap
    }

    @Override
    boolean isInstanceMapValid(UserInput validator, Map<String, ?> candidateMap) {
        try {
            assert validator.isAgeValid(candidateMap.get("age") as Integer)
            assert validator.isCPFValid(candidateMap.get("CPF") as String)
            assert validator.isEmailValid(candidateMap.get("email") as String)
            assert validator.isCEPValid(candidateMap.get("zipcode") as String)

            return true
        } catch (AssertionError ignored) {

        } catch (Exception ignored) {
            println "Alguma informação preenchida está incorreta. Por favor, tente novamente."
        }
        return false
    }

    @Override
    void createInstance(UserInput validator, Map<String, ?> candidateMap, Map<Integer, ?> candidates, List<String> allowedSkills) {

        if (isInstanceMapValid(validator, candidateMap)) {
            Candidate candidate = new Candidate(
                    candidateMap.get("id") as Integer,
                    candidateMap.get("name") as String,
                    candidateMap.get("description") as String,
                    candidateMap.get("email") as String,
                    candidateMap.get("state") as String,
                    candidateMap.get("zipcode") as String,
                    candidateMap.get("CPF") as String,
                    candidateMap.get("age") as Integer,
                    candidateMap.get("skills") as List<String>
            )

            candidates.put(candidate.getId(), candidate)

        }

    }

}
