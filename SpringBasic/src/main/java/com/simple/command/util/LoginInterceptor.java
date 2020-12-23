package com.simple.command.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	//1. 인터셉터 클래스는 '스프링에서 제공'되는 'HandlerInterceptor클래스를 상속'받습니다.
	//2. 3가지 메서드를 오버라이딩해서 사용합니다
	
	//일반적으로 로그인, 세션처리에 이용됨
	//세션처리를 했다면 스프링설정파일에 빈으로 등록, <mvc:interceptor>태그를 사용한다
	@Override	//Controller를 실행하기 전 요청을 가로챈다
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("로그인 인터셉터 실행!");
		
		//session check
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id == null) { //인증값 X
			response.sendRedirect(request.getContextPath() + "/session/login");//다만 redirect가 컨트롤러와 같이 두번사용되면 안된다
			
			return false; //핸들러 메서드 실행 후 컨트롤러를 수행하지 않음
		} else { //로그인된 유저
			return true; //true리턴: 핸들러메서드 실행 후 컨트롤러를 수행해라
		}
		
		
	}

	@Override //Controller의 요청을 실행시킨 후 요청을 가로챈다
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override //ViewResolver처리 후 화면(view)으로 이동하기 전 요청을 가로챈다
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
	
	
}
