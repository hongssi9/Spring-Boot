package com.newlecture.web.entity;

import java.util.Date;

public class Comment {
	// ID, CONTENT, REGDATE, WRITER_NICNAME, NOTICE_ID
	private int id;
	private String content;
	private Date regdate;
	private String writerNicName;
	private int noticeId;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, String content, Date regdate, String writerNicName, int noticeId) {
		super();
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.writerNicName = writerNicName;
		this.noticeId = noticeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getWriterNicName() {
		return writerNicName;
	}

	public void setWriterNicName(String writerNicName) {
		this.writerNicName = writerNicName;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", regdate=" + regdate + ", writerNicName="
				+ writerNicName + ", noticeId=" + noticeId + "]";
	}
	
	
}
