package example

class UserController {

    static scaffold = User

    static allowedMethods = [save: "POST", update: ["POST", "PUT"], delete: "DELETE"]
    
    def index(Integer max) {
        println "I am a method that supports extensibility. The max entries I will list is ${max?:0}."
        super.index(max)
    }
}
