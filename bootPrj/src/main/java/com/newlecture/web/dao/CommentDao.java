package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Comment;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface CommentDao {
	Comment get(int id);//하나만 가져올때	
	//@Select("select * from Notice") 마이바티스는 오버로드를 지원하지않는다.(하나만 구현해야함)
	List<Comment> getList();//어러개를달라.. 필터링, 정렬, 페이징, 집계	
	List<Comment> getList(int page);
	List<Comment> getList(int page, String field, String query);
	
	int getCount(String field, String query);

	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
}
