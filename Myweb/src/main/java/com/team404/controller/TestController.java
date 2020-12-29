package com.team404.controller;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileupload")
public class TestController {
	
	//화면처리
	@RequestMapping("/upload")
	public String upload() {
		return "fileupload/upload";
	}
	
}
