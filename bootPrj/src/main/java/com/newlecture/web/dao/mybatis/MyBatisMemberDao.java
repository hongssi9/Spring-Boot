package com.newlecture.web.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.MemberDao;

public class MyBatisMemberDao implements MemberDao{
	
	@Autowired
	public MyBatisMemberDao() {
		mapper = session.getMapper(MemberDao.class);
	}
	
	@Override
	public Member getByUid(String uid) {
		return mapper.getByUid(uid);
	}
	
	
	
	
}
