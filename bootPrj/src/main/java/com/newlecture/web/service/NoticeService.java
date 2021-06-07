package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;


public interface NoticeService { 
	
	
	List<Notice> getList();
	
	//관리자
	int insert(Notice notice);
	int hitUp(int id);
	int likeUp(int id);
	
}
