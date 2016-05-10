package example

class UserController {

    static scaffold = User

    static allowedMethods = [save: "POST", update: ["POST", "PUT"], delete: "DELETE"]
}
