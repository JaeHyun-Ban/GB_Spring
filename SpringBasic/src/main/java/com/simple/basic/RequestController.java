package com.simple.basic;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller //컴포넌트 스캔이 읽어서 빈(bean)으로 생성
@RequestMapping("/request") //requset폴더경로로 들어오는 것은 여기로 들어옴
public class RequestController {

	//req_ex01화면 처리 메서드
	
//	@RequestMapping("/request/req_ex01") 
//	public void req_ex01() { //void는 경로가 들어온대로 이동한다
//		
//		System.out.println("/kkkk 실행됨");
//	}
	
	
	@RequestMapping("/req_ex01")
	public String req_ex01() {
			
		System.out.println("String 경로 실행됨");
		return "request/req_ex01";
	}
	
	//req_ex01.jsp경로
	//basic1요청 처리 (GET방식만 허용)
	@RequestMapping(value = "/basic1", method = RequestMethod.GET)
	public void basic1() {
		System.out.println("basic1 요청됨");
	}
	
	//basic2요청처리(POST방식만 허용 Get은 거절)
	@RequestMapping(value = "/basic2", method = RequestMethod.POST)
	public void basic() {
		System.out.println("basic2 요청됨");
		
	}
	
	//basic3요청처리(get방식만 허용)
	@GetMapping("/basic3") 
	public void basic3() {
		//@RequestMapping을 더 효율적으로 사용하지만 4버전이라 
		//실무에서 주로 사용하는 3버전과 맞지않아 사용하지 못할 듯
		System.out.println("basic3 요청됨");
	}
	
	//basic4요청처리(Post방식만 허용)
	@PostMapping("/basic4")
	public void basic4() {
		
		System.out.println("basic4 요청됨");
	}
	
	/////////////////////////////////////////////////////////
	//req_ex02 화면 처리
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "request/req_ex02";
	}
	
	//1st - 전통적 방법
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) { //요청값을 받는다
//		
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("pw"));
//		
//		return "request/req_ex02_result";
//	}
	
	//2nd - 어노테이션 방법
//	@RequestMapping("/param")
//	public String param(
//			@RequestParam("id") String id,
//			@RequestParam("pw") String pw,
//			@RequestParam("name") String name,
//			@RequestParam("age") int age,
//			@RequestParam(value = "inter", required = false, defaultValue = "") ArrayList<String> list) {
//		//@RequestParam은 필수가 아닌 파라미터일 경우 null을 지정하게 되는데 기본값의 설정으로 (defaultValue: 아무 값이 없을 시 채워줄 값)을 사용하며 ㄴ된다
//		//>대신 옵션(required = false)으로 조정할 수 있다
//		
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(name);
//		System.out.println(age);
//		//다중값인 경우에 list로 형태에 맞게 알아서 들어간다
//		System.out.println(list.toString());
//		
//		return "request/req_ex02_result";
//	}
	
	//3nd
	//커멘드 객체를 사용하는 방법
	@RequestMapping("/param")
	public String param(ReqVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		System.out.println(vo.getInter().toString());
		
		return "request/req_ex02_result";
	}
	
	//==================문제====================
	
	//req_quiz01 화면처리
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		return "request/req_quiz01";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw) {
		
//		System.out.println(id);
//		System.out.println(pw);
		if(id.equals("abc123") && pw.equals("xxx123")) {//성공
			
			return "request/req_quiz01_ok";
		} else {//실패
			return "request/req_quiz01_no";
		}
		
		
	}
	
	
	
}








































