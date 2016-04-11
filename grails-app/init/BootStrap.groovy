import example.*

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def switchUserRole = new Role(authority: 'ROLE_SWITCH_USER').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        def testUser = new User(username: 'test', password: 'test').save(flush: true)
        UserRole.create testUser, userRole, true
        UserRole.create testUser, switchUserRole, true    	
    }
    def destroy = {
    }
}
