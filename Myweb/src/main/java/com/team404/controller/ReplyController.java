package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.ReplyVO;
import com.team404.reply.service.ReplyService;

@RestController //비동기통신!! //@ResponseBody가 자동으로 생략된 형태의 컨트롤러
@RequestMapping("/reply") //주소 경로
public class ReplyController {
	

	@Autowired
	@Qualifier("replyService") //ReplyServiceImpl과 이름 맞춰주기
	private ReplyService replyService;
	
	//등록 요청
	@PostMapping(value = "/replyRegist")
	public int replyRegist(@RequestBody ReplyVO vo) {
		
		int result = replyService.replyRegist(vo);
			
		return result; //레스트컨트롤러 return결과는 호출구문으로 간다(ResponseBody로 넘긴다)
	}
	
	//목록요청
	@GetMapping("/getList/{bno}") //jquery방식_ {bno}를 따로 뽑을 수 있다
	public ArrayList<ReplyVO> getList(@PathVariable("bno") int bno ){
		//@PathVariable은 get방식에서 일반적으로도 사용할 수 있다
		
		ArrayList<ReplyVO> list = replyService.getList(bno);
		
		return list;
	}
	
	
}

































