package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team404.command.UserVO;

@Controller //컨트롤러 bean
@RequestMapping("/user") //경로 잡기
public class UserController {
	
	//주소API승인키(90일_2021_3월...21?까지)
	//devU01TX0FVVEgyMDIwMTIyMzE1Mzc0NTExMDU4NzM=
	
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
	
	//일반컨트롤러에서는 비동기요청 메서드는 ResponseBody를 붙여준다
	@ResponseBody //응답요청을 viewResolve로 반환하는 것이 아닌, 요청이 들어온 곳으로 Response Header정보를 만들어서 보내준다.
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestBody UserVO vo) {
		//@RequestBody는 RestController와 함께한다
		System.out.println(vo.toString());

		//회원가입 중복체크
		
		
		return 1;
	}
	
	
	//마이페이지
	@RequestMapping("userMypage")
	public String userMypage() {
		return "user/userMypage";
	}
}






























