package example

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        get "/users(.$format)?"(controller:"user", action:"index")
        get "/users/$id(.$format)?"(controller:"user", action:"show")
        post "/users/$id(.$format)?"(controller:"user", action:"update")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
