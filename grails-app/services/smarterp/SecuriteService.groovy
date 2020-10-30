package smarterp

import grails.gorm.transactions.Transactional

@Transactional
class SecuriteService {

    def serviceMethod() {

    }


    def encodePassword(String s) {
		return s.encodeAsSHA256()
	}

    String authenticate(String username, String password) throws SecurityException{
        println(username +"==="+password)
		def user = User.findByUsername(username)
		def warning = ""
         org.springframework.web.servlet.handler.DispatcherServletWebRequest request = org.springframework.web.context.request.RequestContextHolder.currentRequestAttributes()
	    javax.servlet.http.HttpSession session = request.session
		/*org.springframework.web.servlet.handler.DispatcherServletWebRequest request = org.springframework.web.context.request.RequestContextHolder.currentRequestAttributes()
		javax.servlet.http.HttpSession session = request.session*/
		//println "#######0pp  "+user.password
		if (password == username) {
			warning = "Vous devez changer votre mot de passe par défaut"
		}
		
		if (user && (password.encodeAsSHA256() == user.password) && user.enabled) {
			session.user = user
			session.realUser = user
			session.unite = getUserUniteDefaut(user)
			session.etablissement = session.unite?.etablissement
			session.authorities = user.roles*.role.authority

			return warning
			
		} else {
			throw new SecurityException("password incorrect ou utilisateur désactivé")
		}

	}

}
