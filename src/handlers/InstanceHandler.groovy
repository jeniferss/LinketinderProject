package handlers

import validators.UserInput

abstract class InstanceHandler {
    Integer generateInstanceId(Map<Integer, ?> instanceList) {
        return Collections.max(instanceList.keySet()) + 1
    }

    abstract Map<String, ?> readUserInputAndCreateInstanceMap(Map<Integer, ?> instanceList, List<String> allowedSkills)

    abstract boolean isInstanceMapValid(UserInput validator, Map<String, ?> instanceMap)

    abstract void createInstance(UserInput validator, Map<String, ?> instanceMap, Map<Integer, ?> instanceList, List<String> allowedSkills)

    void displayInstanceList(Map<Integer, ?> instanceList) {
        for (instance in instanceList) {
            println instance.getValue().toString()
        }
    }

}
