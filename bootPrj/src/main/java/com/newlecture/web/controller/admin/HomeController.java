package com.newlecture.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("adminHomeController") //중복이 있어 구분해주기 위한 이름
@RequestMapping("/admin/") //
public class HomeController {
	
	// /admin/index
	@GetMapping("index") //다수 작성 가능한 함수에 매핑 이름..
	public String index() {
		
		return "admin index page";
	}

	
	@PostMapping("upload") //파일 업로더 컨트롤러 부분
	public String upload(MultipartFile[] files, HttpServletRequest request) {
		
		for(MultipartFile file : files) {
			if(file.getSize() == 0) //파일 하나만 올린다면 오류가 나지않게 if문 줬다.
				continue;
			
		System.out.println(file.getSize());//파일이 몇개가 잘 보내졌는데 확인용
		
		String fileName = file.getOriginalFilename();
		
		ServletContext application = request.getServletContext();
		String path = "/upload";
		String realPath = application.getRealPath(path);
		
		File pathFile = new File(realPath);
		if(!pathFile.exists())
			pathFile.mkdirs();
		
		String filePath = realPath + File.separator + fileName;
		
		File saveFile = new File(filePath);
		
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return "ok";
	}
}
