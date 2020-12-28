package com.team404.common.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team404.command.UserVO;

public class UserAuthHandler extends HandlerInterceptorAdapter{
	//유저의 권한 핸들러
	
	//회원페이지 관련된 요청이 들어왔을 때 요청을 가로채 처리할 인터셉터
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session =  request.getSession();//현재 유지중인 세션
		UserVO userVO = (UserVO) session.getAttribute("userVO");
		
		if(userVO == null) {//로그인 X
			
			response.sendRedirect(request.getContextPath() + "/user/userLogin");//절대경경로 + 로그인페이지 이동
			
			return false;
		} else {//로그인 O
			return true;//return이 중요함(true: 실행)
		}
		
		
		
		
	}
	
	
	
}






































