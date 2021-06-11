package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@GetMapping("login")
	public String login() {
		return "member.login";
	}
	
	//옛날방법 지금은 spring이 만들어줄거다
//	@PostMapping("login")
//	public String login(String uid, String pwd) {
//	
//	return "redirect:?";
//	}
	
	
	
}
