import example.*

class BootStrap {

    def init = { servletContext ->
    	new Car(name: 'Ferrari').save(flush: true)
    }

    def destroy = {
    }
}
