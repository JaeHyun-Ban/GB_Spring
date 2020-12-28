package com.team404.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.UserVO;
import com.team404.user.service.UserService;

@Controller // 컨트롤러 bean
@RequestMapping("/user") // 경로 잡기
public class UserController {

	// 주소API승인키(90일_2021_3월...21?까지)
	// devU01TX0FVVEgyMDIwMTIyMzE1Mzc0NTExMDU4NzM=

	@Autowired
	@Qualifier("UserService") // 2가지 꼭..꼭...
	private UserService userService;

	// 회원가입 화면이동
	@RequestMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}

	// 회원가입 양식 처리
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO vo, RedirectAttributes ra) { // vo형태로 전달받기
//		System.out.println(vo.toString()); //확인완료

		int result = userService.join(vo);
		if (result == 1) {// 가입 성공
			ra.addFlashAttribute("msg", "가입을 축하합니다!");
		} else { // 가입 실패
			ra.addFlashAttribute("msg", "가입에 실패했습니다");
		}
		return "redirect:/user/userLogin";
	}

	// 로그인
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}

	// 로그인 처리
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(UserVO vo, RedirectAttributes ra, HttpSession session) {
//		// RequsetParam: name으로 넘김
////		System.out.println("로그인 실행됨");
//		System.out.println(vo.toString());
//		UserVO user = userService.login(vo);
////		System.out.println(user.toString());//확인용
//		if (user == null) {// 없다면
//			ra.addFlashAttribute("msg", "로그인 실패입니다");// 실패 메세지
//			return "user/userLogin";// 다시 로그인화면
//		} else {
//			session.setAttribute("userVO", user);// 회원기록 담아두기
//			return "redirect:/";// 홈화면 이동
//		}
//
//	}

	// 로그인 처리(ModelandView)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(UserVO vo) {
		
		//로그인 성공시 회원정보를 받아오고, 로그인 실패시 null을 반환
		UserVO result = userService.login(vo);
		ModelAndView mv = new ModelAndView();//뷰와 model정보를 동시에 저장하는 객체
		mv.setViewName("user/userLogin");//mv의 기본경로 설정 >>> model을 넣어주기
		
		//로그인 성공시 회원정보를 받아오고, 로그인 실패시 null을 반환
		if(result != null) {//로그인 O
			mv.addObject("login", result);
		} else { //로그인 X
			mv.addObject("msg", "아이디 비밀번호를 확인하세요");
		}
		
		return mv;//return 이후 postHandler가 실행된다
	}

	// 일반컨트롤러에서는 비동기요청 메서드는 ResponseBody를 붙여준다
	@ResponseBody // 응답요청을 viewResolve로 반환하는 것이 아닌, 요청이 들어온 곳으로 Response Header정보를 만들어서 보내준다.
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestBody UserVO vo) {
		// @RequestBody는 RestController와 함께한다
//		System.out.println(vo.getUserId());

		// 아이디(회원가입) 중복체크
		int result = userService.idCheck(vo);
		if (result == 0) { // 중복 X
			return 0;
		} else { // 중복 O
			return 1;
		}
		// 로그라웃
		// 로그인 구현 -> 권한 처리(중요, 필수)
	}

	// 마이페이지
	@RequestMapping("/userMypage")
	public String userMypage(HttpSession session, Model model) {
		
		
		//조인데이터에 대한 처리 방법
		UserVO vo = (UserVO) session.getAttribute("userVO");
		String userId = vo.getUserId();
		
		UserVO userInfo = userService.getInfo(userId);
//		System.out.println(userInfo);
		model.addAttribute("userInfo", userInfo);
		
		System.out.println("여기서 데이터 정보가 거쳐간다");
		return "user/userMypage";
	}

	// 로그아웃
	@RequestMapping("/userLogout")
	public String userLogout(HttpSession session) {
		session.invalidate();

		return "redirect:/";// 홈화면
	}

}




































