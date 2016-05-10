# Grails 3.1.6 Bug Demonstrations

Note: this is a freshly created **Grails 3.1.6** application with the following modifications:

	grails create-app example

added Spring Security plugin (**build.gradle** dependency block):

	compile "org.grails.plugins:spring-security-core:3.0.4" 

ran the following command to create a **User.groovy** class:

	s2-quickstart example User Role

**BUG #2** 
modified generated **UrlMappings.groovy** 

	post “/users/$id(.$format)?"(controller:”user", action:"update”)






**BUG #2** - Empty constraints() cause the following startup ERRORs:

	ERROR org.grails.orm.hibernate.cfg.HibernateMappingBuilder - ORM Mapping Invalid: Specified config option [enabled] does not exist for class [example.User]!

References:

https://github.com/grails/grails-data-mapping/issues/696


