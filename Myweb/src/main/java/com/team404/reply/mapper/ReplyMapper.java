package com.team404.reply.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.team404.command.ReplyVO;
import com.team404.common.util.Criteria;

public interface ReplyMapper {
	
	public int replyRegist(ReplyVO vo);
	
//	public ArrayList<ReplyVO> getList(int bno);//댓글 리스트 요청
	public ArrayList<ReplyVO> getList(@Param("bno") int bno, @Param("cri")Criteria cri);//
	//>마이바티스는 2개이상의 파라미터를 받을 때 @Param으로 이름을 지정해야 합니다.
	public int getTotal(int bno);//특정 게시글의 총 댓글 수

	public int update(ReplyVO vo); //게시글 수정

	public String getPw(int rno);
	
	public int pwCheck(ReplyVO vo);//비밀번호 검증
	public int delete(ReplyVO vo);
	
	
}
