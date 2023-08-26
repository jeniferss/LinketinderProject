package model

abstract class Person {
    private Integer id
    private String name
    private String description
    private String email
    private String zipcode
    private String state
    List<String> skills = []

    Integer getId() { return id }

    String getName() { return name }

    String getEmail() { return email }

    String getState() { return state }

    String getZipcode() { return zipcode }

    String getDescription() { return description }

    List getSkills() { return skills }

    void setId(Integer id) { this.id = id }

    void setName(String name) { this.name = name }

    void setEmail(String email) { this.email = email }

    void setState(String state) { this.state = state }

    void setZipcode(String zipcode) { this.zipcode = zipcode }

    void setDescription(String description) { this.description = description }

    void addSkill(String skill) { this.skills.add(skill) }

    void removeSkill(String skill) { this.skills.remove(skill) }

}
