package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;

@Repository("scoreDAO") //scoreDAO이름으로 bean생성(@Repository = @Service)
public class ScoreDAOImpl implements ScoreDAO {

	//DB라고 가정
	private ArrayList<ScoreVO> list = new ArrayList<>();
	
	//DB관련된 작업
	@Override
	public void scoreRegits(ScoreVO vo) {
		// 복잡한 과정을 처리할 때 처리과정을 진행하는 곳
		// or 복잡하지 않다면 다음 영역으로 보내주는 역할
		System.out.println(vo.toString());
		list.add(vo);
	}
	
	@Override
	public ArrayList<ScoreVO> getList() {
		
		return list;
	}

}















