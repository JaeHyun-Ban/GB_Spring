package com.team404.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter를 생성해준다
@AllArgsConstructor //모든 멤버변수 생성자 생성
@NoArgsConstructor //기본(빈) 생성자 생성
public class TestVO {
	
	//Lombok테스트
	
	private String id;
	private String pw;
	
	//게터, 세터, 생성자
	
}
