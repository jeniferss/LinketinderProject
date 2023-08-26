package handlers

import model.Candidate
import model.Company
import validators.UserInput

class DataHandler {
    Map<Integer, Candidate> candidates = [:]
    Map<Integer, Company> companies = [:]

    void generateCompanyMockData(UserInput validator, CompanyHandler companyHandler, List<String> allowedSkills) {
        for (i in 0..<5) {
            Map companyMap = [:]
            companyMap["id"] = i + 1
            companyMap["name"] = "Empresa ${i}"
            companyMap["CNPJ"] = "${i}2345678912345"
            companyMap["description"] = "Descricao da Empresa ${i}"
            companyMap["email"] = "empresa${i}@email.com"
            companyMap["state"] = "S${i}"
            companyMap["zipcode"] = "${i}0000000"
            companyMap["country"] = "Pais da Empresa ${i}"
            companyMap["skills"] = [allowedSkills[new Random().nextInt(allowedSkills.size())]]

            companyHandler.createInstance(validator, companyMap, companies, allowedSkills)
        }

    }

    void generateCandidateMockData(UserInput validator, CandidateHandler candidateHandler, List<String> allowedSkills) {
        for (i in 0..<5) {
            Map candidateMap = [:]
            candidateMap["id"] = i + 1
            candidateMap["name"] = "Candidato ${i}"
            candidateMap["CPF"] = "${i}1234567891"
            candidateMap["age"] = "2${i}"
            candidateMap["description"] = "Descricao do Candidato ${i}"
            candidateMap["email"] = "candidato${i}@email.com"
            candidateMap["state"] = "S${i}"
            candidateMap["zipcode"] = "${i}0000000"
            candidateMap["skills"] = [allowedSkills[new Random().nextInt(allowedSkills.size())]]

            candidateHandler.createInstance(validator, candidateMap, candidates, allowedSkills)
        }

    }

    Map<Integer, Candidate> getCandidates() {
        return candidates
    }

    Map<Integer, Company> getCompanies() {
        return companies
    }

}
