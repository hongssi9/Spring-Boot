package com.newlecture.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/notice/") //RequestMapping은 함수나 클래스에 사용 가능하지만, GetMapping은 함수에만...기능은 같다.
public class NoticeController {	
	
	//@Autowired //IOC컨테이너에 보관되어있는 객체를 자동으로 생성하는 역할
	//private NoticeService service; //컨테이너에 저장된 서비스 객체를 꺼내서 전역변수로 만들었다.
	
	@RequestMapping("list") //GetMapping과 차이는 없다.
	//@ResponseBody //리턴값을 사용자한테 보여주고 싶을때 그냥 반환만 받을 수 있게	
	public String list(
			@RequestParam(name = "p", defaultValue = "1") Integer page, //html에서 파라미터를 전달받는곳 @request
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		
		List<Notice> list = service.getList(page, field, query); //서비스 클래스에있는 getList(인자3개)값을 list에 넣자
		int count = service.getCount(field, query); //어떤 컬럼에서 어떤 데이터를
		
		model.addAttribute("list",list);//"list"라는 키값에 위에서 받아온 list데이터를 넣고 model로 전달된다.
		model.addAttribute("count",count);
		//test
		//return "admin/notice/list-react"; //->/admin/notice/list.html
		return "admin/notice/list";
	}
	
	
	@GetMapping("detail") //tiles와 연결하는 기본적인 양식,틀
	public String detail(int id, Model model) {	//1. 파라미터방식으로 String 형태로 리턴
		
		Notice notice = service.get(id); //서비스에 get이라는걸 구현		
		model.addAttribute("notice",notice);
		
		return "admin/notice/detail";	
		
	}
	
	@PostMapping("reg")
	public String reg(String title, String content) {	// ModelAndView
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriterId("testttt");
		
		service.insert(notice);
		
		
		return "redirect:list";	//객체 형태로 리턴 //list로 돌아감
		
	}
	
	@GetMapping("reg") 
	public ModelAndView reg(
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(defaultValue = "0") Integer x, 
			@RequestParam(defaultValue = "0") Integer y, 
			HttpServletResponse response ,
			@CookieValue(name = "test", defaultValue = "hi") String test,
			MultipartFile file
			) {
		
		if(test.equals("hi")) {
			Cookie cookie = new Cookie("test", "hello");
			cookie.setMaxAge(10*24*60*60);
			cookie.setPath("/");
			response.addCookie(cookie);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin.notice.reg");
		
		return mv;
	}
	
//	@Autowired
//	private NoticeDao noticeDao;

	@GetMapping("edit")
	public String edit(int id, Model model) {	
		
		Notice notice = service.get(id);
		model.addAttribute("notice",notice);
		
		//106~107    테스트
//		List<Notice> list = noticeDao.getListIn(new int[] {23,40,45}); 
//		model.addAttribute(list);
		
		return "admin.notice.edit";
		
	}
	
	@PostMapping("edit")
	public String edit(Notice notice) {
		
		service.update(notice);
		
		return "redirect:detail?id="+notice.getId();
	}
	
	

	
}
