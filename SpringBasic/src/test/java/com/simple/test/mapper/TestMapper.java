package com.simple.test.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.simple.command.BoardVO;

public interface TestMapper {
	// 인터페이스이름과 동일한 이름의 구현xml을 파일을 생성
	
	// 추상 메서드의 이름을 xml에서 사용
	public String getTime();
//	public int insert(BoardVO vo);//추가(insert)
	public int insert(Map<String, String> map);//추가(map)
	
	public ArrayList<BoardVO> getList();//조회(vo형태로 가져오기)
	public BoardVO getListOne(int num);//pk를 통한 단일 조회
	/////////////////////2개의 파라미터 전달 -> X
	public ArrayList<BoardVO> getListTwo(@Param("xxx") String name, @Param("yyy") String title);
	//String name은 @Param이름으로 전달
	
	public int update(BoardVO vo);//게시글 수정(성공여부 반환 = int)
	
	public boolean delete(int num);//삭제
	
	
}
