package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller // bean
@RequestMapping("/service")
public class BoardServiceContorller {

	@Autowired
	@Qualifier("BoardService")
	private BoardService service;


	// 게시글 등록 화면 요청
	@RequestMapping("boardRegister")
	public String boardRegister() {
		return "service/boardRegister";
	}

	// 게시글 등록 요청
	@RequestMapping(value = "boardForm", method = RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		service.boardRegist(vo);

		return "service/boardResult";
	}

	// boardList요청
	@RequestMapping("boardList")
	public String boardList(Model model) {
		ArrayList<BoardVO> list = service.getList();//가져오고
		model.addAttribute("list", list);//모델에 담고(forward기능)
		
		return "service/boardList";
	}
	
	//삭제 요청
	@RequestMapping("boardDelete")
	public String boardDelete(@RequestParam("num") int num) {
		service.boardDelete(num);
		
		return "redirect:/service/boardList";
	}

}















