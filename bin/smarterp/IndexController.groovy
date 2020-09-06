package smartErp

class IndexController {

    def index() { }
    def auth() {
        println("iiii test"+params);
       // session[] = "omar kourmou"
        org.springframework.web.servlet.handler.DispatcherServletWebRequest request = org.springframework.web.context.request.RequestContextHolder.currentRequestAttributes()
	    javax.servlet.http.HttpSession session = request.session
        session.user = "John"

        def targetUri = params.targetUri ?: "/"
        redirect(uri: targetUri)


    }
}
