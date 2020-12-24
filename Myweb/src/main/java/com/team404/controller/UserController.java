package com.team404.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		if(result == 1) {//가입 성공
			ra.addFlashAttribute("msg", "가입을 축하합니다!");
		} else { //가입 실패
			ra.addFlashAttribute("msg", "가입에 실패했습니다");
		}
		
		return "redirect:/user/userLogin";
		
	}

	// 로그인
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
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
	}

	// 마이페이지
	@RequestMapping("userMypage")
	public String userMypage() {
		return "user/userMypage";
	}

}
