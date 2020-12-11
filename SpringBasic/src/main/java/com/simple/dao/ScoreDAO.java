package com.simple.dao;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreDAO {

	//서비스 클래스에서 구현할 메서드를 추상메서드로 선언
	public void scoreRegits(ScoreVO vo); //등록
	public ArrayList<ScoreVO> getList(); //목록
	public void scoreDelete(int index);
}
