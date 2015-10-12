package example

class CarController {

    static scaffold = Car
    static responseFormats = ['html', 'json', 'xml']

    def index() {
    	println "Car index() method called."
    	super.index()
    }

}
