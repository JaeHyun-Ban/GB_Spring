package com.team404.freeboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;

@Service("freeBoardService") //이 패키지가 읽히고 있는 지 확인(component scan)
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Autowired //autowired로 잡아주기....싯팟!
	private FreeBoardMapper freeBoardMapper;
	
	@Override
	public void regist(FreeBoardVO vo) {
		//값이 넘어오는지 확인
		freeBoardMapper.regist(vo);
//		System.out.println(vo.toString());
	}
	
	@Override
	public ArrayList<FreeBoardVO> getList() {
		return freeBoardMapper.getList();
	}
	
	@Override
	public FreeBoardVO getContent(int bno) {
		return freeBoardMapper.getContent(bno);
	}

	@Override
	public int update(FreeBoardVO vo) {
		return freeBoardMapper.update(vo);
	}
	
	@Override
	public int delete(int bno) {
		
		return freeBoardMapper.delete(bno);
	}
	
}
