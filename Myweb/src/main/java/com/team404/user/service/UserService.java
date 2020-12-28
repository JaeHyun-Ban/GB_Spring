package com.team404.user.service;

import com.team404.command.UserVO;

public interface UserService {

	public int idCheck(UserVO vo); // 아이디 중복체크
	public int join(UserVO vo);//회원가입
	public UserVO login(UserVO vo);//로그인
	public UserVO getInfo(String userId);//회원정보 조회

}
