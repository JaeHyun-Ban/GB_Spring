package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //해당 어노테이션이 붙어있는 클래스를 빈으로 생성해 줍니다
public class MainController {
	
	public MainController() {
		System.out.println("잘 생성됨...");
	}
	
	
	@RequestMapping("/") //어떤 요청이 들어왔을 때 해당 메서드로 연결
	public String home() {
		System.out.println("실행됨");
		//실행시킬 코드를 작성...
		
		

//		return "WEB-INF/views/home.jsp";//디스패쳐서블릿으로 반환
		return "home";
	}
	
	
}