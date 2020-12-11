package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;

@Service("BoardService") //bean등록 >> component-scan 꼭 확인
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("BoardDAO")
	private BoardDAO boardDAO;

	@Override
	public void boardRegist(BoardVO vo) {
		boardDAO.boardRegist(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() { //게시글 가져오기
		return boardDAO.getList();
	}

	@Override
	public void boardDelete(int num) {
		boardDAO.boardDelete(num);

	}

}
