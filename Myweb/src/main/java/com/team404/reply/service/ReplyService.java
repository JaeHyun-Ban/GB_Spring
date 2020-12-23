package com.team404.reply.service;

import java.util.ArrayList;

import com.team404.command.ReplyVO;
import com.team404.common.util.Criteria;

public interface ReplyService {
	
	public int replyRegist(ReplyVO vo);
	
//	public ArrayList<ReplyVO> getList(int bno);//댓글 리스트 요청
	public ArrayList<ReplyVO> getList(int bno, Criteria cri);//댓글 리스트 요청
	public int getTotal(int bno);//특정 게시글의 총 댓글 수
	
	public int update(ReplyVO vo);//댓글 수정

	public String getPw(int rno);//비밀번호 가져오기
	public int pwCheck(ReplyVO vo);//비밀번호 검증
	public int delete(ReplyVO vo);//댓글삭제

}












