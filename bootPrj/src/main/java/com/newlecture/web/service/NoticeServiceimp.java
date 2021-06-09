package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

@Service
public class NoticeServiceimp implements NoticeService {

	@Autowired
	private NoticeDao dao;
			
	/*
	 * 1. 생성자 인젝션
	 * 2. Setter 인젝션
	 * 3. 필드 인젝션
	*/

	@Override
	public List<Notice> getList() {
		
		List<Notice> list = getList(1, null, null);
		
		return list;
	}
	
	@Override
	public List<Notice> getList(int page) {
		List<Notice> list = getList(page, null, null);
		return list;
	}

	@Override
	public List<Notice> getList(int page, String field, String query) {
		
		int offset = (page-1)*10; //1->0, 2->10, 3->20, 4->30 
		int size = 10;
		
		List<Notice> list = dao.getList(offset, size, field, query);
		
		return list;
	}
	


	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return dao.insert(notice);
	}

	@Override
	public int hitUp(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int likeUp(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Notice get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}



	
	@Override
	public int delete(int id) {

		return dao.delete(id);
	}


}
