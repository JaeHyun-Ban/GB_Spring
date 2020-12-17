package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.service.FreeBoardService;

@Controller // bean생성
@RequestMapping("/freeBoard")
public class freeBoardController {

	// 컨트롤러는 화면요청을 처리해 준다(분기점...?)
	// service객체를 추가해서 서비스 기능을 함께 동작 후 이동
	@Autowired // 컴포넌트 스캔과 연결
	@Qualifier("freeBoardService")
	private FreeBoardService freeBoardService;

	@RequestMapping("/freeList")
	public String freeList(Model model) {
		// 화면으로 넘어갈 글정보를 가지고 갈 수 있도록 처리getList()로 조회한 결과를 리스트화면에 출력
		ArrayList<FreeBoardVO> list = freeBoardService.getList();
		model.addAttribute("list", list);//model에 담는 이름은 명확하게 작성할 것
		return "freeBoard/freeList";
	}

	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}

	// 글등록
	@RequestMapping(value = "/registForm", method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo, RedirectAttributes ra) {
		freeBoardService.regist(vo);// insert 실행(mapper)
		ra.addFlashAttribute("msg", "정상적으로 등록처리 되었습니다");// 일회용 메세지 넘겨주기

		return "redirect:/freeBoard/freeList";
	}
	
//	@RequestMapping(value = "/freeDetail", method = RequestMethod.GET)
//	public String freeDetail(@RequestParam("bno") int bno, Model model) {
//		//화면으로 넘어갈때 bno기반의 데이터를 가지고 상세화면으로 가도록 getContent()로 처리
//		FreeBoardVO vo =  freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		return "freeBoard/freeDetail";
//	}
	
	//modify(글수정)와 detail(상세보기)의 형태가 같아 함께 처리
	@RequestMapping(value = {"/freeModify", "/freeDetail"}, method = RequestMethod.GET)
	public void freeModify(@RequestParam("bno") int bno, Model model) {
		//화면으로 넘어갈때 bno기반의 데이터를 가지고 상세화면으로 가도록 getContent()로 처리
		FreeBoardVO vo =  freeBoardService.getContent(bno);
		model.addAttribute("vo", vo);
		
		//void형 메서드는 반환결과(return)로 요청의 결과가 dispatcherServlet된다
	}
	
	//게시글 업데이트
	@RequestMapping(value = "/freeUpdate", method = RequestMethod.POST)
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes ra) {
		int result = freeBoardService.update(vo);

		if(result == 1) {//업데이트 성공
			ra.addFlashAttribute("msg", "정상적으로 수정되었습니다");
		} else { //업데이트 실패
			ra.addFlashAttribute("msg", "수정에 실패했습니다");
		}
		
		return "redirect:/freeBoard/freeList"; 		
	}
	
	//게시글 삭제
	@RequestMapping(value = "/freeDelete", method=RequestMethod.POST)
	public String freeDelete(@RequestParam("bno") int bno, RedirectAttributes ra) {
		int result = freeBoardService.delete(bno);
		if(result == 1) {
			ra.addFlashAttribute("msg", bno + "번 게시글이 삭제되었습니다" );
		} else {
			ra.addFlashAttribute("msg", "게시글 삭제에 실패했습니다");
		}
		
		
		return "redirect:/freeBoard/freeList";
	}
	
	
}

















