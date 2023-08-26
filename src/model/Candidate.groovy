package model

import groovy.transform.ToString

@ToString
class Candidate extends Person {
    private String CPF
    private Integer age

    Candidate(Integer id, String name, String description, String email, String state, String zipcode, String CPF, Integer age, List<String> skills) {
        this.id = id
        this.name = name
        this.description = description
        this.email = email
        this.state = state
        this.zipcode = zipcode

        this.CPF = CPF
        this.age = age

        this.skills = skills
    }

    String getCPF() { return CPF }

    Integer getAge() { return age }

    void setCPF(String CPF) { this.CPF = CPF }

    void setAge(Integer age) { this.age = age }
}
