package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;
import com.simple.mapper.ScoreMapper;

@Service("xx") //scoreService이름으로 bean생성
//@Qualifier와 이름을 맞춰서 해준다
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreMapper scoreMapper;//새로 생성한 scoreMapper과 연결시킨다
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		scoreMapper.scoreRegist(vo);
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
		return scoreMapper.getList();
	}

	@Override
	public void scoreDelete(int index) {
		scoreMapper.scoreDelete(index);
		
	}
	
//	@Autowired
//	@Qualifier("scoreDAO")
//	private ScoreDAO scoreDAO;
//	
//	@Override
//	public void scoreRegits(ScoreVO vo) {
//		
//		scoreDAO.scoreRegits(vo);
//	}
//
//	//목록 불러오기
//	@Override
//	public ArrayList<ScoreVO> getList() {
//		
//		return scoreDAO.getList();//서비스 영역에서 처리할게 없다면 바로 리턴
//	}
//	
//	
//	@Override
//	public void scoreDelete(int index) {
//		scoreDAO.scoreDelete(index);
//		
//	}
}


















