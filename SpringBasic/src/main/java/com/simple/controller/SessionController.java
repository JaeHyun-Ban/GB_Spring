package com.simple.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/session")
public class SessionController {
	
	//session폴더의 각각의 화면을 볼  수 있는 컨트롤러 생성
	
	//게시판 화면 이동 처리
	@RequestMapping("/login")
	public String login() {
		return "session/login";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "session/join";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "session/main";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		
		//인터셉터를 이용한 세션처리
		//마이페이지에서 세션정보가 없다면 Redirect를 이용해 로그인페이지로 이동
		//이렇게 처리할 페이지가 20개라면?
		if(session.getAttribute("user_id") == null) {
			return "redirect:/session/login";
		}
		
		return "session/mypage";
	}
	
	//form처리
	@RequestMapping(value = "/joinForm", method = RequestMethod.POST)
	public String joinForm(@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							@RequestParam("name") String name) {
		
		//가입처리 진행
		
		
		return "redirect:/session/main";//다시 컨트롤러
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public String loginForm(@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							//How to use HttpSession
							HttpSession session ) {
		
		//아이디가 admin, 비밀번호가 1234라면 로그인 성공이라고 가정
		if(id.equals("admin") && pw.equals("1234")){ //login success
			
			//세션에 VO나 id를 저장
			session.setAttribute("user_id", "admin");
			session.setAttribute("user_name", "홍길홍");
			
			return "redirect:/session/mypage";
			
		} else {//login fail
			
			return "redirect:/session/login";
			
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");//remove user_id session
		session.invalidate();//sessionInfo remove
		
		
		return "redirect:/"; //go home
	}
	
	
	
	
	
	
	
}















































