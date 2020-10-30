package smartErp

class IndexController {
    def securiteService;
    def index() { }
    def auth() {
        println("iiii test"+params);
        org.springframework.web.servlet.handler.DispatcherServletWebRequest request = org.springframework.web.context.request.RequestContextHolder.currentRequestAttributes()
	    javax.servlet.http.HttpSession session = request.session
        //securiteService.authenticate(params.username,params.password)
        def warning = securiteService.authenticate(params.username, params.password)
		println(warning)
        def targetUri = params.targetUri ?: "/accueil"
        redirect(uri: targetUri)


    }
}
