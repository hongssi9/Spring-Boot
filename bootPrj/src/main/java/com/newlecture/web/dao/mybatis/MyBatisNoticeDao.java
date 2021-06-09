package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Comment;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Repository //바구니에 담았다.
public class MyBatisNoticeDao implements NoticeDao {
	
//	@Autowired
	private SqlSession sqlSession; //매퍼 컨테이너에서 매퍼를 불러오기위한 도구	
	private NoticeDao mapper; //1 매퍼도 계속 쓰지 않기위해 전역변수로 만들기
	
	@Autowired //2 생성자로 만들어보자
	public MyBatisNoticeDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;		
		mapper = sqlSession.getMapper(NoticeDao.class);
	}



	@Override
	public Notice get(int id) {

		return mapper.get(id);
	}

	@Override
	public List<Notice> getList() {
		// TODO Auto-generated method stub
		return getList(0, 10, "title","");
	}

	@Override
	public List<Notice> getList(int offset, int size) {
		
		return getList(offset, size, "title","");
	}

	@Override
	public List<Notice> getList(int offset, int size, String field, String query) {
		
		return mapper.getList(offset, size, field, query);
	}

	@Override
	public int insert(Notice notice) {
	
		return mapper.insert(notice);
	}

	@Override
	public int update(Notice notice) {
		
		return mapper.update(notice);
	}

	@Override
	public int delete(int id) {
		
		
		return mapper.delete(id);
	}
	
	@Override
	public int getCount(String field, String query) {
		
		return mapper.getCount(field, query);
	}

	@Override
	public List<NoticeView> getViewList(int page, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getViewList(page, field, query);
	}

}
