package QuanLyKho.Security;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import QuanLyKho.Entity.auth;
import QuanLyKho.Entity.user_role;
import QuanLyKho.Entity.users;
import QuanLyKho.Untils.Constant;

public class FilterSystem implements HandlerInterceptor{
	Logger log4j = Logger.getLogger(FilterSystem.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log4j.info("this request : "+ request.getRequestURI());
		users user = (users) request.getSession().getAttribute(Constant.User_Infor);
		if (user == null) {
			response.sendRedirect(request.getContextPath() +"/login");
			return false;
		} else {
			log4j.info("this getServletPath : " + request.getServletPath());
			String url = request.getServletPath();
			if(!premission(user, url)) {
				response.sendRedirect(request.getContextPath()+"/error-denied");
				return false;
			}
			
		}
		return true;
	}
	
	public boolean premission(users user,String url) {
		if(url.contains("/home") || url.contains("/error-denied") || url.contains("/logout")) {
			return true;
		}
		user_role userRole =(user_role) user.getUser_roles().iterator().next();
		Set<auth> auths = userRole.getRoles().getAuths();
		for(Object obj : auths) {
			auth auth = (auth) obj;
//			log4j.info("maybe : " + url + " " + auth.getMenu().getUrl() );
			if(url.contains(auth.getMenu().getUrl())) {
				return auth.getPermision() == 1 ;
			}
		}
		return false;
	}

}
