package com.newlecture.web.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("adminNoticeController")
public class NoticeController {
	@RequestMapping("/admin/notice/list")
	public String list() {	
		return "admin notice list";
	}
}
