package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;
//인터페이스.java
import com.newlecture.web.entity.NoticeView;

//@Mapper //이걸쓰면 select한걸 읽어서 spring이 사용할 수 있게 만들어줌
public interface NoticeDao { //클래스 안만들어도되고 데이터 연고닫고 필요없고 조건문 필요없고 간단!
	
	Notice get(int id);//하나만 가져올때	
	//@Select("select * from Notice") 마이바티스는 오버로드를 지원하지않는다.(하나만 구현해야함)
	List<Notice> getList();//어러개를달라.. 필터링, 정렬, 페이징, 집계	
	List<Notice> getList(int offset, int size);
	List<Notice> getList(int offset,int size, String field, String query);
	
	int getCount(String field, String query);

	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	
	List<NoticeView> getViewList(int page, String field, String query);
	
}
