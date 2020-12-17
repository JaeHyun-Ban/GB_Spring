package com.team404.freeboard.service;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;

public interface FreeBoardService {
	
	//추상메서드 선언
	
	public void regist(FreeBoardVO vo);//게시글 등록
	public ArrayList<FreeBoardVO>getList();//게시글 가져오기
	public FreeBoardVO getContent(int bno);//상세게시글보기
	public int update(FreeBoardVO vo);
	public int delete(int bno);
	
	
}
