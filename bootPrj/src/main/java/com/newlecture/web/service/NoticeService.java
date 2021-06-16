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
	int hitUp(int id); //자세한 페이지를 조회 -> 조회수 Up
	int likeToggle(int id); //좋아요를 클릭 -> 좋아요를 토글
	Notice get(int id);
	int delete(int id);
	
	int update(Notice notice);
	int getCount(String field, String query);
}
