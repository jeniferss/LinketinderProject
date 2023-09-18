package handlers

import model.Company
import model.Job
import validators.UserInput

class JobHandler extends InstanceHandler {

    @Override
    Map<String, ?> readUserInputAndCreateInstanceMap(Map<Integer, ?> jobs, List<String> allowedSkills) {
        Map<String, ?> jobsMap = [:]

        Integer id = generateInstanceId(jobs)
        jobsMap["id"] = id

        println 'Digite o nome: '
        String name = System.in.newReader().readLine()
        jobsMap["name"] = name

        println 'Digite a descrição: '
        String description = System.in.newReader().readLine()
        jobsMap["description"] = description

        return jobsMap
    }

    Map<String, ?> readUserInputAndCreateJobMap(Map<Integer, ?> jobs, List<String> allowedSkills, Company company) {
        Map<String, ?> jobsMap = readUserInputAndCreateInstanceMap(jobs, allowedSkills)
        jobsMap.put("company", company)

        return jobsMap
    }

    @Override
    boolean isInstanceMapValid(UserInput validator, Map<String, ?> instanceMap) {
        return false
    }

    @Override
    void createInstance(UserInput validator, Map<String, ?> jobMap, Map<Integer, ?> jobs, List<String> allowedSkills) {
        Job job = new Job(
                jobMap["id"] as Integer,
                jobMap["name"] as String,
                jobMap["description"] as String,
                jobMap["company"] as Company
        )

        jobs.put(job.getId(), job)
    }
}
