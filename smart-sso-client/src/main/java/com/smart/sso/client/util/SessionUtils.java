package com.smart.sso.client.util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.smart.sso.client.constant.SsoConstant;
import com.smart.sso.client.model.SessionUser;

/**
 * 当前已登录用户Session工具
 * 
 * @author Joe
 */
public class SessionUtils {
    
	public static SessionUser getUser(HttpServletRequest request) {
		return (SessionUser) request.getSession().getAttribute(SsoConstant.SESSION_USER);
	}
	
	public static Integer getUserId(HttpServletRequest request) {
        return Optional.ofNullable(getUser(request)).map(u -> u.getId()).orElse(null);
    }

	public static void setUser(HttpServletRequest request, SessionUser sessionUser) {
		request.getSession().setAttribute(SsoConstant.SESSION_USER, sessionUser);
	}

	public static void invalidate(HttpServletRequest request){
		setUser(request, null);
		request.getSession().invalidate();
	}
}