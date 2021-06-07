package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;

@Mapper //이걸쓰면 select한걸 읽어서 spring이 사용할 수 있게 만들어줌
public interface NoticeDao { //클래스 안만들어도되고 데이터 연고닫고 필요없고 조건문 필요없고 간단!
	
	Notice get(int id);//하나만 가져올때
	
	@Select("select * from Notice")
	List<Notice> getList();//어러개를달라.. 필터링, 정렬, 페이징, 집계
	
	List<Notice> getList(int padge);
	List<Notice> getList(int padge, String field, String query);
	

	int inser(Notice notice);
	int update(Notice notice);
	int delete(int id);
	
	
}
