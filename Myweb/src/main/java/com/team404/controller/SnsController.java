package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/snsBoard")
public class SnsController {
	
	@RequestMapping("/snsList")
	public String snsList() {
		return "snsBoard/snsList";
	}
	
	
}
