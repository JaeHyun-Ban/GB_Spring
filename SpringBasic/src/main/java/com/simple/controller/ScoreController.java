package com.simple.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {
	
	//1st
//	private ScoreService service = new ScoreServiceImpl();//상속 객체 생성(부모 클래스로 저장) + 전역변수 지정
	
	//2nd: 스프링컨테이너에 직접 bean으로 생성하고 자동주입명령
//	@Autowired //bean찾는 순서 1.타입 2.이름
//	@Resource(name = "service") //bean찾는 순서 1.이름 2.타입
//	private ScoreService service;
	
	//3nd: @Service("이름")지정 + @Qualifier("이름") + servlet-context에 service등록
	@Autowired
	@Qualifier("xx") //명확하게 지정해주기
	private ScoreService service;
	
	//점수입력 화면 처리
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}
	
	//점수입력 폼처리
	@RequestMapping("/scoreForm")
	public String scoreForm(ScoreVO vo) {
		
		service.scoreRegist(vo);
		
		return "service/scoreResult";
	}
	
	
	//점수목록화면 요청
	@RequestMapping("/scoreList") //'/'이거 빼도됨
	public String scoreList(Model model) {
		
		ArrayList<ScoreVO> list =  service.getList();
		model.addAttribute("list", list);
		
		return "service/scoreList";
	}
	
	
	//점수 삭제 요청
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") int index) {
		
		service.scoreDelete(index);
		
		
		return "redirect:/service/scoreList";
	}
	
}































