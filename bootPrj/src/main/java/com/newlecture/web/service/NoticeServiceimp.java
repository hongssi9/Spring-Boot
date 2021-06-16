package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

@Service
public class NoticeServiceimp implements NoticeService {

	@Autowired
	private NoticeDao dao;
	
	//@Autowired
	//private CommentDao commentDao; //자식에대한 내용이 필요하니까
	
			
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
		
//		for(Notice n : list) {
//			n.setComments(commentDao.getlistByNo)
//		}
			
		
		return list;
	}
	
	//결제를 입력하는 서비스 
	@Transactional//트랜잭션
	@Override
	public int insert(Notice notice) {
		//트랜잭션을 처리한다.
		//ACID
		//A-원자성
		//C-일관성
		//I-고립성
		//D-지속성
		
		
		
		
		return dao.insert(notice);
	}

	@Override
	public int hitUp(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int likeToggle(int id) {
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

	@Transactional
	@Override
	public int update(Notice notice) {
		notice.setHit(100);
		dao.update(notice);
		
		
		notice.setHit(0);
		dao.update(notice);
		
		return 0;
	}

	@Override
	public int getCount(String field, String query) {
		int result = dao.getCount(field, query);
		return result;
	}


}
