package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.ReplyVO;
import com.team404.common.util.Criteria;
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
	@GetMapping("/getList/{bno}/{pageNum}") //jquery방식_ {bno}를 따로 뽑을 수 있다
	public ArrayList<ReplyVO> getList(@PathVariable("bno") int bno,
									  @PathVariable("pageNum") int pageNum){
		//1.화면에서 더보기 버튼을 생성하고, 처음실행될 때 pageNum 1번과 해당 게시글 번호를 보냅니다.
		//2.getList(bno cri)를 받는다
		//3.mybatis에 매개값이 2개 전달되는 경우는 @Param어노테이션을 사용한다
		Criteria cri = new Criteria(pageNum, 20);//20개의 데이터
		
		ArrayList<ReplyVO> list = replyService.getList(bno, cri);
		//게시글에 대한 total
		
		//맵에 키, value로 저장해서 반환
		
		return list;
	}
	
	//게시글 수정요청
	@PostMapping("/update")
	public int replyUpdate(@RequestBody ReplyVO vo) {//JSON값을 전달받아 VO형식까지 처리해주는 @requestBody(중요)
		//1. sql문을 두번실행(select검증, 업데이트) 
		//>>> sql을 두번날린다는 자체가 별로...
		//2. sql문을 한번에 실행
		//>>> sql문이 엄청 길어짐(복잡, 만든사람 아니면 해석이 힘들지도)
		
		
		//비밀번호 가져오기
//		String replyPw = replyService.getPw(vo.getRno());
//		System.out.println(replyPw);
		int result = replyService.update(vo); //수정 진행
		System.out.println(result);
		
		return result;
	}
	
	
	//게시글 삭제요청
	@PostMapping("/delete")
	public int delete(@RequestBody ReplyVO vo) {
		System.out.println(vo.toString());
//		int result = replyService.delete(vo);
		int result = replyService.pwCheck(vo);
		
		if(result == 1) {//성공
			return 0;
		} else {//실패
			return -1;
		}
		

	}
	
	
}

































