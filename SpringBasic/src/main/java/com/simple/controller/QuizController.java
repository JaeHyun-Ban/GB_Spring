package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz02VO;

@Controller //컴포넌트 스캔이 읽어서 bean으로 생성
@RequestMapping("/quiz")
public class QuizController {
	
	///////////////////////////////////////
	//quiz01, quiz02, quiz03화면을 동시에 처리
	//반환유형 void형으로 맞추고 맵핑값을 `배열로 전달`하면
	@RequestMapping({"/quiz01", "/quiz02", "/quiz03"})
	public void views() {}
	///////////////////////////////////////////////
	
	
	
	
	//quiz01화면 요청
	@RequestMapping("quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	//quiz01-sendBirth
	@RequestMapping(value = "sendBirth", method = RequestMethod.POST)
	public String sendBirth(@ModelAttribute("info") Quiz01VO vo) {
		
		System.out.println(vo.getYear() + vo.getMonth() + vo.getDay());
		
		return "quiz/quiz01_ok";
	}
	
	////////////////////////////////////////
	//quiz02화면요청
	@RequestMapping("quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(@ModelAttribute("info") Quiz02VO vo) {
		
		return "quiz/quiz02_ok";
	}
	
	///////////////////////////////////////////
	//quiz03
	@RequestMapping("quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	//form태그 값
//	@RequestMapping(value = "join2", method = RequestMethod.POST)
//	public String join2(@RequestParam(value = "id") String id,
//						@RequestParam("pw") String pw,
//						@RequestParam("pw_check") String pw_check,
//						RedirectAttributes ra) {
//		if(id == null || id == "") {//아이디를 적지 않았다면
//			ra.addFlashAttribute("msg", "아이디를 입력하세요");
//			
//			return "redirect:/quiz/quiz03";
//		} else if(!pw.equals(pw_check)) {//비밀번호가 다르다면
//			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
//			
//			return "redirect:/quiz/quiz03";
//		}else {//성공
//			ra.addFlashAttribute("id", id);
//			return "quiz/quiz03_ok";
//		}
//		
//	}
	///////////강사님 quiz03
	@RequestMapping(value = "join2", method = RequestMethod.POST)
	public String join2(@RequestParam(value = "id", required = false, defaultValue = "") String id,
						@RequestParam(value = "pw") String pw,
						@RequestParam(value = "pw_check") String pw_check,
						RedirectAttributes ra,
						Model model //값 받는용도
						) {
		
		if(id.equals("")) {//아이디 공백
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check)) {//비밀번호 다름
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else { //성공
			//아이디값 보내기
			model.addAttribute("id", id);//다음화면으로 id값 넘김
			return "quiz/quiz03_ok";
		}
		
	}
	
	
}











































