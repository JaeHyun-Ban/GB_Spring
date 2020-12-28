package com.team404.common.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team404.command.UserVO;

public class UserLoginSuccessHandler extends HandlerInterceptorAdapter{
	
	//로그인 이후에 실행되는 핸들러(PostHandler) 오버라이딩
	//1. login요청으로 들어올 때 실행되도록 등록
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//postHandler는 ModelAndView를 기본적으로 가지고 있다
		
		//login맵핑 컨트롤러에서는 ModelAndView를 반환합니다
		//modelAndView객체에 있는 모델의 데이터가 map의 형식으로 반환
		ModelMap mv = modelAndView.getModelMap();
		
		UserVO userVO = (UserVO) mv.get("login");//model에 담겨있는 userVO를 꺼냄
	
		if(userVO != null) {//로그인 O
			
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			
			response.sendRedirect(request.getContextPath());//로그인 성공시에는 홈화면으로
			
		}
		
	
	}
	

}


















