package com.newlecture.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //여기 매핑이 있어요~알려주는
public class NoticeController {
	@RequestMapping("/notice/list")
	public String list() {	
		return "notice list";
	}
}
