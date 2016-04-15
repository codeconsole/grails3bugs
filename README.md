# Grails 3.1.5 Bug Demonstrations

Note: this is a freshly created **Grails 3.1.5** application with the following modifications:

	grails create-app example

added Spring Security plugin (**build.gradle** dependency block):

	compile "org.grails.plugins:spring-security-core:3.0.4" 

ran the following command to create a **User.groovy** class:

	s2-quickstart example User Role

modified generated **application.groovy** (Creates **BUG #1** requires Gorm **5.0.4**)

	grails.gorm.default.constraints = { 
 	   '*'(nullable: true) 
	} 

modified **User.groovy** (Creates **BUG #2** - requires Gorm >= **5.0.3**) 

	static constraints = {
		enabled() // added this. Empty constrains are used for scaffolding display order.
		password blank: false, password: true
		username blank: false, unique: true
	}


**BUG #1** - Adding default constraints to application.groovy causes any class that has static column mappings throw an exception at startup

	static mapping = {
		password column: '`password`'
	}

	... nested exception is org.hibernate.MappingException: Repeated column in mapping for entity: example.User column: password (should be mapped with insert="false" update="false")
		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553)

References:

https://github.com/grails/grails-data-mapping/issues/695
https://github.com/grails/grails-data-mapping/issues/671




**BUG #2** - Empty constraints() cause the following startup ERRORs:

	ERROR org.grails.orm.hibernate.cfg.HibernateMappingBuilder - ORM Mapping Invalid: Specified config option [enabled] does not exist for class [example.User]!

References:

https://github.com/grails/grails-data-mapping/issues/696


