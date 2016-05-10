# Grails 3.1.6 Bug Demonstrations

Note: this is a freshly created **Grails 3.1.6** application with the following modifications:

	grails create-app example

added Spring Security plugin (**build.gradle** dependency block):

	compile "org.grails.plugins:spring-security-core:3.0.4" 

ran the following command to create a **User.groovy** class:

	s2-quickstart example User Role

**BUG** 
modified generated **UrlMappings.groovy** 

	"/users"(resources: "user") {}


References:


