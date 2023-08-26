package app

import handlers.CandidateHandler
import handlers.CompanyHandler
import model.Candidate
import model.Company
import validators.UserInput

class Linketinder {
    private boolean isApplicationRunning = true

    List<String> allowedSkills
    Map<Integer, Candidate> candidates
    Map<Integer, Company> companies
    CandidateHandler candidateHandler
    CompanyHandler companyHandler
    UserInput validator

    Linketinder(List<String> allowedSkills, Map<Integer, Candidate> candidates, Map<Integer, Company> companies, CandidateHandler candidateHandler, CompanyHandler companyHandler, UserInput validator) {
        this.allowedSkills = allowedSkills
        this.candidates = candidates
        this.companies = companies
        this.candidateHandler = candidateHandler
        this.companyHandler = companyHandler
        this.validator = validator
    }

    void displayOptions() {
        println "Escolha a opção que desaja realizar: "
        println "Digite 0 para CANCELAR."
        println "Digite 1 para CRIAR UM CANDIDATO."
        println "Digite 2 para CRIAR UMA EMPRESA."
        println "Digite 3 para LISTAR OS CANDIDATOS."
        println "Digite 4 para LISTAR AS EMPRESAS."
    }

    String readUserInput() {
        return System.in.newReader().readLine()
    }

    void executeAction(String userInput) {
        switch (userInput) {
            case "0":
                isApplicationRunning = false
                break
            case "1":
                def candidateMap = candidateHandler.readUserInputAndCreateInstanceMap(candidates, allowedSkills)
                candidateHandler.createInstance(validator, candidateMap, candidates, allowedSkills)
                break
            case "2":
                def companyMap = companyHandler.readUserInputAndCreateInstanceMap(companies, allowedSkills)
                companyHandler.createInstance(validator, companyMap, companies, allowedSkills)
                break
            case "3":
                candidateHandler.displayInstanceList(candidates)
                break
            case "4":
                companyHandler.displayInstanceList(companies)
                break
        }
    }

    void execute() {
        while (isApplicationRunning) {
            try {
                displayOptions()
                String userInput = readUserInput()
                executeAction(userInput)
            } catch (Exception ignored) {
                println "Oops, algo deu errado! Tente novamente."
            }
        }
    }
}
