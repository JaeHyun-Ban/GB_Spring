package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러 bean
@RequestMapping("/user") //경로 잡기
public class UserController {
	
	//회원가입
	@RequestMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	
	//로그인
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}
	
	
	//마이페이지
	@RequestMapping("userMypage")
	public String userMypage() {
		return "user/userMypage";
	}
}






























