package model

import groovy.transform.ToString

@ToString
class Like {
    private Integer id;
    private Candidate candidate;
    private Company company;
    private Job job;

    Like(Integer id){
        this.id = id
    }

    void setId(Integer id) { this.id = id }

    Integer getId() { return this.id }

    void setCandidate(Candidate candidate){ this.candidate = candidate }

    Candidate getCandidate() { return this.candidate }

    void setCompany(Company company) { this.company = company }

    Company getCompany() { return this.company }

    void setJob(Job job) { this.job = job }

    Job getJob() { return this.job }
}
