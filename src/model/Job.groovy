package model

import groovy.transform.ToString

@ToString
class Job {
    private Integer id
    private String name
    private String description
    private Company company

    Job(Integer id, String name, String description, Company company) {
        this.id = id
        this.name = name
        this.description = description
        this.company = company
    }

    void setId(Integer id) { this.id = id }

    Integer getId() { return this.id }

    void setName(String name) { this.name = name }

    String getName() { return this.name }

    void setDescription(String description) { this.description = description }

    String getDescription() { return this.description }

    void setCompany(Company company) { this.company = company }

    Company getCompany() { return this.company }
}
