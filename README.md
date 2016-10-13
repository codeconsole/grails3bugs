# Grails 3.2.0 Bug Demonstrations

Note: this is a freshly created **Grails 3.2.0** application with the following modifications:

	grails create-app example

**BUG** 

modified **UrlMappings.groovy** 

	"/sets"(resources: "flashCardSet") {} 

created **FlashCard.groovy** 

    String question
    String answer 

created **FlashCardSet.groovy**     

    String name
    static hasMany = [flashCards: FlashCard]

created **FlashCardController.groovy**  

    static scaffold = FlashCard 

created **FlashCardSetController.groovy**  

    static scaffold = FlashCardSet        

modified **BootStrap.groovy**
    
    FlashCardSet set = new FlashCardSet(name:'Commerical 172RG')
    FlashCard f = new FlashCard(question: 'question', answer: 'answer').save(flush: true)
    set.addToFlashCards(f)
    set.save(flush: true)

To demonstrate the bug, visit http://localhost:8080/sets.json

ERROR org.grails.web.errors.GrailsExceptionResolver - ClassCastException occurred when processing request: [GET] /sets.json
example.FlashCard cannot be cast to org.grails.datastore.mapping.proxy.EntityProxy. Stacktrace follows:
java.lang.reflect.InvocationTargetException: null
        at org.grails.core.DefaultGrailsControllerClass$ReflectionInvoker.invoke(DefaultGrailsControllerClass.java:210)
        at org.grails.core.DefaultGrailsControllerClass.invoke(DefaultGrailsControllerClass.java:187)
        at org.grails.web.mapping.mvc.UrlMappingsInfoHandlerAdapter.handle(UrlMappingsInfoHandlerAdapter.groovy:90)
        at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:963)
        at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:897)
        at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970)
        at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861)
        at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846)
        at org.springframework.boot.web.filter.ApplicationContextHeaderFilter.doFilterInternal(ApplicationContextHeaderFilter.java:55)
        at org.grails.web.servlet.mvc.GrailsWebRequestFilter.doFilterInternal(GrailsWebRequestFilter.java:77)
        at org.grails.web.filters.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:67)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.ClassCastException: example.FlashCard cannot be cast to org.grails.datastore.mapping.proxy.EntityProxy
        at org.grails.datastore.mapping.proxy.JavassistProxyFactory.getIdentifier(JavassistProxyFactory.java:56)
        at org.grails.orm.hibernate.proxy.SimpleHibernateProxyHandler.getProxyIdentifier(SimpleHibernateProxyHandler.java:145)
        at org.grails.orm.hibernate.proxy.SimpleHibernateProxyHandler.getIdentifier(SimpleHibernateProxyHandler.java:71)
        at org.grails.datastore.gorm.proxy.ProxyHandlerAdapter.getProxyIdentifier(ProxyHandlerAdapter.java:22)
        at org.grails.web.converters.marshaller.json.DomainClassMarshaller.asShortObject(DomainClassMarshaller.java:224)
        at org.grails.web.converters.marshaller.json.DomainClassMarshaller.marshalObject(DomainClassMarshaller.java:192)
        at org.grails.web.converters.marshaller.json.DomainClassMarshaller.marshalObject(DomainClassMarshaller.java:52)
        at grails.converters.JSON.value(JSON.java:184)
        at grails.converters.JSON.convertAnother(JSON.java:144)
        at org.grails.web.converters.marshaller.json.CollectionMarshaller.marshalObject(CollectionMarshaller.java:41)
        at org.grails.web.converters.marshaller.json.CollectionMarshaller.marshalObject(CollectionMarshaller.java:30)
        at grails.converters.JSON.value(JSON.java:184)
        at grails.converters.JSON.render(JSON.java:119)
        at org.grails.plugins.web.rest.render.json.DefaultJsonRenderer.renderJson(DefaultJsonRenderer.groovy:116)
        at org.grails.plugins.web.rest.render.json.DefaultJsonRenderer.renderJson(DefaultJsonRenderer.groovy:110)
        at org.grails.plugins.web.rest.render.json.DefaultJsonRenderer.render(DefaultJsonRenderer.groovy:91)
        at grails.artefact.controller.RestResponder$Trait$Helper.internalRespond(RestResponder.groovy:188)
        at grails.artefact.controller.RestResponder$Trait$Helper.respond(RestResponder.groovy:62)
        at grails.rest.RestfulController.index(RestfulController.groovy:64)
        at grails.transaction.GrailsTransactionTemplate$2.doInTransaction(GrailsTransactionTemplate.groovy:96)
        at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:133)
        at grails.transaction.GrailsTransactionTemplate.execute(GrailsTransactionTemplate.groovy:93)
        ... 14 common frames omitted

References:
https://github.com/grails/grails-core/issues/10221

    
