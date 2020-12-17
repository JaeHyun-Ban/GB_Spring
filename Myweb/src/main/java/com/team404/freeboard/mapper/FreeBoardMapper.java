package com.team404.freeboard.mapper;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;

public interface FreeBoardMapper {

	// 추상메서드 선언(service를 그대로 가져옴)
	public void regist(FreeBoardVO vo); //게시글 등록

	public ArrayList<FreeBoardVO> getList(); //게시글 가져오기

	public FreeBoardVO getContent(int bno); //상세 게시글 보기

	public int update(FreeBoardVO vo);

	public int delete(int bno);
}
