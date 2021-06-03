package com.newlecture.web.controller.admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/noticet/")
public class NoticeController {	
	@RequestMapping("list")
	//@ResponseBody //리턴값을 사용자한테 보여주고 싶을때 그냥 반환만 받을 수 있게
	public String list() {	
		//return "admin notice list";
		
		
		return "admin.notice.list"; //tiles에있는 <definition name= "admin.notice.list" 를 가져온다.
//		return "/WEB-INF/view/admin/notice/list.jsp";
	}
	
	//@RequestMapping(value = "reg", method = RequestMethod.GET) 예전방법
	@GetMapping("reg/{uid}/{id}")
	public String reg(
			@RequestParam(name = "f",defaultValue = "default" ) String field,
			@RequestParam(defaultValue = "0") Integer x, //자동으로 널값이면 "0"을 쓴다.
			@RequestParam(defaultValue = "0") Integer y, /* , HttpServletRequest request */
			@CookieValue(name = "test", defaultValue = "hi") String test, //이름이 있으면 test담기고 없으면 hi
			@PathVariable String uid, //이 변수를 주소 매핑으로 하면서 
			@PathVariable Integer id, //주소에 값을 넣으면 변수값이 변함
			MultipartFile file,
			HttpServletResponse response
			) {	
		
		if(test.equals("hi")) { //쿠키가 없으면 가져오게 하기
			   Cookie cookie = new Cookie("test", "hello"); //test왼쪽이 name 이고(29줄) 
			   cookie.setMaxAge(10*24*60*60); //브라우저가 닫혀도 10일동안 저장된다 (24시간 하루 * 10)
			   cookie.setPath("/"); //루트에있는 모든 클래스가 쿠키를 전달받는다.
			   response.addCookie(cookie);
		   }
		
		//1. servlet API를 이용한 방법 (옛날방법) 입력받아온것을 저장할때..
//		String x_= request.getParameter("x");
//		String y_= request.getParameter("y");
		
		//2. 파라미터 이름으로 자동 입력 ex값이 널이면~ 이걸 가져오고 아니면~ 가져온데이터를~
//		int x = 0;
//		
//		if(x != null && x.)
		
		
		//return String.format("x_:%s, y_:%s", x_, y_) + "<br>" + String.format("x_:%s, y_:%s", x, y);
		return String.format("x_:%d, y_:%d, result%d, field:%s, test cookie:%s, uid : %s, id:%d \n", x, y, x+y, field, test, uid, id);
	}
	
	@PostMapping("edit")
	public String edit() {	
		return "admin notice edit POST";
	}
	
	@RequestMapping("del")
	public String del() {	
		return "admin notice del";
	}
	
}
