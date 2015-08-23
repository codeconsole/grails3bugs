# Grails 3.0.4 Bug Demonstrations


URLMappings.groovy "/cars"(resources: "car")  
  
[http://localhost:8080/cars] (http://localhost:8080/cars) works fine, BUT  
[http://localhost:8080/cars.json](http://localhost:8080/cars.json) or [http://localhost:8080/cars.xml](http://localhost:8080/cars.xml)  
  
results in a strange Whitelabel Error Page
