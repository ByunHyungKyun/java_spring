package com.spring.command;

import java.util.Date;

import com.spring.dto.BoardVO;

public class BoardRegistCommand {


	private String title  ; // 제목
	private String writer ; // 작성자
	private String content; // 내용
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setContent(this.content);
		board.setTitle(this.title);
		board.setWriter(this.writer);
		board.setRegdate(new Date());
		
		return board;
		
	}
	
	
	
	
	
	
	
}
