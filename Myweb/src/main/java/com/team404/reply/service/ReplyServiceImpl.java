package com.team404.reply.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.ReplyVO;
import com.team404.common.util.Criteria;
import com.team404.reply.mapper.ReplyMapper;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int replyRegist(ReplyVO vo) {
		return replyMapper.replyRegist(vo);
	}
	
//	@Override
//	public ArrayList<ReplyVO> getList(int bno) {
//		return replyMapper.getList(bno);
//	}
	@Override
	public ArrayList<ReplyVO> getList(int bno, Criteria cri) {
		
		return replyMapper.getList(bno, cri);
	}
	
	@Override
	public int update(ReplyVO vo) {
		return replyMapper.update(vo);
	}
	
	@Override
	public String getPw(int rno) {
		return replyMapper.getPw(rno);
	}
	
	@Override
	public int delete(ReplyVO vo) {
		return replyMapper.delete(vo);
	}
	
	@Override
	public int pwCheck(ReplyVO vo) {
		
		return 0;
	}
}

























