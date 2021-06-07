package com.newlecture.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;



@Controller //여기 매핑이 있어요~알려주는
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeDao service;
	
	// Dependency Ingection -> DI
	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		
		//this.noticeDao = noticeDao;
		
	}
	
//	public NoticeController() {
//		noticeDao = new ???();
//	}
	
	@RequestMapping("list")
	public String list(Model model){
		
		List<Notice> list = service.getList();
		model.addAttribute("list",list);
		
		return "notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		return "notice detail";
	}
	

}
