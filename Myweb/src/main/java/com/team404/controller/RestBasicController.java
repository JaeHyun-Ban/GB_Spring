package com.team404.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.FreeBoardVO;

@RestController // @RequestBody + @ResponseBody가 합쳐진 형태의 어노테이션
public class RestBasicController {

	// 1. RestController는 기본적으로 return값이 리졸버 뷰로 전달되는게 아니라, 요청된 주소로 반환된다.
	// produces는 타입을 지정ㅊ해주면, 해당 타입으로 사용자에게 응답하겠다는 뜻이다
	@GetMapping(value = "/getText", produces = "text/plain; charset=utf-8")
	public String getText() {
		// 보내는 곳과 받는곳 서로 주고받는 자료형의 타입을 몰라서 보내도 받지를 못하는 것이다

		System.out.println("REST API실행됨");

		return "안녕하세요";
	}

	// 객체반환(produces는 객체를 보낼 때 기본형으로 json형식을 가진다.)
	// jackson-data-bind가 반드시 필요
	@GetMapping(value = "/getObject", produces = "application/json;charset=UTF-8")
	public FreeBoardVO getObject() {
		// 생성자 객체에 맞춰서 값을 대입
		return new FreeBoardVO(10, "헬로", "테스트", "테스트", null, null);
	}

	// 값을 받고 객체형태로 반환
	// get방식의 requestParam으로 필수값을 지정할 수 있다
	// http://localhost:8282/myweb/getCollection?key=블라블라&bno=1
	@GetMapping("getCollection")
	public ArrayList<FreeBoardVO> getCollection(@RequestParam("key") String key,
												@RequestParam("bno") int bno) {
		System.out.println("브라우저에서 넘어온 값:" + key);
		System.out.println("브라우저에서 넘어온 값:" + bno);

		ArrayList<FreeBoardVO> list = new ArrayList<FreeBoardVO>();

		return null;
	}


	@GetMapping("/getPath/{sort}/{rank}/{page}")
		public HashMap<String, Object> getPath(@PathVariable("sort") String sort,
											   @PathVariable("rank") String rank,
											   @PathVariable("page") String page){
			System.out.println(sort);
			System.out.println(rank);
			System.out.println(page);
			//...처리
			HashMap<String, Object> map = new HashMap<>();
			FreeBoardVO vo = new FreeBoardVO(1, "테스트", "테스트", "테스트", null, null);
			map.put("info", vo);
			return map;
		}
	
	
	//내서버에서 나한테 보내는건 또 다르다
	//1.보내는쪽에서 content-type를 작성해야한다
	
	
	//POST형식의 JSON형식으로 값을 받음, 객체로 반환
	//1.화면에서 JSON형식으로 넘어오는 데이터를 @RequsetBody어노테이션으로 맵핑
	//2.화면에서는 데이터를 보낼 때 content-type을 선언해서 데이터의 유형을 알려주어야 한다
	@PostMapping("/getJson")
	public ArrayList<FreeBoardVO> getJson(@RequestBody FreeBoardVO vo){
		//@RequestBody: 넘어오는 데이터의 형식을 알맞게 처리해서 VO에 넣어준다(어어어엄청 복잡한 작업이다)
		
		System.out.println(vo.toString());
		
		//...처리
		ArrayList<FreeBoardVO> list = new ArrayList<>();
		FreeBoardVO fvo = new FreeBoardVO();
		fvo.setTitle("반환결과입니다");
		list.add(fvo);
		
		return list;//YARC!ResponseBody에서 응답 받은것 확인
	}


}






















