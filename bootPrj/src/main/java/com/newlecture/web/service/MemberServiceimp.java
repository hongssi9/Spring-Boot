package com.newlecture.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.entity.Member;


@Service
public class MemberServiceimp implements MemberService{

	@Autowired
	private MemberDao dao;
	
	@Override
	public Member getByUid(String uid) {
		
		Member member = dao.getByUid(uid);
		
		return member;
	}

	

}
