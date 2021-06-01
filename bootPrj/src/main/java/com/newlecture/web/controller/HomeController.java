package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller //이 클래스가 view안에 있는줄 알고 return내용을 경로로 생각해서 그 파일을 찾아주고
//@RestController//Rest가 붙으면 return값이 html로 출력이 된다.
public class HomeController {

	@RequestMapping("/index")
//	@ResponseBody
	public String index() {

	
		
		return "/WEB-INF/view/index.jsp";
	}

//	@RequestMapping("/index")
//		public String list() {	
//			return "list";
//	}
//
//	@RequestMapping("/index")
//		public String list() {	
//			return "list";
//	}
}
