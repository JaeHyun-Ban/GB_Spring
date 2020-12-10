package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller //컴포넌트 스캔이 읽어서 bean으로 생성
@RequestMapping("/response") 
public class ResponseController {
	
	//화면처리
	@RequestMapping("/res_ex01")
	public String res_ex01() {
		
		return "response/res_ex01";
	}
	
	//model전달자 - 매서드 매개변수로 Model or ModelMap선언
	@RequestMapping("/res_ex02")
	public String res_ex02(Model model) {
		
		//addAttribute(키, 값)
		//serverTime이름으로 날짜를 저장
		model.addAttribute("serverTime", new Date());
		model.addAttribute("name", "홍길동");
		model.addAttribute("addr", "서울시");
		
		return "response/res_ex02";
	}
	
//	ModelAndView 객체: Model정보, 화면정보를 한번에 지정
	@RequestMapping("res_ex03")
	public ModelAndView res_ex03() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date());//전송 데이터 저장
		mv.addObject("name", "홍길동");
		
		mv.setViewName("response/res_ex03");//화면정보 저장
		
		return mv;//mv=값 + 주소
	}
	
	//@ModelAttribute() - request + model의 형태
	//화면에서 전달받은 값을 다음 화면으로 그대로 전달
	@RequestMapping("res_ex04")
	public String res_ex04(@ModelAttribute("num") String num,
						   @ModelAttribute("name") String name) {
		
		System.out.println("넘어온값: " + num);
		System.out.println("넘어온값: " + name);
		
		return "response/res_ex04";
	}
	

	@RequestMapping("res_ex05") //info이름으로 vo객체를 다음화면으로 전달
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		return "response/res_ex05";
	}
	
	///////////////////////////////////////////////////////////
	//리다이렉트와 리다이렉트 어트리뷰트
	
	//화면처리
	@RequestMapping("/res_redirect")
	public String res_redirect() {
		
		return "response/res_redirect";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes RA) {
		
		if(id.equals(pw)) {//로그인 성공(홈화면으로)
			return "response/res_redirect_ok";
		} else {//틀린경우 다시 로그인 페이지로
			//"redirect:/절대경로" - 다시 컨트롤러를 타게함
			//이때 화면에 1회성 데이터로 값을 전달하고 싶으면
			//RedirectAttributes객체를 사용하면 됩니다.(리다이렉트 시에 모델을 전달할 수 있음)
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
			
//			return "response/res_redirect"; //forward로 이동해서 주소가 login에서 변하지 않음
			return "redirect:/response/res_redirect";//다시 컨트롤러경로로 이동(sendRedirect처럼)
		}
		
	}
	
	//================QUIZ====================
	//배운걸로 뭐든 만들어보기
	//res_quiz01화면요청
	@RequestMapping("/res_quiz01")
	public String res_quiz01() {
		return "response/res_quiz01";
	}
	//res_quiz02화면요청
	@RequestMapping("/res_quiz02")
	public String res_quiz02() {
		return "response/res_quiz02";
	}
	//res_quiz03화면요청
	@RequestMapping("/res_quiz03")
	public String res_quiz03() {
		return "response/res_quiz03";
	}
	
	@RequestMapping(value = "res_login", method = RequestMethod.POST)
	public String res_login(@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							RedirectAttributes ra) {
		if(id.equals("kim12") && pw.equals("1234")) {//로그인 성공
			ra.addFlashAttribute("id", id);
			return "redirect:/response/res_quiz02";
		}else {//로그인 실패
			ra.addFlashAttribute("id", id);
			
			return "redirect:/response/res_quiz03";
		}
	}
	
}




























