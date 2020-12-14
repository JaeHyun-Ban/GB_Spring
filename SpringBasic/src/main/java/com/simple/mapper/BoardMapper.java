package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.BoardVO;

public interface BoardMapper {

	// service에서 BoardMapper로 연결해서 정상적으로 동작되도록 변경

	// 1. 기존 service인터페이스 가져오기
	public void boardRegist(BoardVO vo); // board 등록 메서드

	public ArrayList<BoardVO> getList(); // 모든 게시물 가져오기

	public void boardDelete(int num); // 게시글 삭제 메서드
	
	//2. seriviceImpl에 BoardMapper를 @autowired 추가
	
	//3. boardMapper기능 으로 상속받은 메서드 변경 
	
	//4. 리소스폴더에 마이바티스 xml파일,  sql기능 작성
	
}
