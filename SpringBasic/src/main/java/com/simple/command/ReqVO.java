package com.simple.command;

import java.util.ArrayList;

public class ReqVO {
	
	//요청받을 파라미터 값을 대조해서 생성한다
	private String id;
	private String pw;
	private String name;
	private String age;
	private ArrayList<String> inter;
	
	public ReqVO() {}

	public ReqVO(String id, String pw, String name, String age, ArrayList<String> inter) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.inter = inter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public ArrayList<String> getInter() {
		return inter;
	}

	public void setInter(ArrayList<String> inter) {
		this.inter = inter;
	}
	
	
	
}



























