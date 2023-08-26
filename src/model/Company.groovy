package model

import groovy.transform.ToString

@ToString
class Company extends Person {
    private String CNPJ
    private String country

    Company(Integer id, String name, String description, String email, String state, String zipcode, String CNPJ, String country, List<String> skills) {
        this.id = id
        this.name = name
        this.description = description
        this.email = email
        this.state = state
        this.zipcode = zipcode

        this.CNPJ = CNPJ
        this.country = country

        this.skills = skills
    }

    String getCNPJ() { return CNPJ }

    String getCountry() { return country }

    void setCNPJ(String CNPJ) { this.CNPJ = CNPJ }

    void setCountry(String country) { this.country = country }

}
