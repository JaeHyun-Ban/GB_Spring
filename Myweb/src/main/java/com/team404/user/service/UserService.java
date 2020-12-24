package com.team404.user.service;

import com.team404.command.UserVO;

public interface UserService {

	public int idCheck(UserVO vo); // 아이디 중복체크
	public int join(UserVO vo);//회원가입

}
