package app

import handlers.CandidateHandler
import handlers.CompanyHandler
import handlers.JobHandler
import handlers.LikeHandler
import model.Candidate
import model.Company
import model.Job
import model.Like
import validators.UserInput

class Linketinder {
    private boolean isApplicationRunning = true

    List<String> allowedSkills
    Map<Integer, Candidate> candidates
    Map<Integer, Company> companies
    Map<Integer, Job> jobs
    Map<Integer, Like> likes
    CandidateHandler candidateHandler
    CompanyHandler companyHandler
    JobHandler jobHandler
    LikeHandler likeHandler
    UserInput validator

    Linketinder(List<String> allowedSkills, Map<Integer, Candidate> candidates, Map<Integer, Company> companies, Map<Integer, Job> jobs, Map<Integer, Like> likes, CandidateHandler candidateHandler, CompanyHandler companyHandler, JobHandler jobHandler, LikeHandler likeHandler, UserInput validator) {
        this.allowedSkills = allowedSkills
        this.candidates = candidates
        this.companies = companies
        this.jobs = jobs
        this.likes = likes
        this.candidateHandler = candidateHandler
        this.companyHandler = companyHandler
        this.jobHandler = jobHandler
        this.likeHandler = likeHandler
        this.validator = validator
    }

    void displayOptions() {
        println "Escolha a opção que desaja realizar: "
        println "Digite 0 para CANCELAR."
        println "Digite 1 para CRIAR UM CANDIDATO."
        println "Digite 2 para CRIAR UMA EMPRESA."
        println "Digite 3 para LISTAR OS CANDIDATOS."
        println "Digite 4 para LISTAR AS EMPRESAS."
        println "---------------------------------"
        println "Digite 5 para ESCOLHER UMA EMPRESA E TESTAR A CRIAÇÃO DE VAGAS."
        println "Digite 6 para ESCOLHER UM USUÁRIO E TESTAR A CURTIDA DE VAGAS."
        println "Digite 7 para ESCOLHER UMA EMPRESA E TESTAR A CURTIDA DE USUÁRIO."
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
            case "5":
                companyHandler.displayInstanceList(companies)
                println ""
                println "Digite o ID da empresa em que deseja criar a vaga: "
                def companyId = Integer.parseInt(readUserInput())
                Company company = companies.get(companyId)

                def jobMap = jobHandler.readUserInputAndCreateJobMap(jobs, allowedSkills, company)
                jobHandler.createInstance(validator, jobMap, jobs, allowedSkills)
                break
            case "6":
                candidateHandler.displayInstanceList(candidates)
                println ""

                println "Digite o ID do usuário em que deseja curtir a vaga: "
                def candidateId = Integer.parseInt(readUserInput())
                Candidate candidate = candidates.get(candidateId)

                println ""
                jobHandler.displayInstanceList(jobs)

                println "Digite o ID da vaga que deseja curtir: "
                def jobId = Integer.parseInt(readUserInput())
                Job job = jobs.get(jobId)

                likeHandler.createUserLike(candidate, job, likes)
                break
            case "7":
                companyHandler.displayInstanceList(companies)
                println ""

                println "Digite o ID do empresa em que deseja curtir o candidato: "
                def companyId = Integer.parseInt(readUserInput())
                Company company = companies.get(companyId)

                candidateHandler.displayInstanceList(candidates)
                println ""

                println "Digite o ID do usuário que deseja curtir: "
                def candidateId = Integer.parseInt(readUserInput())
                Candidate candidate = candidates.get(candidateId)

                likeHandler.createCompanyLike(company, candidate, likes)
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
