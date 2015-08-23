# Grails 3.0.4 Bug Demonstrations


URLMappings.groovy "/cars"(resources: "car")  
  
[http://localhost:8080/cars] (http://localhost:8080/cars) works fine, BUT  
[http://localhost:8080/cars.json](http://localhost:8080/cars.json) or [http://localhost:8080/cars.xml](http://localhost:8080/cars.xml)  
  
Results in a strange:  
###Whitelabel Error Page
  
This application has no explicit mapping for /error, so you are seeing this as a fallback.  
  
Sun Aug 23 12:19:47 PDT 2015  
There was an unexpected error (type=Not Acceptable, status=406).  
No message available  


