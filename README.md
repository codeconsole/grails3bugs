# Grails 3.1.6 Bug Demonstrations

Note: this is a freshly created **Grails 3.1.6** application with the following modifications:

	grails create-app example

added Spring Security plugin (**build.gradle** dependency block):

	compile "org.grails.plugins:spring-security-core:3.0.4" 

ran the following command to create a **User.groovy** class:

	s2-quickstart example User Role

**BUG** 

modified **UrlMappings.groovy** 

	"/users"(resources: "user") {}
	post "/users/$id"(controller:"user", action:"update")

created **UserController.groovy** 

    static scaffold = User
    static allowedMethods = [save: "POST", update: ["POST", "PUT"], delete: "DELETE"]

modified **application.js** 

modified **index.gsp** 

added **/grails-app/assets/bower_components** (latest angularjs) 


To demonstrate the bug, visit http://localhost:8080/

Click the button "Demonstrate Bug" with the Chrome console open and view the Network tab

    POST http://localhost:8080/users/1.json 405 (Method Not Allowed)

Notice that allowedMethods is ignored.

References:
https://github.com/grails/grails-core/issues/9926

    
