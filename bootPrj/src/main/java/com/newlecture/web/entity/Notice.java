package com.newlecture.web.entity;

import java.util.Date;
import java.util.List;

public class Notice {
	//ID, TITLE, WRITER_ID, CONTENT, REGDATE, HIT, FILES
	private Integer id;
	private String title;
	private String writerId;
	private String content;
	private Date regDate;
	private Integer hit;
	private Boolean pub;
	private String files;
	
	private List<Comment> comments; 
	
	public Notice() {
		
	}

//	public Notice(int id, String title, String writerId, String content, Date regDate, int hit, String files) {		
//		this.id = id;
//		this.title = title;
//		this.writerId = writerId;
//		this.content = content;
//		this.regDate = regDate;
//		this.hit = hit;
//		this.files = files;
//	}

	

	

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"title\":\"" + title + "\", \"writerId\":\"" + writerId + "\", \"content\":\"" + content
				+ "\", \"regDate\":\"" + regDate + "\", \"hit\":" + hit + ", \"files\":\"" + files + "\"}";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public Boolean getPub() {
		return pub;
	}

	public void setPub(Boolean pub) {
		this.pub = pub;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	

}
