package com.newlecture.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //여기 매핑이 있어요~알려주는
@RequestMapping("/notice/")
public class NoticeController {
	
	@RequestMapping("list")
	public String list() {	
		return "notice list";
	}
	
	@GetMapping("reg")
	public String reg() {	
		return "admin notice reg";
	}
	
	@PostMapping("edit")
	public String edit() {	
		return "admin notice edit";
	}
}
