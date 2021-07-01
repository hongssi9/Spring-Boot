package com.newlecture.web.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

@RestController("apiMemberController")
@RequestMapping("/api/member/")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("{uid}")
	public Map<String, Object> info(@PathVariable("uid") String uid){
		
		
		Member member = service.getByUid(uid);
		
		Map<String, Object> map = new HashMap<>();
		map.put("member", member);
		map.put("authorities", new String[] {});
		
		return map;
	}
}
