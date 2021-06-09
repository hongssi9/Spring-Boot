package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;


public interface NoticeService { 
	
	
	List<Notice> getList();
	List<Notice> getList(int page);
	List<Notice> getList(int page, String field, String query); //serviceimp.java
	//List<Notice> getList(int page, String field, String query, String colOreder, String asc);
	
	//관리자
	int insert(Notice notice);
	//int update(Notice notice);
	int hitUp(int id);
	int likeUp(int id);
	Notice get(int id);
	int delete(int id);
	
}
