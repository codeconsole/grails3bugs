# Grails 3.0.8 Bug Demonstrations

Note: this is a freshly created grails 3.0.8 application with the following modifications:

Car.groovy
CarController.groovy
CarSpec.groovy
URLMappings.groovy added: "/cars"(resources: "car")  
  
Added security plugin:
build.gradle added: compile "org.grails.plugins:spring-security-core:3.0.0.M1"
ran: s2-quickstart example User Role
Bootstrap.groovy - Created a Car and a User/password test/test

Grail 3 Bug:

http://localhost:8080/cars.json

3.0.0 to 3.0.6
Everything works as expected,
Page renders fine.

3.0.7 to 3.0.8
Security rule to rest controller completely ignored.
/cars.json results in a redirect to /login/auth
logging in with user test/test results in a 403 'Sorry, you're not authorized to view this page.'

Spring Security Bug on index page only on all Grails versions:

	'/':                ['permitAll'],
	'/error':           ['permitAll'],
	'/index':           ['permitAll'],
	'/index.gsp':       ['permitAll'],

Index rules not honored.  Both / and /index result in a redirect to /login/auth
http://localhost:8080/ 
http://localhost:8080/index

To demonstrate the bug, use run-app.
To demonstrate the fix, uncomment
// compile "org.grails:grails-core:3.0.6"  
in build.gradle (or change 3.0.8 to 3.0.6 in gradle.properties)