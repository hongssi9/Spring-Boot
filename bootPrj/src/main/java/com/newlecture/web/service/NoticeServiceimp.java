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
		
		List<Notice> list = dao.getList();
		
		return list;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
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

}
